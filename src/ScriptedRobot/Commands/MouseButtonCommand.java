package ScriptedRobot.Commands;

import java.awt.*;
import java.awt.event.InputEvent;


public class MouseButtonCommand implements Callable {
    int button;
    boolean down;
    int[] buttons = {InputEvent.BUTTON1_MASK,InputEvent.BUTTON2_MASK};

    /**
     * Нажатие клавиши мыши
     * @param button - 1 - левая, 2 - правая
     * @param down - true - нажать, false - отпустить
     */
    public MouseButtonCommand(int button, boolean down) {
        this.button = button;
        this.down = down;
    }

    @Override
    public void call() {
        Robot robot = null;
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

