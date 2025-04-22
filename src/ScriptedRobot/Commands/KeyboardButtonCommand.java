package ScriptedRobot.Commands;

import java.awt.*;

public class KeyboardButtonCommand implements Callable {
    int key;
    boolean down;

    /**
     * Simulate keyboard keypress
     * @param key  - VK_CODE of key
     * @param down - true - press/ false - release
     */
    public KeyboardButtonCommand(int key, boolean down) {
        this.key = key;
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
            robot.keyPress(key);
        else
            robot.keyRelease(key);
    }
}
