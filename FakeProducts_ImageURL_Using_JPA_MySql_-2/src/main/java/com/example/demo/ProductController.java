package com.example.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.ProductNotFound;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

		private final ProductService product_ser;
	    @Value("${upload.path}")
	    private String uploadDir; // Make sure this property is defined in application.properties

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.product_ser = productService;
	    }
	
	@PostMapping("/create")		
	   public ResponseEntity<Products> createProduct(
	            @ModelAttribute ProductRequest productRequest) throws EnterAllFields{

	        try {
	        
	            // Save the product
	            Products product = product_ser.saveProduct(productRequest);

	            // Convert to ProductResponse and return
	          //  ProductResponse productResponse = mapToProductResponse(product);
	            return ResponseEntity.ok(product);

	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body(null);  // Return 500 if any error occurs
	        }
	    }
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<String> updateProduct( @PathVariable Long id,
	            @ModelAttribute ProductRequest productRequest) throws EnterAllFields,ProductNotFound {
	        try {
	        	   product_ser.UpdateProduct(id,productRequest);

		           // Convert to ProductResponse and return
		          //  ProductResponse productResponse = mapToProductResponse(product);
		            return ResponseEntity.ok().body("Product Updated Succesfully!");
		            
	        }  catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body(null);  // Return 500 if any error occurs
	        }    
	}
	
	@PatchMapping("/patch/{id}")
	 public ResponseEntity<String> patchupdateProduct( @PathVariable Long id,
	            @ModelAttribute ProductRequest productRequest) throws ProductNotFound {
	        try {
	        	   product_ser.patchUpdate(id,productRequest);

		           // Convert to ProductResponse and return
		          //  ProductResponse productResponse = mapToProductResponse(product);
		            return ResponseEntity.ok().body("Patch update Product Succesfully!");
		            
	        }  catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body(null);  // Return 500 if any error occurs
	        }    
	}
	
//	private ProductResponse mapToProductResponse(Products product) {
//        Rating rating = product.getRating();
//        RatingResponse ratingResponse = new RatingResponse(rating.getRate(), rating.getCount());
//
//        return new ProductResponse(
//                product.getId(),
//                product.getName(),
//                product.getPrice(),
//                ratingResponse,
//                product.getImageUrl()
//        );
//    }
//	
	

	
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
		
		if(existing !=null && existing.getImageUrl() !=null) {
			
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
