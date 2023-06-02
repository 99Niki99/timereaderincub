package us.nikita.timereaderincub.core;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class TakeImage {
    public static void main(String[] args)
    {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("D:\\Tess4J\\tessdata");

            String text
                    = tesseract.doOCR(new File("D:\\PhotoForTest\\text.png"));

            System.out.print(text);
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
