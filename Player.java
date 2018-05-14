
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {

    private char lastPressedKey;
    private boolean isKeyPressed;
    private BufferedImage playerAlive;
    private BufferedImage playerDead;
    private BufferedImage imageCurrent;
    private int x;
    private int y;

    private static int MOVE_DISTANCE = 18;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            String projectRootDirectory = "/Users/olivierkendra/Documents/itp_workspace/ProgAssignment2";
            this.playerAlive = ImageIO.read(new File(projectRootDirectory + "/player-alive.png"));
            this.playerDead = ImageIO.read(new File(projectRootDirectory + "/player-dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.playerAlive;
        this.lastPressedKey = 'L';
    }

    // Moves the player. We know which direction to move judging by the currently pressed key.
    public void performAction() {
        if (imageCurrent == playerAlive) {

            if (lastPressedKey == 'D') {
                y += MOVE_DISTANCE;
            } else if (lastPressedKey == 'U') {
                y -= MOVE_DISTANCE;
            } else if (lastPressedKey == 'L') {
                x -= MOVE_DISTANCE;
            } else if (lastPressedKey == 'R') {
                x += MOVE_DISTANCE;
            }
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void die() {
        imageCurrent = playerDead;
    }

    public BufferedImage getCurrentImage() {
        return imageCurrent;
    }


    public void setKey(char c, boolean b) {
        if (c == lastPressedKey && isKeyPressed && !b) {
            isKeyPressed = false;
        } else if (!isKeyPressed) {
            lastPressedKey = c;
            isKeyPressed = true;
        }
    }

}