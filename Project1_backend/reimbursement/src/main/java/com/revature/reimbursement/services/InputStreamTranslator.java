package com.revature.reimbursement.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamTranslator {
  
  public static String inputStreamToString(InputStream inputStream) throws IOException {
   
    String returnString;
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    
    while (((returnString = br.readLine()) != null)) {
      return returnString;
    }
    return null;
  }
}
