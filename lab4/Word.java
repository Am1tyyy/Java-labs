package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a word composed of individual letters.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Constructs a Word instance from a given string.
     *
     * @param word the string representing the word
     * @throws IllegalArgumentException if the word is null or empty
     */
    public Word(String word) {
        if (word == null || word.trim().isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty.");
        }

        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Counts the number of occurrences of a specific character in the word.
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
