package ScriptedRobot.Commands;

import java.awt.*;

public class WaitCommand implements Callable {
    int delay;

    /**
     * Wait
     * @param delay - delay (ms)
     */
    public WaitCommand(int delay) {
        this.delay = delay;
    }
    @Override
    public void call() {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.delay(delay);
    }
}
