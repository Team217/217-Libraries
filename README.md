# Team 217 - FRC Libraries

## Installation

1) Download the `.jar` files for the latest release [here](https://github.com/Team217/FRC-217-Libraries/releases/latest/). *If you do not download both files, then the Java documentation (information on how to use the classes and methods) will be unavailable.*
2) If it does not exist, reate a new `libs` folder in the project directory (NOT within the `src` folder). Put the `.jar` files there.
3) In `build.gradle`, find `dependencies { }` (near the bottom) and add the following line to the end of the list if it does not exist: `compile fileTree(dir: 'libs', include: ['*.jar'])`

## Information

Classes currently include:

- `Converter`
  - converts between encoder ticks and either angles or distances
- `Num`
  - numerical operations, such as `deadband()` and `isWithinRange()`
- `Logger`
  - logs data
- `BooleanOneShot`
  - manages a boolean one-shot, which flips a boolean flag when a trigger switches from low to high
- `motion.PID`
  - runs and controls PID systems
- `motion.TimedPID`
  - runs and controls PID systems on a timer
- `motion.TimedPIDController`
  - implements a PID control loop on a timer
- `motion.AccelController`
  - controls acceleration of a velocity
- `motion.MotionProfiler`
  - applies motion profiling to a velocity
- `motion.SimpleMotionController`
  - applies PID and acceleration control to control motion
- `motion.MotionController`
  - applies PID and motion profiling to control motion
- `motion.GeometricProfiler`
  - creates geometric motion profiles using sinusoidal waves
- `ctre.WPI_TalonSRX`
  - adds extra functions to the CTRE TalonSRX motor controller
- `ctre.WPI_TalonFX`
  - adds extra functions to the CTRE TalonFX motor controller
- `ctre.PigeonIMU`
  - adds extra functions to the CTRE PigeonIMU
- `ctre.JohnsonPLGEncoder`
  - manages pulses of the Johnson Electric PLG Hall Effect Sensors as a relative quadrature encoder
- `rev.CANSparkMax`
  - adds extra functions to the REV SparkMax motor controller
- `wpi.AnalogGyro`
  - adds extra functions to the Analog Gyro

[This Desmos link](https://www.desmos.com/calculator/ptmhn9qaeq) lets you mess with geometric profiler inputs and visualize the resulting profile.  
You can change a, s, v<sub>max</sub>, v<sub>0</sub>, and v<sub>f</sub> at the top to change the max acceleration, target distance, maximum velocity, initial velocity, and final velocity, respectively, and see the newly generated trajectory.  
V(t) shows the velocity path, and S(t) shows the position path. A(t) and D(t) are the acceleration and deceleration curves, respectively, and D<sub>offset</sub>(t) is the deceleration curve with the period offset. s<sub>accel</sub>, s<sub>decel</sub>, and s<sub>full</sub> are the distance traveled while accelerating, decelerating, and at full speed, respectively.
