package us.nikita.timereaderincub.core;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class ImproveTextQuality {
    public static void processImg(BufferedImage ipimage, float scaleFactor, float offset)
            throws IOException, TesseractException {
        BufferedImage opimage = new BufferedImage(
                1050,
                1024,
                ipimage.getType());
        Graphics2D graphic = opimage.createGraphics();
        graphic.drawImage(ipimage,
                0, 0, 1050, 1024,
                null);
        graphic.dispose();
        RescaleOp rescale = new RescaleOp(scaleFactor, offset, null);
        BufferedImage fopimage = rescale.filter(opimage, null);
        ImageIO.write(fopimage, "jpg",
                new File("D:\\NewImage\\output2.png"));
        Tesseract it = new Tesseract();
        it.setDatapath("D:\\Tess4J");
        String str = it.doOCR(fopimage);
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception {
        File f = new File(
                "D:\\PhotoForTest\\photoTest1.jpg");

        BufferedImage ipimage = ImageIO.read(f);
        double d = ipimage
                .getRGB(ipimage.getTileWidth() / 2,
                        ipimage.getTileHeight() / 2);
        if (d >= -1.4211511E7 && d < -7254228) {
            processImg(ipimage, 3f, -10f);
        }
        else if (d >= -7254228 && d < -2171170) {
            processImg(ipimage, 1.455f, -47f);
        }
        else if (d >= -2171170 && d < -1907998) {
            processImg(ipimage, 1.35f, -10f);
        }
        else if (d >= -1907998 && d < -257) {
            processImg(ipimage, 1.19f, 0.5f);
        }
        else if (d >= -257 && d < -1) {
            processImg(ipimage, 1f, 0.5f);
        }
        else if (d >= -1 && d < 2) {
            processImg(ipimage, 1f, 0.35f);
        }


    }
}
