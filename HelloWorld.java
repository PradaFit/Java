import java.awt.Desktop;
import java.net.URI;

public class HelloWorld {
  public static void main(String[] args) throws Exception {
    Desktop desktop = Desktop.getDesktop();
    if (desktop.isSupported(Desktop.Action.BROWSE)) {
      URI uri = new URI("https://www.example.com");
      desktop.browse(uri);
    } else {
      System.out.println("Desktop doesn't support browsing action!");
    }
    System.out.println("Hello World!");
  }
}