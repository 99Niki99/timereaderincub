package us.nikita.timereaderincub.controller;

import jakarta.annotation.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.nikita.timereaderincub.core.PathFromAndTo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
     * @param image Image to upload
     * @return image
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") BufferedImage image) {
        return ResponseEntity.ok("image downloaded");
    }

    /**
     * Download Image
     *
     * @param imageName Image to downloud
     * @return Image
     * @throws IOException if not image
     */
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String imageName) throws IOException {
        File imageFile = new File(PathFromAndTo.getPathFrom() + imageName);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound()
                    .build();
        }
        Resource imageResource = (Resource) new UrlResource(imageFile.toURI());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(imageResource);
    }

}
