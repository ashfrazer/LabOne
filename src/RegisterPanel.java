import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        register = new Register();

        // Prompt user to enter amount
        input = new JTextField(10);
        JPanel inputPanel = new JPanel();
        JLabel label = new JLabel("Enter Amount: $");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        inputPanel.add(label);
        inputPanel.add(input);

        // Panel displaying purse information
        changePanel = new PursePanel();
        changePanel.setBackground(Color.DARK_GRAY);
        changePanel.setForeground(Color.WHITE);
        changePanel.setFont(new Font("Arial", Font.PLAIN, 15));

        // Align register panel horizontally
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(inputPanel);
        this.add(changePanel);

        input.addActionListener(new InputListener());
    }

    // Retrieve & process input
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double amount = Double.parseDouble(input.getText());
            Purse change = register.makeChange(amount);
            changePanel.updatePurse(change);
        }
    }
}
