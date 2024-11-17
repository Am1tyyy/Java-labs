package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення, яке складається зі слів і розділових знаків.
 */
public class Sentence {
    private final List<Object> elements;

    public Sentence(String sentence) {
        elements = new ArrayList<>();
        String[] parts = sentence.split("(?=\\p{Punct})|(?<=\\p{Punct})|\\s+");
        for (String part : parts) {
            if (part.matches("\\p{Punct}")) {
                elements.add(part);
            } else if (part.trim().length() > 0) { // Заміна isBlank() на перевірку
                elements.add(new Word(part));
            }
        }
    }

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
