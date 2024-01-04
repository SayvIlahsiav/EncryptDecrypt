
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
    
    public static void main(String[] args) {
        
    }

}
