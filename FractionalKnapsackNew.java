import java.util.*;

class Item {
    int weight, value;
    Item(int w, int v) { weight = w; value = v; }
}

public class FractionalKnapsackNew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        Item[] items = new Item[sc.nextInt()];
        for (int i = 0; i < items.length; i++) {
            System.out.print("Weight and value for item " + (i + 1) + ": ");
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }
        System.out.print("Knapsack capacity: ");
        int capacity = sc.nextInt();
        sc.close();

        Arrays.sort(items, (a, b) -> b.value * a.weight - a.value * b.weight);
        double maxValue = 0;
        for (Item item : items) {
            if (capacity == 0) break;
            int take = Math.min(capacity, item.weight);
            maxValue += take * (double) item.value / item.weight;
            capacity -= take;
        }
        System.out.println("Max value in knapsack = " + maxValue);
    }
}
