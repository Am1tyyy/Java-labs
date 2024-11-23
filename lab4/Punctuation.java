package lab4;

/**
 * Represents a punctuation mark as a separate element.
 */
public class Punctuation {
    private final char mark;

    /**
     * Constructs a Punctuation instance with the specified character.
     *
     * @param mark the punctuation character
     */
    public Punctuation(char mark) {
        this.mark = mark;
    }

    /**
     * Retrieves the punctuation mark.
     *
     * @return the punctuation mark as a character
     */
    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
