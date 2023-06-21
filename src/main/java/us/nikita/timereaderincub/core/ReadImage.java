package us.nikita.timereaderincub.core;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * class uses tesseract to define text from image.
 *
 * @author Nikita
 */

public class ReadImage {
    String text;

    /**
     * defines image text
     *
     * @return text from image
     */
    public String readTextImage() {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("D:\\Tess4J\\tessdata");

            text = tesseract.doOCR(new File("D:\\NewImage\\output2.png"));

            return text;

        } catch (TesseractException e) {
            e.printStackTrace();

        }
        return text;
    }

}
