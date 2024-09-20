package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class Image {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	  @Lob
	  @Column(name="image_data", columnDefinition = "LONGBLOB")
	private byte[] imagedata;
	  
	  @Column(name = "content_type") // Store the image MIME type (JPEG, PNG, etc.)
	    private String contentType;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public byte[] getImagedata() {
		return imagedata;
	}

	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	  
	  
}
