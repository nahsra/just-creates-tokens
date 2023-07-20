package org.acme;

import java.util.Random;
import java.net.URL;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.net.ssl.SSLContext;
import java.security.MessageDigest;

public class Foo {
 
  public static void main(String[] args) {
    new Random().nextInt();
    System.out.println(args);
    Runtime.getRuntime().exec(args[0]);
    URL u = new URL(args[1]);
    System.out.println(u);
    BufferedReader br = null;
    String s = br.readLine();
    System.out.println(s);
    Random r = new Random();
    r.setSeed(152);
    ObjectInputStream ios = new ObjectInputStream(getOis());
    Acme acme = (Acme)ois.readObject();
    System.out.println(acme);
   
    SSLContext context = SSLContext.getInstance("TLSv1");
    SSLEngine engine = getEngine();
    engine.setEnabledProtocols(new String[] {"TLSv1", "TLSv1.1"});
  }
 
  void savePassword(String s) {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    byte[] digest = md.digest();
    String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
    updateUserHash(hash);
  }
 
  public static final SearchControls posField = new SearchControls(0, 0, 0, null, false, false);
  public static final SearchControls negField = new SearchControls(0, 0, 0, null, false, false);

  public void directInstantiation() {
    DirContext ctx = new InitialDirContext();
    ctx.search("query", "filter", new SearchControls(0, 0, 0, null, true, false));
  }
    
}
