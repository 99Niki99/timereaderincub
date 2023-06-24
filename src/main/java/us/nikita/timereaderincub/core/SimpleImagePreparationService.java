package us.nikita.timereaderincub.core;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * This class takes an image, resizes and colors it, and saves the new image in a separate folder.
 *
 * @author Nikita
 */

@Service
public class SimpleImagePreparationService implements ImagePreparationService {

    private static final int WIDTH = 1050;
    private static final int HEIGHT = 1024;


    /**
     * The method converts the image to a byte array.
     *
     * @param file image
     * @return image byte array
     */
    public final ByteArrayResource prepare(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());

        BufferedImage prepared = process(image);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(prepared, "jpg", byteArrayOutputStream);

        return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    }

    private BufferedImage process(BufferedImage image) {
        ScalingFactors scalingFactor = ScalingFactors.getForImage(image);

        BufferedImage newImage = new BufferedImage(WIDTH, HEIGHT, image.getType());

        Graphics2D graphicForNewImage = newImage.createGraphics();
        graphicForNewImage.drawImage(image, 0, 0,
                WIDTH, HEIGHT, null);
        graphicForNewImage.dispose();

        RescaleOp makeGrayScaling = new RescaleOp(scalingFactor.getScalingFactor(), scalingFactor.getOffset(), null);

        return makeGrayScaling.filter(newImage, null);
    }
}

