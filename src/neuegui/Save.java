package neuegui;

import javax.swing.*;
import java.awt.*;

/**
 * Speichern Dialog
 */
public class Save extends JFrame {

    Color colorBackground;
    Color colorText;
    private JLabel lSave = new JLabel();
    // Ende Attribute

    public Save(Color background, Color text) {
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
        lSave.setBounds(0, 0, 325, 150);
        lSave.setText("Account saved");
        lSave.setFont(new Font("Century", Font.PLAIN, 20));
        lSave.setHorizontalAlignment(SwingConstants.CENTER);
        lSave.setHorizontalTextPosition(SwingConstants.CENTER);
        lSave.setForeground(colorText);
        cp.add(lSave);


        setVisible(true);
    }


}
