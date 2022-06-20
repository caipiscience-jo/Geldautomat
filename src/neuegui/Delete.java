package neuegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Löschen Dialog
 */
public class Delete extends JFrame {

    Color colorBackground;
    Color colorText;
    private JLabel lDelete = new JLabel();
    private JButton bConfirm = new JButton();
    private JButton bCancel = new JButton();
    // Ende Attribute

    public Delete(Color background, Color text) {
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
        lDelete.setBounds(0, 0, 350, 100);
        lDelete.setText("Do you want to delete this account?");
        lDelete.setFont(new Font("Century", Font.PLAIN, 12));
        lDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        lDelete.setForeground(colorText);
        cp.add(lDelete);

        bConfirm.setBounds(75, 100, 75, 50);
        bConfirm.setText("Yes");
        bConfirm.setMargin(new Insets(2, 2, 2, 2));
        bConfirm.setFocusable(false);
        bConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bConfirm_ActionPerformed(evt);
            }
        });
        bConfirm.setBackground(colorBackground);
        bConfirm.setForeground(colorText);
        bConfirm.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(bConfirm);

        bCancel.setBounds(200, 100, 75, 50);
        bCancel.setText("No");
        bCancel.setMargin(new Insets(2, 2, 2, 2));
        bCancel.setFocusable(false);
        bCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bCancel_ActionPerformed(evt);
            }
        });
        bCancel.setBackground(colorBackground);
        bCancel.setForeground(colorText);
        bCancel.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(bCancel);


        setVisible(true);
    }

    public void bConfirm_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Administration(colorBackground, colorText);
        new Confirm(colorBackground, colorText);

    } // end of b1_ActionPerformed

    public void bCancel_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
    } // end of b2_ActionPerformed
}
