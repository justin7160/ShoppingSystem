package com.shopme.common.entity;

public class Constants {
	public static final String S3_BASE_URI;
	
	static {
		//在環境變數中設定AWS_BUCKET_NAME,AWS_REGION
		String bucketName = System.getenv("AWS_BUCKET_NAME");
		String region = System.getenv("AWS_REGION");
		String pattern = "https://%s.s3.%s.amazonaws.com";
		
		String uri = String.format(pattern, bucketName, region);
		
		S3_BASE_URI = bucketName == null ? "" : uri;
	}	
}
