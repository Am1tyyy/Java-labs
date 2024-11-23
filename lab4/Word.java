package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a word composed of letters.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Constructs a Word instance from a string.
     *
     * @param word the string representing the word
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Counts the number of occurrences of a specified character in the word.
     *
     * @param targetChar the character to count
     * @return the number of occurrences
     */
    public int countOccurrences(char targetChar) {
        int count = 0;
        for (Letter letter : letters) {
            if (letter.getValue() == targetChar) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getValue());
        }
        return result.toString();
    }
}
