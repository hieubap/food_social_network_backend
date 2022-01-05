package spring.boot.core.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {
  private final Path root = Paths.get("uploads");

  @Override
  public void init() {
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
    try {
      if(!Files.exists(root)){
        init();
        System.out.println("root not exist and create: "+root);
      }
      System.out.println("root: "+root);
      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),
          StandardCopyOption.REPLACE_EXISTING);
      System.out.println("root: "+root);
      System.out.println("originFilename"+file.getOriginalFilename());
      System.out.println("originFilename"+this.root.resolve(file.getOriginalFilename()));


    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }


  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }


}