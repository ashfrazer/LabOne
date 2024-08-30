import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Denomination change;
        System.out.println("Enter the change.");
        var scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Denomination twentyNote = new Denomination("Twenty-Note", 20.00, "Note",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/US_%2420_Series_2006_Obverse.jpg/" +
                        "1920px-US_%2420_Series_2006_Obverse.jpg");
        Denomination tenNote = new Denomination("Ten-Note", 10.00, "Note",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/US10dollarbill-Series_2004A.jpg/" +
                        "1920px-US10dollarbill-Series_2004A.jpg");
        Denomination fiveNote = new Denomination("Five-Note", 5.00, "Note",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/US_%245_Series_2006_obverse.jpg/" +
                        "1920px-US_%245_Series_2006_obverse.jpg");
        Denomination oneNote = new Denomination("One-Note", 1.00, "Note",
                "https://upload.wikimedia.org/wikipedia/commons/2/23/US_one_dollar_bill%2C_obverse%2C_series" +
                        "_2009.jpg");

        Purse purse = new Purse();
        purse.add(twentyNote, 3);
        purse.add(tenNote, 2);
        purse.add(fiveNote, 5);
        purse.add(oneNote, 4);

        System.out.println("Current amount of cash in purse: " + purse.getValue());

        System.out.println("Removing $27...");
        purse.remove(tenNote, 1);
        purse.remove(oneNote, 2);
        purse.remove(fiveNote, 3);

        String contents = purse.toString();
        System.out.println(contents);

        /*boolean isCoin;
        // Process type of currency (note or coin)
        for (char c : input.toCharArray()) {
            System.out.println("Print: " + c);
        }
         */
    }
}