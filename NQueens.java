import java.util.Scanner;

public class NQueens {
    private static int N;

    // Function to print the board
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }

    // Function to check if placing a queen is safe
    private static boolean isSafe(int[][] board, int row, int col) {
        // Check column for queen presence
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Recursive function to solve N-Queens problem
    private static boolean solveNQueens(int[][] board, int row) {
        if (row >= N) {
            return true; // All queens placed successfully
        }

        // Try placing queen in each column of the row
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place queen

                if (solveNQueens(board, row + 1)) { // Recursive call to place next queen
                    return true;
                }

                board[row][col] = 0; // Backtrack if placing queen here fails
            }
        }
        return false; // No valid placement found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens (N): ");
        N = scanner.nextInt();
        scanner.close();

        int[][] board = new int[N][N];

        // Start backtracking from the first row
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
