package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.ProductNotFound;


@Service
public class ProductService {
		


    private final ProductRepository product_repo;

    public ProductService(ProductRepository productRepository) {
        this.product_repo = productRepository;
    }

    // Save a new product along with the image URL
    public Products saveProduct(ProductRequest productRequest) throws IOException,EnterAllFields {
    	
    	if(productRequest.getName() == null || productRequest.getPrice()==null
    			||productRequest.getImage()==null || productRequest.getRatingCount()==null
    			||productRequest.getRatingRate()==null  ){
    		
    		throw new EnterAllFields("Enter All the Fields: name, price, image, ratingRate, ratingCount");
    	}
    	
    	
    	 Products product = new Products();
         product.setName(productRequest.getName());
         product.setPrice(productRequest.getPrice());
         product.setRating(new Rating(productRequest.getRatingRate(), productRequest.getRatingCount()));
         product.setProductImage(productRequest.getImage().getBytes());
         
         // Save the product (this will generate the ID)
         Products savedProduct = product_repo.save(product);

         // Get the generated ID
         Long generatedProductId = savedProduct.getId();

         // Now use this ID to generate the image URL or for any other purpose
      // Save the image and get its URL
         
         String imageUrl = saveImageToFileSystem(productRequest.getImage(), productRequest.getName(),generatedProductId);
         savedProduct.setImageUrl(imageUrl);
         
         
         // Update the product with the image URL
         return product_repo.save(savedProduct);
    }
		
    
    public void UpdateProduct(Long id,ProductRequest productRequest) throws IOException,EnterAllFields,ProductNotFound {
    	
    	if(productRequest.getName() == null || productRequest.getPrice()==null
    			||productRequest.getImage()==null || productRequest.getRatingCount()==null
    			||productRequest.getRatingRate()==null  ){
    		
    		throw new EnterAllFields("Enter All the Fields: name, price, image, ratingRate, ratingCount");
    	}
    	
    	Products Existing = product_repo.findById(id).orElseThrow( () -> new ProductNotFound("Product Not Found! with Id "+id));
    	
    	 Existing.setName(productRequest.getName());
    	 Existing.setPrice(productRequest.getPrice());
    	 Existing.setRating(new Rating(productRequest.getRatingRate(), productRequest.getRatingCount()));
    	 Existing.setProductImage(productRequest.getImage().getBytes());
         
    	 String imageUrl = saveImageToFileSystem(productRequest.getImage(), productRequest.getName(),id);
    	 Existing.setImageUrl(imageUrl);
    	 
        product_repo.save(Existing);
    	
    }
    
    
    public void patchUpdate(Long id,ProductRequest productRequest) throws IOException,ProductNotFound {
    	
    	Products Existing = product_repo.findById(id).orElseThrow( () -> new ProductNotFound("Product Not Found! with Id "+id));

    	if(productRequest.getName() !=null) {
    		 Existing.setName(productRequest.getName());
    	}
    	if(productRequest.getPrice() !=null) {
    		 Existing.setPrice(productRequest.getPrice());
    	}
    	if(productRequest.getRatingRate() !=null || productRequest.getRatingCount()!=null)  {
       	 Existing.setRating(new Rating(productRequest.getRatingRate(), productRequest.getRatingCount()));
     	}
    	if(productRequest.getImage() !=null) {
    		 Existing.setProductImage(productRequest.getImage().getBytes());
    		 
    		 String imageUrl = saveImageToFileSystem(productRequest.getImage(), productRequest.getName(),id);
    		 	Existing.setImageUrl(imageUrl);
    	}
    	 	product_repo.save(Existing);   	
    }
    
    // Save image to the file system and return its accessible URL
    
    private String saveImageToFileSystem(MultipartFile imageFile, String productName,Long id ) throws IOException {
    	        if (imageFile == null || imageFile.isEmpty()) {
    	            return null;  // Handle if no image is uploaded
    	        }

    	        // Directory to save images
    	        String uploadDir = "uploads/images/";
    	        File directory = new File(uploadDir);
    	        if (!directory.exists()) {
    	            directory.mkdirs();  // Create the directory if it doesn't exist
    	        }

    	        // Generate a unique file name
    	        String fileName = UUID.randomUUID().toString() + "_" + productName + "_" + imageFile.getOriginalFilename();
    	        Path filePath = Paths.get(uploadDir, fileName);

    	        // Copy the image to the server
    	        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

    	        // Return the image URL in the format "url + product id"
    	       // List<Products> AllProducts = product_repo.findAll();
    	        
    	        Products findproduct = product_repo.findById(id).orElse(null);
    	        
    	        return "http://localhost:8080/api/products/image/" + id;
    	    }
    
    
		
		
		
		// Get all products 
		public List<Products> GetAllProducts(){
			return product_repo.findAll();
		}
		
		 // Get product by ID
		public Products getproductbyid(Long id) {        
			return product_repo.findById(id).orElse(null);
		}
	
		
	     // Delete product by ID 
		public void deletebyid(Long id) {
			product_repo.deleteById(id);
		}
		
		
		
		
}
