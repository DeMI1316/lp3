import java.util.*;

class Item {
    int weight, value;
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double totalValue = 0;
        for (Item item : items) {
            if (capacity == 0) break;
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * (double) capacity / item.weight;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value for item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();
        scanner.close();

        System.out.println("Maximum value in knapsack = " + getMaxValue(items, capacity));
    }
}
