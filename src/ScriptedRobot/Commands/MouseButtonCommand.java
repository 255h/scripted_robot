package ScriptedRobot.Commands;

import java.awt.*;
import java.awt.event.InputEvent;


public class MouseButtonCommand implements Callable {
    int button;
    boolean down;
    int[] buttons = {InputEvent.BUTTON1_DOWN_MASK,InputEvent.BUTTON2_DOWN_MASK};

    /**
     * Simulate mouse click
     * @param button - 1 - left, 2 - right
     * @param down - true - press, false - release
     */
    public MouseButtonCommand(int button, boolean down) {
        this.button = button;
        this.down = down;
    }

    @Override
    public void call() {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        if (down)
            robot.mousePress(buttons[button]);
        else
            robot.mouseRelease(buttons[button]);
    }
}

