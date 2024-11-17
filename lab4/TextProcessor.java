import java.util.Comparator;
import java.util.List;
import lab4.Text;
import lab4.Word;

/**
 * Основний клас для виконання завдання.
 */
public class TextProcessor {

    public static void main(String[] args) {
        try {
            // Вхідний текст
            String inputText = "REFEREED, CREEPERED, EMEER, DEFERENCE, REFEREE, DEEPFREEZE, BEEKEEPER.";

            // Заданий символ
            char targetChar = 'E';

            // Обробка тексту
            Text text = new Text(inputText.replaceAll("\\s+", " "));
            List<Word> words = text.getAllWords();

            // Сортування слів за кількістю входжень символу
            words.sort(Comparator.comparingInt(word -> word.countOccurrences(targetChar)));

            // Виведення результату
            System.out.println("Sorted words:");
            for (Word word : words) {
                System.out.println(word.toString());
            }
        } catch (Exception e) {
            System.err.println("Issue: " + e.getMessage());
        }
    }
}
