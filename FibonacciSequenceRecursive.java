import java.util.Scanner;

public class FibonacciSequenceRecursive {

    // Recursive method to calculate the Fibonacci number at position n
    public static int fibonacci(int n) {
        if (n <= 1) return n;  // Base case: F(0) = 0, F(1) = 1
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
