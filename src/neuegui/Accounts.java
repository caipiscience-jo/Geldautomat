package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Bearbeitungs-/Erstellungsfenster eines Accounts
 */

public class Accounts extends JFrame {
    Color colorBackground;
    Color colorText;
    String text;
    // Anfang Attribute
    private String input;
    private JLabel lStripe = new JLabel();
    private JLabel lInstruction = new JLabel();
    private JLabel lAccountNumber = new JLabel();
    private JTextField fAccountNumber = new JTextField();
    private JLabel lPin = new JLabel();
    private JTextField fPin = new JTextField();
    private JLabel lName = new JLabel();
    private JTextField fName = new JTextField();
    private JLabel lTotalBalance = new JLabel();
    private JTextField fTotalBalance = new JTextField();
    private JLabel lAvailableBalance = new JLabel();
    private JTextField fAvailableBalance = new JTextField();
    private JButton bSave = new JButton();
    private JButton bDelete = new JButton();
    private JButton bLanguage = new JButton();
    private JButton bDark = new JButton();
    private JButton bBack = new JButton();
    // Ende Attribute

    public Accounts(Color background, Color text, String buttonText) {
        this.colorBackground = background;
        this.colorText = text;
        this.text = buttonText;
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 450;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setTitle("Bankautomat-Konto hinzufügen/editieren");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        cp.setBackground(colorBackground);

        lStripe.setBounds(0, 0, 450, 50);
        lStripe.setText("Good Morning");
        lStripe.setHorizontalAlignment(SwingConstants.CENTER);
        lStripe.setHorizontalTextPosition(SwingConstants.CENTER);
        lStripe.setFont(new Font("Century", Font.BOLD, 22));
        lStripe.setForeground(colorText);
        cp.add(lStripe);

        lInstruction.setBounds(0, 50, 450, 25);
        lInstruction.setText("Please enter your account number and pin");
        lInstruction.setHorizontalAlignment(SwingConstants.CENTER);
        lInstruction.setHorizontalTextPosition(SwingConstants.CENTER);
        lInstruction.setFont(new Font("Century", Font.PLAIN, 12));
        lInstruction.setVerticalTextPosition(SwingConstants.CENTER);
        lInstruction.setForeground(colorText);
        cp.add(lInstruction);

        lAccountNumber.setBounds(75, 100, 150, 25);
        lAccountNumber.setText("Account Number:");
        lAccountNumber.setFont(new Font("Century", Font.PLAIN, 13));
        lAccountNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lAccountNumber.setHorizontalTextPosition(SwingConstants.LEFT);
        lAccountNumber.setVerticalAlignment(SwingConstants.CENTER);
        lAccountNumber.setVerticalTextPosition(SwingConstants.CENTER);
        lAccountNumber.setForeground(colorText);
        cp.add(lAccountNumber);

        fAccountNumber.setBounds(225, 100, 150, 25);
        fAccountNumber.setHorizontalAlignment(SwingConstants.LEFT);
        fAccountNumber.setForeground(colorText);
        fAccountNumber.setBackground(colorBackground);
        cp.add(fAccountNumber);

        lPin.setBounds(75, 150, 150, 25);
        lPin.setText("PIN:");
        lPin.setFont(new Font("Century", Font.PLAIN, 13));
        lPin.setHorizontalTextPosition(SwingConstants.LEFT);
        lPin.setForeground(colorText);
        cp.add(lPin);

        fPin.setBounds(225, 150, 150, 25);
        fPin.setFont(new Font("Century", Font.PLAIN, 13));
        fPin.setHorizontalAlignment(SwingConstants.LEFT);
        fPin.setForeground(colorText);
        fPin.setBackground(colorBackground);
        cp.add(fPin);

        lName.setBounds(75, 200, 150, 25);
        lName.setText("Name:");
        lName.setFont(new Font("Century", Font.PLAIN, 13));
        lName.setHorizontalAlignment(SwingConstants.LEFT);
        lName.setHorizontalTextPosition(SwingConstants.LEFT);
        lName.setVerticalAlignment(SwingConstants.CENTER);
        lName.setVerticalTextPosition(SwingConstants.CENTER);
        lName.setForeground(colorText);
        cp.add(lName);

        fName.setBounds(225, 200, 150, 25);
        fName.setFont(new Font("Century", Font.PLAIN, 13));
        fName.setHorizontalAlignment(SwingConstants.LEFT);
        fName.setForeground(colorText);
        fName.setBackground(colorBackground);
        cp.add(fName);

        lTotalBalance.setBounds(75, 250, 150, 25);
        lTotalBalance.setText("Total Balance:");
        lTotalBalance.setFont(new Font("Century", Font.PLAIN, 13));
        lTotalBalance.setHorizontalAlignment(SwingConstants.LEFT);
        lTotalBalance.setHorizontalTextPosition(SwingConstants.LEFT);
        lTotalBalance.setVerticalAlignment(SwingConstants.CENTER);
        lTotalBalance.setVerticalTextPosition(SwingConstants.CENTER);
        lTotalBalance.setForeground(colorText);
        cp.add(lTotalBalance);

        fTotalBalance.setBounds(225, 250, 150, 25);
        fTotalBalance.setFont(new Font("Century", Font.PLAIN, 13));
        fTotalBalance.setHorizontalAlignment(SwingConstants.LEFT);
        fTotalBalance.setForeground(colorText);
        fTotalBalance.setBackground(colorBackground);
        cp.add(fTotalBalance);

        lAvailableBalance.setBounds(75, 300, 150, 25);
        lAvailableBalance.setText("Available Balance:");
        lAvailableBalance.setFont(new Font("Century", Font.PLAIN, 13));
        lAvailableBalance.setHorizontalAlignment(SwingConstants.LEFT);
        lAvailableBalance.setHorizontalTextPosition(SwingConstants.LEFT);
        lAvailableBalance.setVerticalAlignment(SwingConstants.CENTER);
        lAvailableBalance.setVerticalTextPosition(SwingConstants.CENTER);
        lAvailableBalance.setForeground(colorText);
        cp.add(lAvailableBalance);

        fAvailableBalance.setBounds(225, 300, 150, 25);
        fAvailableBalance.setFont(new Font("Century", Font.PLAIN, 13));
        fAvailableBalance.setHorizontalAlignment(SwingConstants.LEFT);
        fAvailableBalance.setForeground(colorText);
        fAvailableBalance.setBackground(colorBackground);
        cp.add(fAvailableBalance);

        bDelete.setBounds(75, 350, 125, 30);
        bDelete.setText(buttonText);
        bDelete.setMargin(new Insets(2, 2, 2, 2));
        bDelete.setFocusable(false);
        bDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDelete_ActionPerformed(evt);
            }
        });
        bDelete.setBackground(colorBackground);
        bDelete.setForeground(colorText);
        bDelete.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bDelete);

        bSave.setBounds(250, 350, 125, 30);
        bSave.setText("Save");
        bSave.setMargin(new Insets(2, 2, 2, 2));
        bSave.setFocusable(false);
        bSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSave_ActionPerformed(evt);
            }
        });
        bSave.setBackground(colorBackground);
        bSave.setForeground(colorText);
        bSave.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bSave);

        bLanguage.setBounds(375, 455, 50, 50);
        bLanguage.setText("EN");
        bLanguage.setMargin(new Insets(2, 2, 2, 2));
        bLanguage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLanguage_ActionPerformed(evt);
            }
        });
        bLanguage.setBackground(colorBackground);
        bLanguage.setForeground(colorText);
        bLanguage.setToolTipText("");
        bLanguage.setHorizontalTextPosition(SwingConstants.CENTER);
        bLanguage.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bLanguage);

        bDark.setBounds(320, 455, 50, 50);
        bDark.setText("Dark");
        bDark.setMargin(new Insets(2, 2, 2, 2));
        bDark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDark_ActionPerformed(evt);
            }
        });
        bDark.setBackground(colorBackground);
        bDark.setForeground(colorText);
        bDark.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bDark);

        bBack.setBounds(265, 455, 50, 50);
        bBack.setText("Back");
        bBack.setMargin(new Insets(2, 2, 2, 2));
        bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bBack_ActionPerformed(evt);
            }
        });
        bBack.setHorizontalTextPosition(SwingConstants.CENTER);
        bBack.setBackground(colorBackground);
        bBack.setForeground(colorText);
        bBack.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bBack);
        // Ende Komponenten

        setVisible(true);
    }

    // Anfang
    public void bDelete_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen#n
        if (text == "Delete") {
            new Delete(colorBackground, colorText);
        } else {
            new Administration(colorBackground, colorText);
        }

    } // end of b1_ActionPerformed

    public void bSave_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
        new Administration(colorBackground, colorText);
        new Save(colorBackground, colorText);
    } // end of b2_ActionPerformed

    public void bLanguage_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen

    } // end of bLanguage_ActionPerformed

    public void bDark_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
        if (colorBackground == Automat.lightColor) {
            new Accounts(Automat.darkColor, Automat.lightColor, text);
        } else {
            new Accounts(Automat.lightColor, Automat.darkColor, text);
        }

    } // end of bDark_ActionPerformed

    public void bBack_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Administration(colorBackground, colorText);

    } // end of bBack_ActionPerformed

    // Ende Methoden
} // end of class aaaaa

