import java.util.InputMismatchException;

/**
 * A class that performs operations on matrices, including bitwise XOR and summing
 * the largest elements in each column of a resulting matrix.
 */
public class MatrixOperations {

    public static void main(String[] args) {
        try {
            execute();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Executes matrix operations:
     * 1. Performs a bitwise XOR operation between two matrices A and B.
     * 2. Calculates the sum of the largest elements in each column of the resulting matrix C.
     */
    public static void execute() {
        // Initialize matrices A and B with the same dimensions
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

        // Ensure that matrices have the same dimensions
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        // Create matrix C to store the result of the bitwise XOR operation
        int[][] C = new int[A.length][A[0].length];

        // Perform bitwise XOR between elements of matrices A and B
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }

        // Print matrix C to the console
        System.out.println("\nResulting matrix C after XOR operation:");
        printMatrix(C);

        // Calculate the sum of the largest elements in each column of matrix C
        int sumMaxElements = calculateSumOfMaxElements(C);
        System.out.println("Sum of the largest elements in each column: " + sumMaxElements);
    }

    /**
     * Prints the given matrix to the console.
     *
     * @param matrix The matrix to be printed
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
     * Calculates the sum of the largest elements in each column of the given matrix.
     *
     * @param matrix The input matrix
     * @return The sum of the largest elements in each column
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
