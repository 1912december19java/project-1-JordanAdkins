package com.revature.reimbursement.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@WebServlet(name = "FrontController", urlPatterns = {"/uploadfilestoaws"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10, // 10 MB
    maxRequestSize = 1024 * 1024 * 15, // 15 MB
    location = "C:/uploads")
public class TEMPSERVLET extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = -2076166153962586583L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    // get the file chosen by the user
    Part filePart = request.getPart("fileToUpload");
    String fileName = filePart.getSubmittedFileName();

    if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {

      InputStream fileInputStream = filePart.getInputStream();

      String accessKeyId = (System.getenv("aws_key_id"));
      String secretAccessKey = (System.getenv("aws_access_key"));
      String region = (System.getenv("aws_bucket_region"));
      String bucketName = (System.getenv("aws_bucket_name"));
      String subdirectory = "images/";


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

      String name = request.getParameter("name");

      response.getOutputStream()
          .println("<p>Thanks " + name + "! Here's the image you uploaded:</p>");
      response.getOutputStream().println("<img src=\"" + fileUrl + "\" />");
    } else {
      // the file was not a JPG or PNG
      response.getOutputStream().println("<p>Please only upload JPG or PNG files.</p>");
      response.getOutputStream().println(
          "<p>Upload another file <a href=\"http://localhost:8080/index.html\">here</a>.</p>");
    }
  }
}
