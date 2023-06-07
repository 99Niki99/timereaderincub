package us.nikita.timereaderincub.core;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class ImproveTextQuality {
    static Graphics2D graphicForNewImage;
    static BufferedImage makeNewImage;
    static BufferedImage perfomingScaling;
    protected static void processImg(BufferedImage bufferImages, float scaleFactor, float offset)
            throws IOException {

        makeNewImage(bufferImages);
        makeGrayScaling(bufferImages, scaleFactor, offset);
        saveNewImage();
    }

    private static void makeNewImage(BufferedImage bufferImages){
         makeNewImage = new BufferedImage(
                1050,
                1024,
                bufferImages.getType());
         graphicForNewImage = makeNewImage.createGraphics();
    }
    private static void makeGrayScaling(BufferedImage bufferImages, float scaleFactor, float offset){
        graphicForNewImage.drawImage(bufferImages,
                0, 0, 1050, 1024,
                null);      // drawing new image starting from 0 0. Of size 1050 x 1024 (zoomed images) null is the ImageObserver class object
        graphicForNewImage.dispose();
        RescaleOp makeGrayScaling = new RescaleOp(scaleFactor, offset, null);
        perfomingScaling = makeGrayScaling.filter(makeNewImage, null);
    }

    private static void saveNewImage() throws IOException {
        ImageIO.write(perfomingScaling, "jpg",
                new File("D:\\NewImage\\output2.png"));
    }


}
