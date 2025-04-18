package ScriptedRobot.Commands;

import java.awt.*;

public class MouseWheelCommand implements Callable{
    int amount;

    public MouseWheelCommand(int amount) {
        this.amount = amount;
    }

    @Override
    public void call() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseWheel(amount);
    }
}
