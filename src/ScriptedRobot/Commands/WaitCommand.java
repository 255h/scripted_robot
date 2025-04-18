package ScriptedRobot.Commands;

import java.awt.*;

public class WaitCommand implements Callable {
    int delay;

    /**
     * Ожидать
     * @param delay - задержка в мс
     */
    public WaitCommand(int delay) {
        this.delay = delay;
    }
    @Override
    public void call() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.delay(delay);
    }
}
