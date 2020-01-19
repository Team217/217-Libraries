package org.team217;

public class AccelControl {
    /** The target acceleration, in units/second^2 */
    private double targetAccel;
    /** The maximum velocity, in units/second */
    private double maxVel;
    /** The period at which to update the vevlocity, in seconds */
    private double period = 0.02;

    /** The last velocity, in units/second */
    private double lastVel = 0;

    /**
     * Creates a new Acceleration Controller with the given target acceleration.
     * 
     * @param targetAccel
     *        The target acceleration, in units/second^2
     */
    public AccelControl(double targetAccel) {
        this(targetAccel, 1);
    }

    /**
     * Creates a new Acceleration Controller with the given target acceleration and maximum velocity.
     * 
     * @param targetAccel
     *        The target acceleration, in units/second^2
     * @param maxVel
     *        The maximum velocity, in units/second
     */
    public AccelControl(double targetAccel, double maxVel) {
        set(targetAccel, maxVel);
    }

    /**
     * Sets the target acceleration and maximum velocity of the controller.
     * 
     * @param targetAccel
     *        The target acceleration, in units/second^2
     * @param maxVel
     *        The maximum velocity, in units/second
     * @return
     *        {@code false} if the target acceleration or maximum velocity are not positive
     */
    public boolean set(double targetAccel, double maxVel) {
        return setTargetAccel(targetAccel) & setMaxVel(maxVel);
    }

    /**
     * Sets the target acceleration of the controller.
     * 
     * @param targetAccel
     *        The target acceleration, in units/second^2
     * @return
     *        {@code false} if the target acceleration is not positive
     */
    public boolean setTargetAccel(double targetAccel) {
        if (targetAccel <= 0) {
            return false;
        }
        this.targetAccel = targetAccel;
        return true;
    }

    /**
     * Sets the maximum velocity of the controller.
     * 
     * @param maxVel
     *        The maximum velocity, in units/second
     * @return
     *        {@code false} if the maximum velocity is not positive
     */
    public boolean setMaxVel(double maxVel) {
        if (maxVel <= 0) {
            return false;
        }
        this.maxVel = maxVel;
        return true;
    }

    /**
     * Sets the update period of velocity for the controller.
     * 
     * @param period
     *        The update period of velocity, in seconds
     * @return
     *        {@code false} if the period is not positive
     */
    public boolean setPeriod(double period) {
        if (period <= 0) {
            return false;
        }
        this.period = period;
        return true;
    }

    /**
     * Returns the target acceleration, in units/second^2.
     */
    public double getTargetAccel() {
        return targetAccel;
    }

    /**
     * Returns the maximum velocity, in units/second.
     */
    public double getMaxVel() {
        return maxVel;
    }

    /**
     * Returns the update period of velocity, in units/second.
     */
    public double getPeriod() {
        return period;
    }

    /**
     * Calculates and returns a velocity after applying acceleration control.
     * 
     * @param velocity
     *        The velocity to apply acceleration control to, in units/second
     */
    public double getOutput(double velocity) {
        velocity = Num.inRange(velocity, maxVel);
        double accel = (velocity - lastVel) / period;
        velocity += Num.sign(accel) * period * (targetAccel - Math.abs(accel));

        lastVel = velocity;
        return velocity;
    }

    /**
     * Resets the controller calculations to 0.
     */
    public void reset() {
        lastVel = 0;
    }
}