# mouse-automove

## Background
My employer is financial institution, therefore a lot of securities were imposed on laptop.
Although the laptop could have restricted access to internet, but any download will be blocked.
Setting was made so that the laptop will be lock after few minutes, good when in office, but a hassle when working from home.
Since download was blocked, so anti-idle application could not be downloaded and used.

Therefore, the app was born, so that I could make a coffee with ease of mind.

## Introduction
**mouse-automove** is a simple Java application that uses Java AWT **Robot API** to move the mouse pointer.
- Pure Java 8 SDK only, without any other 3rd party API library.
- Shutdown hook to close the timer properly with its queued task.
- Pause / resume the timer with 'p' keyboard input.
- Exit the application 'e' keyboard input.

## Features
### Randomization Features
- Randomize the interval in seconds for each mouse pointer movement, between 15 seconds to 60 seconds.
- Currently, three types of mouse pointer movement set:
  - Mouse pointer moved to random point on screen.
  - Mouse pointer moved at edge of screen.
  - Mouse pointer moved in circular motion from middle point of screen.

### Movement
- Mouse pointer move randomly:
  - ![Random Move](https://media.giphy.com/media/Bm2n6isdf2wKrWHGOI/giphy.gif)
  - Random number of movement per set, between 3 and 10.
  - Random point on screen, but each will be linked from previous.
  - Return to original mouse pointer position when finished.
- Mouse pointer move on edge:
  - ![Edge Move](https://media.giphy.com/media/nM8zkb2ymisPQfSxAA/giphy.gif)
  - Move mouse pointer from current position to top left corner of screen.
  - Move to each corner of screen, and make it a round.
  - Random number of round, between 1 and 3.
  - Return to original mouse pointer position when finished.
- Mouse pointer move in circular motion:
  - ![Circular Move](https://media.giphy.com/media/4QVq3HIBKfhjdT0qpC/giphy.gif)
  - Move mouse pointer from current position to the middle of screen.
  - Radius of circle is calculated based on screen height and width.
  - Move to 0<sup>o</sup> along positive x-axis, based on radius.
  - Move in full circular motion from 0<sup>o</sup> until 360<sup>o</sup>.
  - Random number of circular round, between 1 and 3.
  - Return to middle of screen and back to original mouse pointer position when finished.

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

During application started:
- Type 'p' in console and press 'Enter' to pause or resume.
- Type 'e' in console and press 'Enter' to exit.

## Development
Next plan:
- Create configurable properties for number of intervals, random step, and rounds for edge and circular movement.

Pull request are welcome. Do contact me to learn more.

## License
MIT
- Feel free to use the codes and logics for whatever usage.
