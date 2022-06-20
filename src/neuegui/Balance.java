package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Funktionalität für die Kontosummenübersicht
 */

public class Balance extends JFrame {
    Color colorBackground;
    Color colorText;
    // Anfang Attribute
    private JLabel lBalanceInformation = new JLabel();
    private JLabel lOverviewofcurrentbalance = new JLabel();
    private JLabel lAvailableBalance = new JLabel();
    private JLabel lTotalBalance1 = new JLabel();
    private JTextField jAvailableBalance = new JTextField();
    private JTextField jTTotalBalance = new JTextField();
    private JButton bHelp = new JButton();
    private JButton bLanguage = new JButton();
    private JButton bDark = new JButton();
    private JButton bBack = new JButton();
    // Ende Attribute

    public Balance(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 450;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Balance");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten
        cp.setBackground(colorBackground);

        lBalanceInformation.setBounds(0, 0, 450, 50);
        lBalanceInformation.setText("Balance Information");
        lBalanceInformation.setFont(new Font("Century", Font.BOLD, 22));
        lBalanceInformation.setHorizontalAlignment(SwingConstants.CENTER);
        lBalanceInformation.setHorizontalTextPosition(SwingConstants.CENTER);
        lBalanceInformation.setForeground(colorText);
        cp.add(lBalanceInformation);

        lOverviewofcurrentbalance.setBounds(0, 50, 450, 25);
        lOverviewofcurrentbalance.setText("Overview of current balance");
        lOverviewofcurrentbalance.setFont(new Font("Century", Font.PLAIN, 12));
        lOverviewofcurrentbalance.setHorizontalAlignment(SwingConstants.CENTER);
        lOverviewofcurrentbalance.setHorizontalTextPosition(SwingConstants.CENTER);
        lOverviewofcurrentbalance.setForeground(colorText);
        cp.add(lOverviewofcurrentbalance);

        lAvailableBalance.setBounds(75, 100, 150, 25);
        lAvailableBalance.setText("Available Balance:");
        lAvailableBalance.setHorizontalTextPosition(SwingConstants.LEFT);
        lAvailableBalance.setFont(new Font("Century", Font.PLAIN, 13));
        lAvailableBalance.setForeground(colorText);
        cp.add(lAvailableBalance);

        lTotalBalance1.setBounds(75, 150, 150, 25);
        lTotalBalance1.setText("Total Balance:");
        lTotalBalance1.setHorizontalTextPosition(SwingConstants.LEFT);
        lTotalBalance1.setFont(new Font("Century", Font.PLAIN, 13));
        lTotalBalance1.setForeground(colorText);
        cp.add(lTotalBalance1);

        jAvailableBalance.setBounds(225, 100, 150, 25);
        jAvailableBalance.setFont(new Font("Century", Font.PLAIN, 13));
        jAvailableBalance.setForeground(colorText);
        jAvailableBalance.setBackground(colorBackground);
        cp.add(jAvailableBalance);

        jTTotalBalance.setBounds(225, 151, 150, 25);
        jTTotalBalance.setFont(new Font("Century", Font.PLAIN, 13));
        jTTotalBalance.setForeground(colorText);
        jTTotalBalance.setBackground(colorBackground);
        cp.add(jTTotalBalance);

        bHelp.setBounds(-1, -1, 25, 25);
        bHelp.setText("?");
        bHelp.setMargin(new Insets(2, 2, 2, 2));
        bHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bHelp_ActionPerformed(evt);
            }
        });
        bHelp.setHorizontalTextPosition(SwingConstants.CENTER);
        bHelp.setFont(new Font("Century", Font.PLAIN, 12));
        bHelp.setBackground(colorBackground);
        bHelp.setForeground(colorText);
        cp.add(bHelp);

        bLanguage.setBounds(375, 455, 50, 50);
        bLanguage.setText("EN");
        bLanguage.setMargin(new Insets(2, 2, 2, 2));
        bLanguage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLanguage_ActionPerformed(evt);
            }
        });
        bLanguage.setFont(new Font("Century", Font.PLAIN, 12));
        bLanguage.setBackground(colorBackground);
        bLanguage.setForeground(colorText);
        bLanguage.setHorizontalTextPosition(SwingConstants.CENTER);
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
        bDark.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(bDark);

        bBack.setBounds(265, 455, 50, 50);
        bBack.setText("Back");
        bBack.setMargin(new Insets(2, 2, 2, 2));
        bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bBack_ActionPerformed(evt);
            }
        });
        bBack.setBackground(colorBackground);
        bBack.setForeground(colorText);
        bBack.setHorizontalTextPosition(SwingConstants.CENTER);
        bBack.setFont(new Font("Century", Font.PLAIN, 13));
        cp.add(bBack);
        // Ende Komponenten

        setVisible(true);
    } // end of public Balance

    // Anfang Methoden

    public void bHelp_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bHelp_ActionPerformed

    public void bLanguage_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bLanguage_ActionPerformed

    public void bDark_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        if (colorBackground == Automat.lightColor) {
            new Balance(Automat.darkColor, Automat.lightColor);
        } else {
            new Balance(Automat.lightColor, Automat.darkColor);
        }

    } // end of bDark1_ActionPerformed

    public void bBack_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Loginmenue(colorBackground, colorText);

    } // end of bBack_ActionPerformed

    // Ende Methoden
} // end of class Balance

