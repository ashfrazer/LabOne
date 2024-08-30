import java.util.HashMap;
import java.util.Map;

public class Purse {
    private Map<Denomination, Integer> cash;

    // Constructor
    public Purse() {
        this.cash = new HashMap<Denomination, Integer>();
    }

    // Add
    public void add(Denomination d, int amount) {
        this.cash.put(d, this.cash.getOrDefault(d,0) + amount);
    }

    // Remove
    public double remove(Denomination d, int amount) {
        int currentAmount = this.cash.get(d);
        if (currentAmount < amount) { //
            throw new IllegalArgumentException("Not enough cash!");
        }
        if (currentAmount == amount) {
            this.cash.remove(d);
        } else {
            cash.put(d, currentAmount - amount);
        }
        return d.amt() * amount;
    }

    // Get value of money
    public double getValue() {
        double sum = 0.0;
        for (Map.Entry<Denomination, Integer> entry : this.cash.entrySet()) {
            sum += entry.getValue() * entry.getKey().amt();
        }
        return sum;
    }

    // Lists contents of the purse
    public String toString() {
        String contents = "";
        System.out.println("Purse currently contains: ");
        for (Map.Entry<Denomination, Integer> entry : this.cash.entrySet()) {
            // contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return contents;
    }
}
