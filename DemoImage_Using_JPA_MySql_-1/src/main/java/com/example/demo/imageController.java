package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class imageController {

	
	@Autowired
	ImageService img_ser;
	
	@PostMapping("/upload")
	
	public ResponseEntity<String> saveimage(@RequestParam MultipartFile file){
		
		try {
				Image savedimg = img_ser.uploadImage(file);
			return ResponseEntity.status(HttpStatus.OK).body("Image uploaded sucessfully " +savedimg.getId() );
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in uploading");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]>  getimage(@PathVariable Long id) throws IOException{
		
		Image image = img_ser.getimage(id);
		
		if(image !=null) {
			
			 HttpHeaders headers = new HttpHeaders() ;
	            headers.setContentType(MediaType.IMAGE_JPEG);
			
	            return new ResponseEntity<>(image.getImagedata(), headers, HttpStatus.OK);
	           // return  ResponseEntity.status(HttpStatus.OK).body(image.getImagedata());
		
		}  else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}
	
}
