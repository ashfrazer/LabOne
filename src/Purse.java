import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purse {
    private Map<Denomination, Integer> cash;

    // Constructor
    public Purse() {
        this.cash = new HashMap<Denomination, Integer>();
    }

    // Add cash to purse
    public void add(Denomination d, int amount) {
        this.cash.put(d, this.cash.getOrDefault(d,0) + amount);
    }

    // Remove cash from purse
    public double remove(Denomination d, int amount) {
        int currentAmount = this.cash.get(d);
        if (currentAmount < amount) {
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
        // Navigate the cash map and calculate sum of entries
        for (Map.Entry<Denomination, Integer> entry : this.cash.entrySet()) {
            sum += entry.getValue() * entry.getKey().amt();
        }
        return sum;
    }

    // Lists contents of the purse
    public String toString() {
        Denomination currency;
        // Create a MUTABLE string containing contents of purse
        StringBuilder contents = new StringBuilder();

        // Sort Denominations by value (increasing to decreasing)
        List<Map.Entry<Denomination, Integer>> entries = new ArrayList<>(this.cash.entrySet());
        entries.sort((entry1, entry2) -> Double.compare(entry2.getKey().amt(), entry1.getKey().amt()));

        // Store money into a string
        for (Map.Entry<Denomination, Integer> entry : entries) {
            currency = entry.getKey();
            int quantity = entry.getValue();
            contents.append(quantity).append(" x ").append(currency.name()).append("\n");
        }
        if (contents.isEmpty()) {
            contents.append("Purse is empty.");
        }
        return contents.toString();
    }
}
