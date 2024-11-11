import java.util.Scanner;

public class KnapsackNew {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++)
            for (int w = 0; w <= capacity; w++)
                dp[i][w] = weights[i - 1] <= w
                    ? Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
                    : dp[i - 1][w];

        System.out.print("Selected items: ");
        for (int i = weights.length, w = capacity; i > 0; i--)
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w -= weights[i - 1];
            }
        System.out.println();
        return dp[weights.length][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        int n = sc.nextInt(), weights[] = new int[n], values[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Weight and value of item " + (i + 1) + ": ");
            weights[i] = sc.nextInt(); values[i] = sc.nextInt();
        }
        System.out.print("Knapsack capacity: ");
        System.out.println("Maximum value: " + knapsack(weights, values, sc.nextInt()));
        sc.close();
    }
}
