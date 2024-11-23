package lab4;

import java.util.Comparator;
import java.util.List;

/**
 * Main class for processing text, sorting words by occurrences of a specific character, and outputting the results.
 */
public class TextProcessor {

    public static void main(String[] args) {
        try {
            // Input text
            String inputText = "REFEREED, CREEPERED, EMEER, DEFERENCE, REFEREE, DEEPFREEZE, BEEKEEPER.";

            // Target character for counting occurrences
            char targetChar = 'E';

            // Process the text
            Text text = new Text(inputText.replaceAll("\\s+", " "));
            List<Word> words = text.getAllWords();

            // Sort words by the number of occurrences of the target character
            words.sort(Comparator.comparingInt(word -> word.countOccurrences(targetChar)));

            // Output the result
            System.out.println("Sorted words:");
            for (Word word : words) {
                System.out.println(word.toString());
            }
        } catch (Exception e) {
            System.err.println("Issue: " + e.getMessage());
        }
    }
}
