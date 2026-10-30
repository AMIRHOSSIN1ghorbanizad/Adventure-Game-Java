
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class AdventureGame extends MIDlet {

    private GameScreen game;

    public void startApp() {
        if (game == null) {
            game = new GameScreen();
        }
        Display.getDisplay(this).setCurrent(game);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    class GameScreen extends Canvas {

        int x = 40;
        int y = 100;

        protected void paint(Graphics g) {
            int w = getWidth();
            int h = getHeight();

            g.setColor(100, 190, 255);
            g.fillRect(0, 0, w, h);

            g.setColor(30, 140, 40);
            g.fillRect(0, h - 35, w, 35);

            g.setColor(120, 70, 20);
            g.fillRect(x, y, 16, 20);

            g.setColor(0, 0, 0);
            g.drawString("ADVENTURE",
                5, 5, Graphics.TOP | Graphics.LEFT);

            g.drawString("Explore the world!",
                5, 25, Graphics.TOP | Graphics.LEFT);
        }

        protected void keyPressed(int keyCode) {
            int action = getGameAction(keyCode);

            if (action == LEFT) x -= 5;
            if (action == RIGHT) x += 5;
            if (action == UP) y -= 5;
            if (action == DOWN) y += 5;

            if (x < 0) x = 0;
            if (x > getWidth() - 16)
                x = getWidth() - 16;

            if (y < 35) y = 35;
            if (y > getHeight() - 55)
                y = getHeight() - 55;

            repaint();
        }
    }
}
