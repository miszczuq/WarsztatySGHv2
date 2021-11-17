package com.skni.warsztatysghv2.registration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileSaver {

    public void saveToFile(Student student) throws IOException {
        Path path = Paths.get("./student.txt");
        byte[] stringBytes = student.toString().getBytes();

        Files.write(path, stringBytes);
    }
}
