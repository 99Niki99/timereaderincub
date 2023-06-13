package us.nikita.timereaderincub.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * This class takes an image, resizes and colors it, and saves the new image in a separate folder.
 *
 * @author Nikita
 */

public class ImproveTextQuality {

    private static final int WIDTH = 1050;
    private static final int HEIGHT = 1024;

    /**
     * This method crops and saves the image in the specified folder.
     *
     * @param bufferImages empty image buffer
     * @param scaleFactor  defined as the ratio between the scale of a given original object and a new object
     * @param offset       It determines how high the brightness (magnification brightness) of the image is after scaling.
     * @throws IOException usually occurs when there is a problem with reading or writing image.
     */
    public static void
    processImg(BufferedImage bufferImages, float scaleFactor, float offset) throws IOException {
        BufferedImage makeNewImage = new BufferedImage(WIDTH, HEIGHT, bufferImages.getType());

        Graphics2D graphicForNewImage = makeNewImage.createGraphics();

        graphicForNewImage.drawImage(bufferImages, 0, 0,
                WIDTH, HEIGHT, null);
        graphicForNewImage.dispose();

        RescaleOp makeGrayScaling = new RescaleOp(scaleFactor, offset, null);

        BufferedImage performingScaling = makeGrayScaling.filter(makeNewImage, null);
        ImageIO.write(performingScaling, "jpg", new File("D:\\NewImage\\output3.png"));
    }

    /**
     * The method takes images and determines the axis of its change
     *
     * @throws IOException The exception may be caused by incorrect reading and writing of the image
     */
    public static void axisOfChangeSpecifier() throws IOException {
        File addressImageForChange = new File(
                "D:\\PhotoForTest\\photoTest1.jpg");

        BufferedImage takeImageForChange = ImageIO.read(addressImageForChange);

        double getSizeImage
                = takeImageForChange
                .getRGB(takeImageForChange.getTileWidth() / 2,
                        takeImageForChange.getTileHeight() / 2);

        if (getSizeImage >= ScalingFactors.TYPE_ONE.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_ONE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_ONE.getScalingFactor(), ScalingFactors.TYPE_ONE.getOffset());

        } else if (getSizeImage >= ScalingFactors.TYPE_TWO.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_TWO.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_TWO.getScalingFactor(), ScalingFactors.TYPE_TWO.getOffset());

        } else if (getSizeImage >= ScalingFactors.TYPE_THREE.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_THREE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_THREE.getScalingFactor(), ScalingFactors.TYPE_THREE.getOffset());

        } else if (getSizeImage >= ScalingFactors.TYPE_FORE.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_FORE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_FORE.getScalingFactor(), ScalingFactors.TYPE_FORE.getOffset());

        } else if (getSizeImage >= ScalingFactors.TYPE_FIVE.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_FIVE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_FIVE.getScalingFactor(), ScalingFactors.TYPE_FIVE.getOffset());

        } else if (getSizeImage >= ScalingFactors.TYPE_SIX.getBottomBorder() && getSizeImage <
                ScalingFactors.TYPE_SIX.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_SIX.getScalingFactor(), ScalingFactors.TYPE_SIX.getOffset());
        }
    }
}
