package ScriptedRobot.Commands;

import java.awt.*;

public class MouseMoveCommand implements Callable {
    int x;
    int y;

    /**
     * Move mouse to coordinate
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public MouseMoveCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void call() {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(x,y);
    }
}
