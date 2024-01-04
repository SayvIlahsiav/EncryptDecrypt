import edu.duke.*;
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    private int[] countLetters(FileResource resource) {
        String message = resource.asString();
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
        int[] counts = countLetters(resource);
        for (int i : counts) {
            System.out.println(i);
        }
    }
    
    private int maxIndex(int[] counts) {
        int maxFreq = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxFreq) {
                maxFreq = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void testMaxIndex() {
        FileResource resource = new FileResource();
        int[] counts = countLetters(resource);
        System.out.println(maxIndex(counts));
    }

}
