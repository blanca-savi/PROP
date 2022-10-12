package Tabularium;
import java.util.*;

/**
 *
 * @author blanca_savi
 */

/**
 * This class contains a structure organizing the authors names. 
 * Such structure is implemented by a Trie tree. 
 * 
 */

public class AuthorIndex {
    
    //root node will be the only node not containing any Character information
    public TrieNode root;
    
    
     /**
     * Initializes the data structure
     * 
     */
    private void TrieTree() {
        root = new TrieNode(); 
    }
    
    
     /**
     * Inserts an author into the Index
     * 
     * @param name 
     */
    public void InsertAuthor(String name) {
        
        TrieNode curNode = root;
        char[] arr = name.toCharArray();
        
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
                curNode.children.put(curChar, new TrieNode());
            }
            curNode = curNode.children.get(curChar);
        }    
        curNode.isWord = true;
    
    }
    
    /**
     * Returns whether the AuthorIndex contains the author 
     * 
     * @param name
     * @return Boolean
     */
    public boolean SearchAuthor(String name) {
    
        TrieNode curNode = root;
        char[] arr = name.toCharArray();
        
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
                return false; 
            /*
            *This part makes a big difference. Organizing the info like this
            *makes it way faster to find out whether an element is not present
            *in a set compared to other methods.
            */
            }
            curNode = curNode.children.get(curChar);
        }    
        
        return curNode.isWord;
        /*
        *isWord is important in order to differenciate between the chance of
        *casually having got through all the characters in the query word
        *and having actually stored such word in the data structure.
        */
    
    }
    
    /**
     * Returns whether the AuthorIndex contains a word starting by the prefix
     * 
     * @param prefix
     * @return Boolean
     */
    public boolean StartsWith(String prefix) {
    
        TrieNode curNode = root;
        char[] arr = prefix.toCharArray();
        
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
                return false; 
            }
            curNode = curNode.children.get(curChar);
        }    
        
        return true; 
        /*
        *isWord is not important now. Having got through all the characters in 
        *the query word is.
        */
    }
    
    
     /**
     * Prints the words in the subtree/tree under the node.
     * 
     * @param curNode 
     */
    public void PrintTree(TrieNode curNode){
        
        int i = 0;
        
        for (Map.Entry<Character, TrieNode> entry : curNode.children.entrySet()) {
            Character key = entry.getKey();
            TrieNode value = entry.getValue();
            
            if(value.isWord){
                System.out.println(i +".Author: " + key);
                ++i;
            }
        }
        //NO HE COMPROBADO SI FUNCIONA. IT'S A DRAFT.
    }


}
