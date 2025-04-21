package ScriptedRobot.Commands;

import java.awt.*;

public class KeyboardButtonCommand implements Callable {
    int key;
    boolean down;

    /**
     * Нажатие на клавишу клавиатуры
     * @param key  - Код клавиши
     * @param down - true - Нажать/ false - отпустить
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
