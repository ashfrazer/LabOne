import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        this.purse = new Purse();
    }

    public void updatePurse(Purse newPurse) {
        this.purse = newPurse;
        // Updates purse
        repaint();
    }

    public void paintComponent(Graphics g) {
        // Display purse contents
        super.paintComponent(g);
        String purseContents = purse.toString();
        
        // Separate each currency type by lines
        String[] lines = purseContents.split("\n");
        int y = 20;
        for (String line : lines) {
            g.drawString(line, 10, y);
            y += 20;
        }
    }
}
