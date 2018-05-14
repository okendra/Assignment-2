import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy {

    private BufferedImage enemyAlive;
    private BufferedImage enemyDead;
    private BufferedImage imageCurrent;
    private int x;
    private int y;
    private int goalx;
    private int goaly;

    private static int MOVE_DISTANCE = 3;

    public Enemy(GameManager gameManager, int i, int j) {
        Goal goal = gameManager.getGoal();
        x = i;
        y = j;
        goalx = goal.getX();
        goaly = goal.getY();

        try {
            String projectRootDirectory = "/Users/olivierkendra/Documents/itp_workspace/ProgAssignment2";
            this.enemyAlive = ImageIO.read(new File(projectRootDirectory + "/enemy-alive.png"));
            this.enemyDead = ImageIO.read(new File(projectRootDirectory + "/enemy-dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.enemyAlive;
    }


    public void performAction() {
        if (imageCurrent == enemyAlive) {

            if (x < goalx) {
                x = x + MOVE_DISTANCE;
            } else if (x > goalx) {
                x = x - MOVE_DISTANCE;

            }

            if (y < goaly) {
                y = y + MOVE_DISTANCE;
            } else if (y > goaly) {
                y = y - MOVE_DISTANCE;
            }
        }

    }

    public void die() {
        imageCurrent = enemyDead;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getCurrentImage() {
        return imageCurrent;
    }

}