package us.nikita.timereaderincub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import us.nikita.timereaderincub.core.ImagePreparationService;

import java.io.IOException;

/**
 * controller download and upload image
 *
 * @author Nikita
 */
@Controller
public final class ImageController {

    @Autowired
    private ImagePreparationService service;

    /**
     * Upload Image
     *
     * @param file Image to upload
     * @return image
     */
    @PostMapping("/convert")
    public final ResponseEntity<ByteArrayResource> convert (@RequestParam("file") MultipartFile file) throws IOException {
        ByteArrayResource resource = service.prepare(file);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

}

}
