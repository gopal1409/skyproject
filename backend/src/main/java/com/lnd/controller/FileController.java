package com.lnd.controller;

import org.springframework.web.bind.annotation.*;
import java.nio.file.*;
import java.io.IOException;

@RestController
public class FileController {

    @GetMapping("/file")
    public String readFile(@RequestParam String filename) throws IOException {

        // Vulnerability: Path traversal
        Path path = Paths.get("uploads/" + filename);

        return Files.readString(path);
    }
}
