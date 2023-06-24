package us.nikita.timereaderincub.core;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * interface for ServicImagePreparation
 *
 * @author Nikita
 */

public interface ImagePreparationService {
        /**
         * The method converts the image to a byte array.
         * @param file image
         * @return image byte array
         * @throws IOException The exception may be caused by incorrect reading and writing of the image
         */
        ByteArrayResource prepare(MultipartFile file) throws IOException;
}
