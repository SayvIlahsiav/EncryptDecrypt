import edu.duke.*;
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    private int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if(index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    
    public void testCountLetters() {
        FileResource resource = new FileResource();
        String message = resource.asString();
        int[] counts = countLetters(message);
        for (int i : counts) {
            System.out.println(i);
        }
    }
    
    private int maxIndex(int[] counts) {
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void testMaxIndex() {
        FileResource resource = new FileResource();
        String message = resource.asString();
        int[] counts = countLetters(message);
        System.out.println(maxIndex(counts));
    }
    
    private String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);
        int dkey = maxIndex - 4;
        if (maxIndex < 4) {
            dkey = 26 - (4-maxIndex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }

    public void testDecrypt() {
        FileResource resource = new FileResource();
        String message = resource.asString();
        System.out.println(decrypt(message));
    }
    
    private String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i+=2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public void testHalfOfString() {
        String message = "abababababababab";
        System.out.println(halfOfString(message, 1));
    }
}
