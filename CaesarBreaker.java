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
        int key = getKey(encrypted);
        return cc.encrypt(encrypted, key);
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
    
    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxIndex = maxIndex(freqs);
        int dkey = maxIndex - 4;
        if (maxIndex < 4) {
            dkey = 26 - (4-maxIndex);
        }
        return 26 - dkey;
    }
    
    public String decryptTwoKeys(String encrypted) {
        String firstStr = halfOfString(encrypted, 0);
        String secondStr = halfOfString(encrypted, 1);
        int key1 = getKey(firstStr);
        int key2 = getKey(secondStr);
        System.out.println(key1 + "," + key2);
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(encrypted, key1, key2);
    }
    
    public void testDecryptTwoKeys() {
        FileResource resource = new FileResource();
        String message = resource.asString();
        System.out.println(decryptTwoKeys(message));
    }
}
