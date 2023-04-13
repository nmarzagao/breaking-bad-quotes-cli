import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quote {

  private String quote;
  private String author;

  public Quote() throws Exception {
    URL url = new URL("https://api.breakingbadquotes.xyz/v1/quotes");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    con.disconnect();

    this.quote = extractQuote(content.toString());
    this.author = extractAuthor(content.toString());
  }

  private static String extractQuote(String input) {
    int startIndex = input.indexOf(':');
    int endIndex = input.lastIndexOf(',');
    String quote = input.substring(startIndex + 2, endIndex - 1);

    return quote;
  }

  private static String extractAuthor(String input) {
    int startIndex = input.indexOf("author") + 9;
    int endIndex = input.indexOf('"', startIndex);
    String author = input.substring(startIndex, endIndex);

    return author;
  }

  public String getQuote() {
    return this.quote;
  }

  public String getAuthor() {
    return this.author;
  }
  
}