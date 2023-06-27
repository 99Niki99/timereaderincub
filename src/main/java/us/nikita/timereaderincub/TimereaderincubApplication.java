package us.nikita.timereaderincub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;
import us.nikita.timereaderincub.controller.ImageController;
import us.nikita.timereaderincub.core.PathFromAndTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class TimereaderincubApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TimereaderincubApplication.class, args);

        Path path = Paths.get(PathFromAndTo.getPathFrom().toUri());
        String name = "photoTest.jpg";
        String originalFileName = "photoTest.jpg";
        String contType = "contentType";
        byte[] content = null;
        content = Files.readAllBytes(path);
        MultipartFile result = new MockMultipartFile(name, originalFileName, contType, content);
        ImageController imageController = new ImageController();
        imageController.convert(result);
    }

