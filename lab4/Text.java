package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє текст, який складається з речень.
 */
public class Text {
    private final List<Sentence> sentences;

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] rawSentences = text.split("(?<=[.!?])\\s+");
        for (String rawSentence : rawSentences) {
            sentences.add(new Sentence(rawSentence.trim()));
        }
    }

    public List<Word> getAllWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            allWords.addAll(sentence.getWords());
        }
        return allWords;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.toString()).append(" ");
        }
        return result.toString().trim();
    }
}
