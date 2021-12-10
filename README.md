# mouse-automove

## Background
My employee is financial institution, therefore a lot of securities were imposed on laptop. 
Although the laptop could have restricted access to internet, but any download will be blocked.
Setting was made so that the laptop will be lock after few minutes, good when in office, but a hassle when working from home.
Since download was blocked, so anti-idle application could not be downloaded and used.

Therefore, the app was born, so that I could make a coffee with ease of mind. 

## Introduction
**mouse-automove** is simple Java application that uses Java AWT **Robot API** to move mouse randomly.
- Pure Java 8 SDK only, without any other API library.
- Shutdown hook to close the timer properly with its queued task.
- Pause / resume the timer with 'p' keyboard input.

### Randomization Features
- Randomize the interval in seconds for each mouse movement, between 15 seconds to 60 seconds.
- Currently, two types of mouse movement set:
  - Mouse moved at random point on screen.
  - Mouse moved at edge of screen.
- Mouse move randomly:
  - Random number of movement per, between 3 and 10.
  - Random point on screen but linked from previous.
- Mouse move on edge:
  - Move from current mouse position to edge of screen.
  - Move to each corner of screen, and make it a round.
  - Random number of round, between 1 and 3.
  - Return to original mouse position when finished.

## Java API
Significant Java SDK API that was used:
- [Robot](https://docs.oracle.com/javase/8/docs/api/java/awt/Robot.html) - Component that allow automatic mouse movement, provided with specific coordinate. 
- [Timer](https://docs.oracle.com/javase/8/docs/api/java/util/Timer.html) - Background object to execute mouse move task in random intervals.
- [TimerTask](https://docs.oracle.com/javase/8/docs/api/java/util/TimerTask.html) - Runnable task to execute a set of mouse movement. 
- [Point](https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html) - Coordinate representation for where mouse would be moved.
- [Dimension](https://docs.oracle.com/javase/8/docs/api/java/awt/Dimension.html) - Height and width representation for screen resolution size.
- [SecureRandom](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html) - Random number generator for randomization feature.
- [GraphicsDevice](https://docs.oracle.com/javase/8/docs/api/java/awt/GraphicsDevice.html) - Provider for default screen resolution size.
- [GraphicsEnvironment](https://docs.oracle.com/javase/8/docs/api/java/awt/GraphicsEnvironment.html) - Provider for default screen used.
- [MouseInfo](https://docs.oracle.com/javase/8/docs/api/java/awt/MouseInfo.html) - Provider for current mouse pointer location.

## Usage
Script folder was provided with batch/shell scripts to compile and run.
- compile.sh / compile.bat: Perform compilation on java class and package class and manifest into jar file
- run.sh / run.bat: Execute jar file
```shell
./script/compile.bat
./script/compile.sh
./script/run.bat
./script/run.sh
```
Type 'p' in console and press 'Enter' to pause or resume.

## Development
Next plan:
- Create a mouse move to perform circular motion from center screen.

Pull request are welcome. Do contact me to learn more.

## License
MIT
- Feel free to use the codes and logics for whatever usage.