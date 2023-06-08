package us.nikita.timereaderincub.core;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static us.nikita.timereaderincub.core.ImproveTextQuality.processImg;

public class ScalingImage {
    static BufferedImage takeImageForChange;

    public static void main(String[] args) throws Exception {
        File adressImageForChange = new File(
                "D:\\PhotoForTest\\photoTest1.jpg");
        takeImageForChange = ImageIO.read(adressImageForChange);
        double readSizeImage = takeImageForChange
                .getRGB(takeImageForChange.getTileWidth() / 2,
                        takeImageForChange.getTileHeight() / 2);
        makeNewScaling(readSizeImage);
    }

    private static void makeNewScaling(double makeSizeImage) throws IOException {
        if (makeSizeImage >= -1.4211511E7 && makeSizeImage < -7254228) {
            processImg(takeImageForChange, 3f, -10f);
        } else if (makeSizeImage >= -7254228 && makeSizeImage < -2171170) {
            processImg(takeImageForChange, 1.455f, -47f);
        } else if (makeSizeImage >= -2171170 && makeSizeImage < -1907998) {
            processImg(takeImageForChange, 1.35f, -10f);
        } else if (makeSizeImage >= -1907998 && makeSizeImage < -257) {
            processImg(takeImageForChange, 1.19f, 0.5f);
        } else if (makeSizeImage >= -257 && makeSizeImage < -1) {
            processImg(takeImageForChange, 1f, 0.5f);
        } else if (makeSizeImage >= -1 && makeSizeImage < 2) {
            processImg(takeImageForChange, 1f, 0.35f);
        }
    }

}
