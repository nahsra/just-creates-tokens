package org.acme;

import io.github.pixee.security.SystemCommand;
import java.security.SecureRandom;
import java.util.Random;

public class CLI {

  /* people call this and look for the new token on stdout */
  public static void main(String[] args) {
    System.out.println(createToken());
    SystemCommand.runCommand(Runtime.getRuntime(), args[0]);
  }
 
  private String createToken() {
    Random rnd = new SecureRandom();
    int number = rnd.nextInt(999999);
    // this will convert the random number sequence into 6 character
    return String.format("%06d", number);
  }
 
}
