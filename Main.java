public class Main {
  public static void main(String[] args) {
    
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\033[1;32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_WHITE = "\033[1;37m";
    
    
    System.out.println(ANSI_GREEN + "\nBreaking Bad Quote Generator!\n" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "Generating Quote...\n" + ANSI_RESET);
    
    try {  
      Quote quote = new Quote();
      System.out.println("--- Quote ---\n\n" + quote.getQuote());
      System.out.println(ANSI_WHITE + "\n- " + quote.getAuthor() + ANSI_RESET);
      System.out.println("\n");
      
    } catch (Exception e) {
      System.out.println("\nError: Unable to generate quote.\n");
      System.out.println("Check internet connection.");
      System.out.println("Servers might be down at the moment.");
    }
  }
}