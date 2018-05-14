
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Goal {

    private BufferedImage imageAlive;
    private BufferedImage imageDead;
    private BufferedImage imageCurrent;
    private int x; // class members
    private int y; // class members

    // constructor parameters
    public Goal(int x, int y) {
        // catch the i and j here and store them in variables
        this.x = x;
        this.y = y;

        try {
            String projectRootDirectory = "/Users/olivierkendra/Documents/itp_workspace/ProgAssignment2"; // TODO: Don't make this hardcoded
            this.imageAlive = ImageIO.read(new File(projectRootDirectory + "/goal-alive.png"));
            this.imageDead = ImageIO.read(new File(projectRootDirectory + "/goal-dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.imageAlive;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void die() {
        imageCurrent = imageDead;
    }

    public BufferedImage getCurrentImage() {
        return imageCurrent;
    }

}
