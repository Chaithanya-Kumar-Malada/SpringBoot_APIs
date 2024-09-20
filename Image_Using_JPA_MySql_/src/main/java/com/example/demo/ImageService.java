package com.example.demo;

//import com.example.model.Image;
//import com.example.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

	 @Autowired
	    private ImageRepository imageRepository;

	    public Image uploadImage(MultipartFile file) throws IOException {
	        Image image = new Image();
	        image.setName(file.getOriginalFilename());
	        image.setImageData(file.getBytes());
	        image.setContentType(file.getContentType()); // Get the content type (image/jpeg, image/png, etc.)

	        return imageRepository.save(image);
	    }

	    public Image getImage(Long id) {
	        return imageRepository.findById(id).orElse(null);
	    }
}
