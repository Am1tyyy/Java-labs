package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of sentences.
 */
public class Text {
    private final List<Sentence> sentences;

    /**
     * Constructs a Text instance by parsing a string into sentences.
     *
     * @param text the text string to parse
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        String[] rawSentences = text.split("(?<=[.!?])\\s+");
        for (String rawSentence : rawSentences) {
            sentences.add(new Sentence(rawSentence.trim()));
        }
    }

    /**
     * Retrieves all words from all sentences in the text.
     *
     * @return a list of all words in the text
     */
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