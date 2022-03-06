package spring.boot.food.social.network.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.controller.BaseResponseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.food.social.network.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(path = "/file")
@RequiredArgsConstructor
public class FileController extends BaseResponseController {

    @Getter(AccessLevel.PROTECTED)
    private final FileService service;

    @GetMapping("/load/{fileName:.*}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName, HttpServletRequest http)
            throws IOException {
        return service.getImage(fileName,http);
    }

    @PostMapping("/upload")
    public ResponseDTO upload(@RequestParam("file") MultipartFile file) {
        return response(getService().upload(file));
    }
}
