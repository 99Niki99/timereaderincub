package us.nikita.timereaderincub.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import us.nikita.timereaderincub.core.PathFromAndTo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * controller download and upload image
 *
 * @author Nikita
 */
@Controller
public class ImageController {
    /**
     * Upload Image
     *
     * @param file Image to upload
     * @return image
     */
    @PostMapping("/convert")
    public ResponseEntity<ByteArrayResource> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
           String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(String.valueOf(file));
           String savePath = PathFromAndTo.getPathTo() + fileName;
           File saveFile = new File(savePath);
           file.transferTo(saveFile);

           File converted = null;

           BufferedImage image = ImageIO.read(converted);
           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           ImageIO.write(image, "jpeg", byteArrayOutputStream);
           ByteArrayResource imageResource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

           return ResponseEntity.ok()
                   .contentType(MediaType.IMAGE_JPEG)
                   .body(imageResource);
    }

}
