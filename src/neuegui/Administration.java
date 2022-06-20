package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.Color.*;

/**
 * Auflistung aller Konten
 */

public class Administration extends JFrame {
    Color colorBackground;
    Color colorText;
    // Anfang Attribute
    private JLabel lAdministration = new JLabel();
    private JLabel lListingofallaccounts = new JLabel();
    private JLabel lSearch1 = new JLabel();
    private JTextField jSearch = new JTextField();
    private JButton jButton1 = new JButton();
    private JLabel lAccountNumber = new JLabel();
    private JLabel lPin = new JLabel();
    private JLabel lName = new JLabel();
    private JLabel lAvailalbeBalance = new JLabel();
    private JLabel lTotalBalance = new JLabel();
    private JButton bLanguage = new JButton();
    private JButton bDark = new JButton();
    private JButton b = new JButton();
    private JButton bBack = new JButton();
    // Ende Attribute

    public Administration(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 450;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Administration");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten
        cp.setBackground(colorBackground);

        lAdministration.setBounds(0, 0, 450, 50);
        lAdministration.setText("Administration");
        lAdministration.setHorizontalAlignment(SwingConstants.CENTER);
        lAdministration.setHorizontalTextPosition(SwingConstants.CENTER);
        lAdministration.setFont(new Font("Century", Font.BOLD, 22));
        lAdministration.setForeground(colorText);
        cp.add(lAdministration);

        lListingofallaccounts.setBounds(0, 50, 450, 25);
        lListingofallaccounts.setText("Listing of all accounts");
        lListingofallaccounts.setFont(new Font("Century", Font.PLAIN, 12));
        lListingofallaccounts.setHorizontalAlignment(SwingConstants.CENTER);
        lListingofallaccounts.setHorizontalTextPosition(SwingConstants.CENTER);
        lListingofallaccounts.setForeground(colorText);
        cp.add(lListingofallaccounts);

        lSearch1.setBounds(75, 100, 150, 25);
        lSearch1.setText("Search:");
        lSearch1.setHorizontalTextPosition(SwingConstants.LEFT);
        lSearch1.setForeground(colorText);
        lSearch1.setFont(new Font("Century", Font.PLAIN, 13));
        cp.add(lSearch1);

        jSearch.setBounds(225, 100, 150, 25);
        jSearch.setFont(new Font("Century", Font.PLAIN, 13));
        jSearch.setForeground(colorText);
        jSearch.setBackground(colorBackground);
        cp.add(jSearch);

        jButton1.setBounds(25, 185, 15, 15);
        jButton1.setText("");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        jButton1.setBackground(WHITE);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton1.setForeground(WHITE);
        jButton1.setFocusPainted(true);
        cp.add(jButton1);

        lAccountNumber.setBounds(50, 150, 67, 25);
        lAccountNumber.setText("Acc. Nr.");
        lAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lAccountNumber.setHorizontalTextPosition(SwingConstants.CENTER);
        lAccountNumber.setFont(new Font("Century", Font.PLAIN, 12));
        lAccountNumber.setForeground(colorText);
        cp.add(lAccountNumber);

        lPin.setBounds(127, 150, 67, 25);
        lPin.setText("PIN");
        lPin.setHorizontalAlignment(SwingConstants.CENTER);
        lPin.setHorizontalTextPosition(SwingConstants.CENTER);
        lPin.setFont(new Font("Century", Font.PLAIN, 12));
        lPin.setForeground(colorText);
        cp.add(lPin);

        lName.setBounds(201, 150, 67, 25);
        lName.setText("Name");
        lName.setFont(new Font("Century", Font.PLAIN, 12));
        lName.setHorizontalAlignment(SwingConstants.CENTER);
        lName.setHorizontalTextPosition(SwingConstants.CENTER);
        lName.setForeground(colorText);
        cp.add(lName);

        lAvailalbeBalance.setBounds(274, 150, 67, 25);
        lAvailalbeBalance.setText("Avail. Bal.");
        lAvailalbeBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lAvailalbeBalance.setHorizontalTextPosition(SwingConstants.CENTER);
        lAvailalbeBalance.setFont(new Font("Century", Font.PLAIN, 12));
        lAvailalbeBalance.setForeground(colorText);
        cp.add(lAvailalbeBalance);

        lTotalBalance.setBounds(350, 150, 67, 25);
        lTotalBalance.setText("Tot. Bal.");
        lTotalBalance.setHorizontalTextPosition(SwingConstants.CENTER);
        lTotalBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lTotalBalance.setFont(new Font("Century", Font.PLAIN, 12));
        lTotalBalance.setForeground(colorText);
        cp.add(lTotalBalance);

        bLanguage.setBounds(375, 455, 50, 50);
        bLanguage.setText("EN");
        bLanguage.setMargin(new Insets(2, 2, 2, 2));
        bLanguage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLanguage_ActionPerformed(evt);
            }
        });
        bLanguage.setHorizontalTextPosition(SwingConstants.CENTER);
        bLanguage.setFont(new Font("Century", Font.PLAIN, 12));
        bLanguage.setBackground(colorBackground);
        bLanguage.setForeground(colorText);
        cp.add(bLanguage);

        bDark.setBounds(320, 455, 50, 50);
        bDark.setText("Dark");
        bDark.setMargin(new Insets(2, 2, 2, 2));
        bDark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDark_ActionPerformed(evt);
            }
        });
        bDark.setHorizontalTextPosition(SwingConstants.CENTER);
        bDark.setFont(new Font("Century", Font.PLAIN, 12));
        bDark.setBackground(colorBackground);
        bDark.setForeground(colorText);
        cp.add(bDark);

        b.setBounds(265, 455, 50, 50);
        b.setText("+");
        b.setMargin(new Insets(2, 2, 2, 2));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b_ActionPerformed(evt);
            }
        });
        b.setHorizontalTextPosition(SwingConstants.CENTER);
        b.setBackground(colorBackground);
        b.setForeground(colorText);
        b.setFont(new Font("Century", Font.PLAIN, 22));
        cp.add(b);

        bBack.setBounds(210, 455, 50, 50);
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
    } // end of public Administration

    // Anfang Methoden

    public void jButton1_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Accounts(colorBackground, colorText, "Delete");

    } // end of jButton1_ActionPerformed

    public void bLanguage_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bLanguage_ActionPerformed

    public void bDark_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        if (colorBackground == Automat.lightColor) {
            new Administration(Automat.darkColor, Automat.lightColor);
        } else {
            new Administration(Automat.lightColor, Automat.darkColor);
        }

    } // end of bDark_ActionPerformed

    public void b_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Accounts(colorBackground, colorText, "Cancel");
    } // end of b_ActionPerformed

    public void bBack_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Startmenue(colorBackground, colorText);

    } // end of bBack_ActionPerformed


    // Ende Methoden
} // end of class Administration

