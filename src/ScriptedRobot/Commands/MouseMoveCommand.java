package ScriptedRobot.Commands;

import java.awt.*;

public class MouseMoveCommand implements Callable {
    int x;
    int y;

    /**
     * Переместить мышь на координату
     * @param x
     * @param y
     */
    public MouseMoveCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void call() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(x,y);
    }
}
