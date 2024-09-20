package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	@Autowired
	ImageRepository img_repo;
	
	
	public Image uploadImage( MultipartFile file) throws IOException {
		
		Image image = new Image();
			
			image.setImagedata(file.getBytes());
			image.setContentType(file.getContentType());
		
		return img_repo.save(image);
		
	}
	
	public Image getimage(Long id) {
		
		return img_repo.findById(id).orElse(null);
	}
	
	
}
