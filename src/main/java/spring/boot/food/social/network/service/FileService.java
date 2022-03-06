package spring.boot.food.social.network.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.storage.FileInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


public interface FileService {

  ResponseEntity<byte[]> getImage(String fileName, HttpServletRequest httpServletRequest)
      throws IOException;


  FileInfo upload(MultipartFile file);

}
