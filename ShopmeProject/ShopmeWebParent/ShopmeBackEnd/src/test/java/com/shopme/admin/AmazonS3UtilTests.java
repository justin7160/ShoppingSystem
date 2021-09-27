package com.shopme.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AmazonS3UtilTests {

	@Test
	public void testListFolder() {
		String folderName = "product-images/1";
		List<String> listKeys = AmazonS3Util.listFolder(folderName);
		listKeys.forEach(System.out::println);
	}
	
	@Test
	public void testUploadFile() throws FileNotFoundException {
		String folderName = "test-upload";
		String fileName = "test_image1.jpg";
		String filePath = "E:\\" + fileName;
		
		InputStream inputStream = new FileInputStream(filePath);
		
		AmazonS3Util.uploadFile(folderName, fileName, inputStream);
	}
	
	@Test
	public void testDeleteFile() {
		String fileName = "test-upload/test_image.jpg";
		AmazonS3Util.deleteFile(fileName);
	}
	
	@Test
	public void testRemoveFolder() {
		String fileName = "test-upload";
		AmazonS3Util.removeFolder(fileName);
	}
}
