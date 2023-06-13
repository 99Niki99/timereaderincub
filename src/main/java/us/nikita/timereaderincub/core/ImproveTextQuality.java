package us.nikita.timereaderincub.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * that class takes an image, changes its color correction and saves it in another folder
 *
 * @author Nikita
 */

public class ImproveTextQuality {

    private static final int WIDTH = 1050;
    private static final int HEIGHT = 1024;

    public static void
    processImg(BufferedImage bufferImages, float scaleFactor, float offset) throws IOException {
        BufferedImage makeNewImage = new BufferedImage(WIDTH, HEIGHT, bufferImages.getType());

        Graphics2D graphicForNewImage = makeNewImage.createGraphics();

        graphicForNewImage.drawImage(bufferImages, 0, 0,
                WIDTH, HEIGHT, null);
        graphicForNewImage.dispose();

        RescaleOp makeGrayScaling = new RescaleOp(scaleFactor, offset, null);

        BufferedImage performingScaling = makeGrayScaling.filter(makeNewImage, null);
        ImageIO.write(performingScaling, "jpg", new File("D:\\NewImage\\output2.png"));
    }

    public static void main(String[] args) throws Exception {
        File addressImageForChange = new File(
                "D:\\PhotoForTest\\photoTest1.jpg");

        BufferedImage takeImageForChange = ImageIO.read(addressImageForChange);

        double readSizeImage
                = takeImageForChange
                .getRGB(takeImageForChange.getTileWidth() / 2,
                        takeImageForChange.getTileHeight() / 2);

        if (readSizeImage >= ScalingFactors.TYPE_ONE.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_ONE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_ONE.getScalingFactor(), ScalingFactors.TYPE_ONE.getOffset());
        } else if (readSizeImage >= ScalingFactors.TYPE_TWO.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_TWO.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_TWO.getScalingFactor(), ScalingFactors.TYPE_TWO.getOffset());
        } else if (readSizeImage >= ScalingFactors.TYPE_THREE.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_THREE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_THREE.getScalingFactor(), ScalingFactors.TYPE_THREE.getOffset());
        } else if (readSizeImage >= ScalingFactors.TYPE_FORE.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_FORE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_FORE.getScalingFactor(), ScalingFactors.TYPE_FORE.getOffset());
        } else if (readSizeImage >= ScalingFactors.TYPE_FIVE.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_FIVE.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_FIVE.getScalingFactor(), ScalingFactors.TYPE_FIVE.getOffset());
        } else if (readSizeImage >= ScalingFactors.TYPE_SIX.getBottomBorder() && readSizeImage < ScalingFactors.TYPE_SIX.getTopBorder()) {
            processImg(takeImageForChange, ScalingFactors.TYPE_SIX.getScalingFactor(), ScalingFactors.TYPE_SIX.getOffset());
        }
    }
}
