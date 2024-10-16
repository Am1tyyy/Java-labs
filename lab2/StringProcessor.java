import java.util.Arrays;
import java.util.Comparator;

public class StringProcessor {

    public static void main(String[] args) {
        try {
            // Вхідний текстовий рядок
            StringBuilder text = new StringBuilder("Росте липа біля Пилипа");

            // Визначений символ для підрахунку входжень
            char targetChar = 'и';

            // Викликаємо метод для сортування слів за кількістю входжень символу
            StringBuilder sortedText = sortWordsByCharOccurrences(text, targetChar);

            // Виведення результату
            System.out.println("Відсортований текст: " + sortedText.toString());
        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }

    /**
     * Сортує слова у тексті за кількістю входжень заданого символу.
     *
     * @param text      текст, що містить слова для сортування
     * @param targetChar символ, за кількістю входжень якого виконується сортування
     * @return новий StringBuilder з відсортованими словами
     * @throws IllegalArgumentException якщо текст або символ є некоректними
     */
    public static StringBuilder sortWordsByCharOccurrences(StringBuilder text, char targetChar) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Текст не може бути порожнім або null.");
        }

        if (Character.isWhitespace(targetChar)) {
            throw new IllegalArgumentException("Цільовий символ не може бути пробілом.");
        }

        // Розбиття тексту на слова
        String[] words = text.toString().split("\\s+");

        // Сортування слів за кількістю входжень цільового символу
        Arrays.sort(words, Comparator.comparingInt(word -> countCharOccurrences(word, targetChar)));

        // Об'єднання відсортованих слів у новий текст
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }

        // Видалення зайвого пробілу в кінці
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result;
    }

    /**
     * Підраховує кількість входжень заданого символу у слові.
     *
     * @param word      слово, у якому підраховується кількість входжень
     * @param targetChar символ для підрахунку
     * @return кількість входжень символу
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
