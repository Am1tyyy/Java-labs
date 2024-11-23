package lab4;

import java.util.Comparator;
import java.util.List;

/**
 * Processes a text to sort words by occurrences of a specific character and outputs the result.
 */
public class TextProcessor {
    public static void main(String[] args) {
        try {
            // Input text
            String inputText = "REFEREED, CREEPERED, EMEER, DEFERENCE, REFEREE, DEEPFREEZE, BEEKEEPER.";
            char targetChar = 'E';

            // Process the text
            Text text = new Text(inputText);
            List<Word> words = text.getAllWords();

            // Sort words by the number of occurrences of the target character
            words.sort(Comparator.comparingInt(word -> word.countOccurrences(targetChar)));

            // Output the result
            System.out.println("Sorted words:");
            for (Word word : words) {
                System.out.println(word);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
