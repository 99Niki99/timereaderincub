package us.nikita.timereaderincub.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static us.nikita.timereaderincub.core.ImproveTextQuality.processImg;

public class AddingContrastToAnImage {
    public static void main(String[] args) throws Exception {
        File adressImageForChange = new File(
                "D:\\PhotoForTest\\photoTest1.jpg");

        BufferedImage ipimage = ImageIO.read(adressImageForChange);
        double d = ipimage
                .getRGB(ipimage.getTileWidth() / 2,
                        ipimage.getTileHeight() / 2);
        if (d >= -1.4211511E7 && d < -7254228) {
            processImg(ipimage, 3f, -10f);
        } else if (d >= -7254228 && d < -2171170) {
            processImg(ipimage, 1.455f, -47f);
        } else if (d >= -2171170 && d < -1907998) {
            processImg(ipimage, 1.35f, -10f);
        } else if (d >= -1907998 && d < -257) {
            processImg(ipimage, 1.19f, 0.5f);
        } else if (d >= -257 && d < -1) {
            processImg(ipimage, 1f, 0.5f);
        } else if (d >= -1 && d < 2) {
            processImg(ipimage, 1f, 0.35f);
        }


    }
}
