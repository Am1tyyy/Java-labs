import java.util.Arrays;
import java.util.Comparator;

/**
 * A class that processes strings, providing functionality to sort words
 * based on the occurrences of a specified character.
 */
public class StringProcessor {

    public static void main(String[] args) {
        try {
            // Input text
            StringBuilder text = new StringBuilder("testing text that contains several words with target characters");

            // Character to count occurrences of
            char targetChar = 't';

            // Call the method to sort words by the number of character occurrences
            StringBuilder sortedText = sortWordsByCharOccurrences(text, targetChar);

            // Output the result
            System.out.println("\nSorted text: " + sortedText.toString());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Sorts the words in a given text by the number of occurrences of a specified character.
     *
     * @param text      the input text containing words to be sorted
     * @param targetChar the character by which the words will be sorted
     * @return a new StringBuilder containing the sorted words
     * @throws IllegalArgumentException if the text is null or empty, or if the target character is invalid
     */
    public static StringBuilder sortWordsByCharOccurrences(StringBuilder text, char targetChar) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        if (Character.isWhitespace(targetChar)) {
            throw new IllegalArgumentException("The target character cannot be a whitespace.");
        }

        // Split the text into words
        String[] words = text.toString().split("\\s+");

        // Sort the words by the number of occurrences of the target character
        Arrays.sort(words, Comparator.comparingInt(word -> countCharOccurrences(word, targetChar)));

        // Combine the sorted words into a new text
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }

        // Remove the trailing space
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result;
    }

    /**
     * Counts the occurrences of a specified character in a given word.
     *
     * @param word      the word in which to count occurrences
     * @param targetChar the character to count
     * @return the number of occurrences of the character
     */
    private static int countCharOccurrences(String word, char targetChar) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }
}
