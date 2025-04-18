package ScriptedRobot.Commands;

import java.awt.*;

public class WaitPixelCommand implements Callable{
    int x;
    int y;
    int r,g,b;

    /**
     * Ожидать цвет R,G,B на координатах X, Y экрана
     * @param x - x
     * @param y - y
     * @param r - r
     * @param g - g
     * @param b - b
     */
    public WaitPixelCommand(int x, int y, int r, int g, int b) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void call() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        boolean found = false;
        Color target = new Color(r, g, b);

        do {
            robot.delay(500);
            Color pixel = robot.getPixelColor(x, y);

            if (target.equals(pixel)){
                found = true;
            }
        }while(!found);
    }
}
