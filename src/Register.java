import java.util.Scanner;

public class Register {
    // Convert amt to a purse containing change of that amount
    public Purse makeChange(double amt) {
        // Create denominations for each type of currency
        Denomination hundredNote = new Denomination("Hundred-Note", 100.00, "Note",
                "Images/hundred_note.png");
        Denomination twentyNote = new Denomination("Twenty-Note", 20.00, "Note",
                "Images/twenty_note.png");
        Denomination tenNote = new Denomination("Ten-Note", 10.00, "Note",
                "Images/ten_note.png");
        Denomination fiveNote = new Denomination("Five-Note", 5.00, "Note",
                "Images/five_note.png");
        Denomination oneNote = new Denomination("One-Note", 1.00, "Note",
                "Images/one_note.png");
        Denomination quarter = new Denomination("Quarter", 0.25, "Coin",
                "Images/quarter.png");
        Denomination dime = new Denomination("Dime", 0.10, "Coin",
                "Images/dime.png");
        Denomination nickel = new Denomination("Nickel", 0.05, "Coin",
                "Images/nickel.png");
        Denomination penny =  new Denomination("Penny", 0.01, "Coin",
                "Images/penny.png");

        // Instantiate purse object
        Purse purse = new Purse();

        // Convert amt to cents for easier processing
        int cents = (int) Math.round(amt * 100.00);

        // Organize cents into the fewest number of notes and coins
            // Notes
            int hundreds = cents / 10000;
            cents = cents % 10000;
            int twenties = cents / 2000;
            cents %= 2000;
            int tens = cents / 1000;
            cents %= 1000;
            int fives = cents / 500;
            cents %= 500;
            int ones = cents / 100;
            cents %= 100;

            // Coins
            int quarters = cents / 25;
            cents %= 25;
            int dimes = cents / 10;
            cents %= 10;
            int nickels = cents / 5;
            cents %= 5;
            int pennies = cents;

        // Add denominations to purse
        if (hundreds > 0)
            purse.add(hundredNote, hundreds);
        if (twenties > 0)
            purse.add(twentyNote, twenties);
        if (tens > 0)
            purse.add(tenNote, tens);
        if (fives > 0)
            purse.add(fiveNote, fives);
        if (ones > 0)
            purse.add(oneNote, ones);
        if (quarters > 0)
            purse.add(quarter, quarters);
        if (dimes > 0)
            purse.add(dime, dimes);
        if (nickels > 0)
            purse.add(nickel, nickels);
        if (pennies > 0)
            purse.add(penny, pennies);

        return purse;
    }

    public static void main(String[] args) {
        System.out.println("Enter the amount of change:");
        var scanner = new Scanner(System.in);

        // Convert input to double
        double amt = Double.parseDouble(scanner.nextLine());

        // Create register object
        Register register = new Register();

        // Create purse object
        Purse purse = register.makeChange(amt);

        // Print the contents of the purse
        System.out.println(purse.toString());
    }
}
