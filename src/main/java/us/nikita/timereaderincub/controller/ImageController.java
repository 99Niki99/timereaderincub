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

@Controller
public class ImageController {
    @PostMapping("/upload")
    public ResponseEntity<String> uploudPhoto(@RequestParam("file") BufferedImage image) {
        return ResponseEntity.ok("image downloaded");
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloudImage(@PathVariable String imageName) throws IOException {
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
