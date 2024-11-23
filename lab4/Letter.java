package lab4;

/**
 * Represents a single letter.
 */
public class Letter {
    private final char value;

    /**
     * Constructs a Letter instance with the specified character.
     *
     * @param value the character value of the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     *
     * @return the character value
     */
    public char getValue() {
        return value;
    }
}
