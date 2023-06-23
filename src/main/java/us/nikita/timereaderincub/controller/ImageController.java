package us.nikita.timereaderincub.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * controller download and uploud image
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
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
       try {
           String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(String.valueOf(file));
           String savePath = "D:\\NewImage\\output6.png" + fileName;
           File saveFile = new File(savePath);
           file.transferTo(saveFile);

           return ResponseEntity.ok("image downloaded");
       } catch (IOException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving image.");
       }
    }

    /**
     * Download Image
     *
     * @param imageName Image to downloud
     * @return Image
     * @throws IOException if not image
     */
    @GetMapping("/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable String imageName) throws IOException {
        File imageFile = new File(PathFromAndTo.getPathFrom() + imageName);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound()
                    .build();
        }
        BufferedImage image = ImageIO.read(imageFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", byteArrayOutputStream);
        ByteArrayResource imageResource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageResource);
    }

}
