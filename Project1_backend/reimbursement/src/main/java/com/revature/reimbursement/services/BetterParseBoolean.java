package com.revature.reimbursement.services;

public class BetterParseBoolean {

  public static boolean doIt(String toParse) {
    
    if(toParse.equalsIgnoreCase("yes") || toParse.equalsIgnoreCase("yah") || 
        toParse.equalsIgnoreCase("yup") || toParse.equalsIgnoreCase("y") || 
        toParse.equalsIgnoreCase("true") || toParse.equalsIgnoreCase("t") ) {
      return true;
    }
    return false;
  }

}
