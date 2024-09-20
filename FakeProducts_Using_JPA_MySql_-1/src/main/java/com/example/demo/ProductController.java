package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/products")
public class ProductController {

			@Autowired
			ProductService product_ser;
	
	@PostMapping("/create")		
	public ResponseEntity<String> CreateProduct( @ModelAttribute ProductRequest productRequest)
//			@RequestParam String name,
//			@RequestParam double price,
//			@RequestParam MultipartFile file ,
//			@RequestParam Rating rating
	
	{
	    Rating rating = new Rating(productRequest.getRatingRate(), productRequest.getRatingCount());

		try {
			
			 product_ser.saveProduct(
		                productRequest.getName(),
		                productRequest.getPrice(),
		                productRequest.getImage() , // Handle file upload
		                rating
		                );
				
				return ResponseEntity.status(HttpStatus.OK).body("Product save succesfully");
		}  catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(null);  // Return 500 if any other error occurs
        }
		
	}
	
	@GetMapping()      // Get All Products
	
	public ResponseEntity<List<Products>> getallproducts(){
		return ResponseEntity.status(HttpStatus.OK).body(product_ser.GetAllProducts());
		
	}
	
	@GetMapping("/{id}")      // Get product by ID
	
	public ResponseEntity<Products> getproductbyid(@PathVariable Long id){
		
		Products existing = product_ser.getproductbyid(id);
		
		if(existing !=null) {
			return ResponseEntity.ok(existing);
		}else {
			return ResponseEntity.notFound().build();
		}
	}	
	
											// Get product image by ID
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> GetImageByID(@PathVariable Long id) throws IOException{
		
		Products existing = product_ser.getproductbyid(id);
		
		if(existing !=null && existing.getProductImage() !=null) {
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(existing.getProductImage());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<String> deletebyid(@PathVariable Long id){
		
		Products existing = product_ser.getproductbyid(id);
		if(existing !=null) {
			     product_ser.deletebyid(id);
			return ResponseEntity.status(HttpStatus.OK).body("Product deleted Succesfully");
		}else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product with Id "+id+" Not Found");
		}
		//return ResponseEntity.noContent().build();
	}
	
	
}
