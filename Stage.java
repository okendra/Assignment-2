import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Stage {
    private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;

    public Stage() {
        try {
            String projectRootDirectory = "/Users/olivierkendra/Documents/itp_workspace/ProgAssignment2"; // TODO: Figure out how to get the current directory of the project
            this.imageRunning = ImageIO.read(new File(projectRootDirectory + "/stage-normal.png"));
            this.imageOver = ImageIO.read(new File(projectRootDirectory + "/stage-gameover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.imageRunning;
    }

    public BufferedImage getCurrentImage() {
        return this.imageCurrent;
    }

    public void setGameOverBackground() {
        this.imageCurrent = this.imageOver;
    }

}