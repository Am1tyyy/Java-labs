package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence composed of words and punctuation marks.
 */
public class Sentence {
    private final List<Object> elements;

    /**
     * Constructs a Sentence instance by parsing a string into words and punctuation marks.
     *
     * @param sentence the sentence string to parse
     */
    public Sentence(String sentence) {
        elements = new ArrayList<>();
        String[] parts = sentence.split("(?=\\p{Punct})|(?<=\\p{Punct})|\\s+");
        for (String part : parts) {
            if (part.matches("\\p{Punct}")) {
                elements.add(part);
            } else if (part.trim().length() > 0) {
                elements.add(new Word(part));
            }
        }
    }

    /**
     * Retrieves all words in the sentence.
     *
     * @return a list of words in the sentence
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object element : elements) {
            result.append(element.toString());
        }
        return result.toString();
    }
}
