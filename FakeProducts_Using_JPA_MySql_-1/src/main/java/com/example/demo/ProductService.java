package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {
		

			@Autowired
			ProductRepository product_repo;
			
			// Save Product 
			
		public Products saveProduct(String name,double price,MultipartFile file,Rating rating)throws IOException {
			
			Products saveproduct = new Products();
			
			saveproduct.setName(name);
			saveproduct.setPrice(price);
			saveproduct.setProductImage(file.getBytes());
			saveproduct.setRating(rating);
			
			
			return product_repo.save(saveproduct);
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
