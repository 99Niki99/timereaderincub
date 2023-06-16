package us.nikita.timereaderincub.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * This class takes an image, resizes and colors it, and saves the new image in a separate folder.
 *
 * @author Nikita
 */

public class ImagePreparationForTesseract {

    private static final int WIDTH = 1050;
    private static final int HEIGHT = 1024;
    private static final Path PATH_FROM = Path.of("D:\\PhotoForTest\\photoTest1.jpg");
    private static final Path PATH_TO = Path.of("D:\\NewImage\\output4.png");

    /**
     * The method takes images and determines the axis of its change
     *
     * @param from Returns the address where we get the image from
     * @param to   Returns the address where we put the image
     * @throws IOException The exception may be caused by incorrect reading and writing of the image
     */
    public static void processImage(Path from, Path to) throws IOException {

        File addressImageForChange = from.toFile();

        BufferedImage imageForChange = ImageIO.read(addressImageForChange);

        ScalingFactors scalingFactor = ScalingFactors.getForImage(imageForChange);
        cropAndSave(imageForChange, scalingFactor.getScalingFactor(), scalingFactor.getOffset(), to);

    }

    /**
     * This method crops and saves the image in the specified folder.
     *
     * @param bufferImages Empty image buffer.
     * @param scaleFactor  Defined as the ratio between the scale of a given original object and a new object.
     * @param offset       It determines how high the brightness (magnification brightness) of the image is after scaling.
     * @param to           Returns the address where we put the image.
     * @throws IOException Usually occurs when there is a problem with reading or writing image.
     */
    private static void
    cropAndSave(BufferedImage bufferImages, float scaleFactor, float offset, Path to) throws IOException {
        BufferedImage newImage = new BufferedImage(WIDTH, HEIGHT, bufferImages.getType());

        Graphics2D graphicForNewImage = newImage.createGraphics();

        graphicForNewImage.drawImage(bufferImages, 0, 0,
                WIDTH, HEIGHT, null);
        graphicForNewImage.dispose();

        RescaleOp makeGrayScaling = new RescaleOp(scaleFactor, offset, null);

        BufferedImage performingScaling = makeGrayScaling.filter(newImage, null);
        ImageIO.write(performingScaling, "jpg", to.toFile());
    }


}
