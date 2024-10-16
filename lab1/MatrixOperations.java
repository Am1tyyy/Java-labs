import java.util.InputMismatchException;

public class MatrixOperations {

    public static void main(String[] args) {
        try {
            execute();
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Некоректні дані: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Метод виконує операції з матрицями:
     * 1. Побітове виключне "але" між двома матрицями A та B.
     * 2. Обчислює суму найбільших елементів кожного стовпця результуючої матриці C.
     */
    public static void execute() {
        // Ініціалізація матриць A та B з однаковими розмірами
        int[][] A = {
            {5, 2, 3},
            {4, 8, 6},
            {7, 1, 9}
        };
        int[][] B = {
            {1, 3, 5},
            {2, 7, 8},
            {4, 0, 6}
        };

        // Перевірка, що матриці мають однакові розміри
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Матриці повинні мати однакові розміри.");
        }

        // Створення матриці C для зберігання результату побітової операції XOR
        int[][] C = new int[A.length][A[0].length];

        // Виконання побітового виключного "але" (XOR) між елементами матриць A та B
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }

        // Виведення матриці C на екран
        System.out.println("Результуюча матриця C після побітової операції XOR:");
        printMatrix(C);

        // Обчислення суми найбільших елементів у кожному стовпці матриці C
        int sumMaxElements = calculateSumOfMaxElements(C);
        System.out.println("Сума найбільших елементів кожного стовпця: " + sumMaxElements);
    }

    /**
     * Метод для виведення матриці на екран.
     * 
     * @param matrix Матриця для виведення
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Метод для обчислення суми найбільших елементів кожного стовпця.
     * 
     * @param matrix Вхідна матриця
     * @return Сума найбільших елементів кожного стовпця
     */
    public static int calculateSumOfMaxElements(int[][] matrix) {
        int sum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            int maxInColumn = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > maxInColumn) {
                    maxInColumn = matrix[i][j];
                }
            }
            sum += maxInColumn;
        }

        return sum;
    }
}
