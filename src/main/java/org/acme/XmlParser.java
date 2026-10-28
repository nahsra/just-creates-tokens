package org.acme;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlParser {

  /* accepts token requests as XML posted by any client on the network */
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/token", XmlParser::handle);
    server.start();
  }

  static void handle(HttpExchange exchange) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document request = builder.parse(exchange.getRequestBody());
      String user = request.getDocumentElement().getAttribute("user");
      byte[] body = ("token issued for " + user).getBytes();
      exchange.sendResponseHeaders(200, body.length);
      exchange.getResponseBody().write(body);
      exchange.close();
    } catch (Exception e) {
      exchange.close();
    }
  }
}
// Reviewed by a developer while Pixee was refreshing this branch