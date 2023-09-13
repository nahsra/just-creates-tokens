package org.acme;

import java.security.SecureRandom;
import java.util.Random;

public class CLI {

  /* people call this and look for the new token on stdout */
  public static void main(String[] args) {
    System.out.println(createToken());
  }
 
  private String createToken() {
    Random rnd = new SecureRandom();
    int number = rnd.nextInt(999999);
    // this will convert the random number sequence into 6 character
    return String.format("%06d", number);
  }
 
}
