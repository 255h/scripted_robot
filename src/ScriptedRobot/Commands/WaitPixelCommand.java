package ScriptedRobot.Commands;

import java.awt.*;

public class WaitPixelCommand implements Callable{
    int x;
    int y;
    int r,g,b;

    /**
     * Wait for piexl color of R,G,B at X, Y экрана
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
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        boolean found = false;
        Color target = new Color(r, g, b);
        System.out.printf("Waiting for pixel [%d,%d,%d] at (%d,%d)\n", r,g,b,x,y );
        do {
            robot.delay(100);
            Color pixel = robot.getPixelColor(x, y);

            if (target.equals(pixel)){
                System.out.println("Pixel found!");
                found = true;
            }
        }while(!found);
    }
}
