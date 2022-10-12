package Tabularium;
import java.util.Scanner;

/**
 *
 * @author blanca_savi
 */


public class Main {

    private static AuthorIndex idx;
    private static Scanner term;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        term = new Scanner(System.in);
        
        System.out.println("Number of operations? ");
        int num_op = term.nextInt();
        
        
        for(int i = 0; i <= num_op; ++i){
            
            if(i != 0)System.out.println("Write operation.  Trie/insert/search/startsWith ");
            String op = term.nextLine();
            String name;
            
            switch (op) {
        
                case "Trie":
                    System.out.println("The author index has been created.");
                    idx = new AuthorIndex();
                    break;
                    
                case "insert":
                    System.out.println("Write author name to be inserted");
                    name = term.nextLine();
                    idx.InsertAuthor(name);
                    break;
                    
                case "search":
                    System.out.println("Write author name to be looked for");
                    name = term.nextLine();
                    System.out.println("Author found: " + idx.SearchAuthor(name));
                    break;
                    
                case "startsWith":
                    System.out.println("Write author prefix to be looked for");
                    name = term.nextLine();
                    System.out.println("Prefix found: " + idx.SearchAuthor(name));
                    break;
                    
                default:
                    if(i != 0)System.out.println("Operation not executable.");
            }
            System.out.println();
        }
        
    }
    
}
