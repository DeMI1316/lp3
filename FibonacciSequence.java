import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence to display: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: " + a);

        for (int i = 1; i < n; i++) {
            System.out.print(", " + b);
            int temp = b;
            b = a + b;
            a = temp;
        }
        System.out.println();  // Print a newline after the sequence
    }
}



