package neuegui;

import javax.swing.*;
import java.awt.*;

/**
 * Logout Diaolog
 */
public class Logout extends JFrame {

    Color colorBackground;
    Color colorText;
    private JLabel lLogout = new JLabel();
    private JLabel lInstruction = new JLabel();
    // Ende Attribute

    public Logout(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 350;
        int frameHeight = 200;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setTitle("Bankautomat");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        cp.setBackground(colorBackground);
        lLogout.setBounds(0, 0, 350, 100);
        lLogout.setText("Thank you");
        lLogout.setFont(new Font("Century", Font.BOLD, 22));
        lLogout.setHorizontalAlignment(SwingConstants.CENTER);
        lLogout.setHorizontalTextPosition(SwingConstants.CENTER);
        lLogout.setForeground(colorText);
        cp.add(lLogout);

        lInstruction.setBounds(0, 50, 350, 100);
        lInstruction.setText("Have a great day");
        lInstruction.setHorizontalAlignment(SwingConstants.CENTER);
        lInstruction.setHorizontalTextPosition(SwingConstants.CENTER);
        lInstruction.setFont(new Font("Century", Font.PLAIN, 20));
        lInstruction.setForeground(colorText);
        cp.add(lInstruction);

        setVisible(true);
    }


}
