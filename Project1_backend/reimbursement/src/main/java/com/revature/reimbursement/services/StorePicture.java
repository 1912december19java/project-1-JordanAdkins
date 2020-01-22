package com.revature.reimbursement.services;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class StorePicture {


  public static String uploadToS3(Part filePart) throws IOException {
    String fileName = filePart.getSubmittedFileName();

    if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".JPG")
        || fileName.endsWith(".PNG")) {
      InputStream fileInputStream = filePart.getInputStream();
      String accessKeyId = (System.getenv("aws_key_id"));
      String secretAccessKey = (System.getenv("aws_access_key"));
      String region = (System.getenv("aws_bucket_region"));
      String bucketName = (System.getenv("aws_bucket_name"));
      String subdirectory = "testing/";


      BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretAccessKey);


      AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(region)
          .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();


      ObjectMetadata metadata = new ObjectMetadata();
      metadata.setContentLength(filePart.getSize());


      PutObjectRequest uploadRequest =
          new PutObjectRequest(bucketName, subdirectory + fileName, fileInputStream, metadata);

      uploadRequest.setCannedAcl(CannedAccessControlList.PublicRead);

      s3client.putObject(uploadRequest);

      String fileUrl = "http://s3.amazonaws.com/" + bucketName + "/" + subdirectory + fileName;


      return fileUrl;
    } else {
      // the file was not a JPG or PNG
      return null;
    }
  }
}
