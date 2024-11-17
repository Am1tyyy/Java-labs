package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово, яке складається з літер.
 */
public class Word {
    private final List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Підрахунок кількості входжень символу в слово.
     *
     * @param targetChar символ для підрахунку
     * @return кількість входжень
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
