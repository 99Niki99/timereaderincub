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
    protected static void processImg(BufferedImage ipimage, float scaleFactor, float offset)
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


}
