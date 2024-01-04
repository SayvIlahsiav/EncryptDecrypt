import edu.duke.*;
import java.util.*;

/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypted = new StringBuilder(input);
        String encryptedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                char newChar = encryptedAlphabet.charAt(idx);
                if(Character.isUpperCase(encrypted.charAt(i))) {
                    newChar = Character.toUpperCase(newChar);
                }
                else {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypted = new StringBuilder(input);
        String encryptedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String encryptedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                char newChar;
                if (i % 2 == 0) {
                    newChar = encryptedAlphabetKey1.charAt(idx);
                }
                else {
                    newChar = encryptedAlphabetKey2.charAt(idx);
                }
                if(Character.isUpperCase(encrypted.charAt(i))) {
                    newChar = Character.toUpperCase(newChar);
                }
                else {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testEncrypt() {
        //System.out.println( encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        //System.out.println( encrypt("First Legion", 23));
        //System.out.println( encrypt("First Legion", 17));
        //System.out.println( encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        FileResource fr = new FileResource();
        String message = fr.asString();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key to encrypt message: ");
        int key = input.nextInt();
        String encrypted = encrypt(message, key);
        System.out.println("\nEncrypted Message:\n" + encrypted);
    }
    
    public static void main(String[] args) {
        
    }

}
