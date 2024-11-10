import java.util.Scanner;

public class Knapsack {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Backtrack to find the selected items
        int w = capacity;
        System.out.print("Selected items: ");
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w -= weights[i - 1];
            }
        }

        return dp[n][capacity];  // Return maximum value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Input weights and values
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value for item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        // Input knapsack capacity
        System.out.print("Enter knapsack capacity: ");
        int capacity = scanner.nextInt();

        // Output maximum value and selected items
        System.out.println("Maximum value: " + knapsack(weights, values, capacity));

        scanner.close();
    }
}
