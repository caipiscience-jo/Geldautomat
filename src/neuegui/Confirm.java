package neuegui;

import javax.swing.*;
import java.awt.*;

/**
 * Bestätigungsdialog
 */
public class Confirm extends JFrame {

    Color colorBackground;
    Color colorText;
    private JLabel lConfirm = new JLabel();
    // Ende Attribute

    public Confirm(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 350;
        int frameHeight = 200;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        cp.setBackground(colorBackground);
        lConfirm.setBounds(0, 0, 350, 100);
        lConfirm.setText("Account deleted");
        lConfirm.setFont(new Font("Century", Font.PLAIN, 20));
        lConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        lConfirm.setForeground(colorText);
        cp.add(lConfirm);


        setVisible(true);
    }


}
