package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Menü, nachdem Nutzer*in sich eingeloggt hat
 */

public class Loginmenue extends JFrame {
    Color colorBackground;
    Color colorText;
    // Anfang Attribute
    private JLabel lStripe = new JLabel();
    private JButton bLanguage = new JButton();
    private JButton bDark = new JButton();
    private JButton bBalance = new JButton();
    private JLabel lInstruction = new JLabel();
    private JButton bWithdrawal = new JButton();
    private JButton bDeposit = new JButton();
    private JButton bLogout = new JButton();
    private JButton bHelp = new JButton();
    // Ende Attribute

    public Loginmenue(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 450;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setTitle("Bankautomat-Auswahl Funktionalitäten");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        lStripe.setBounds(0, 0, 450, 50);
        lStripe.setText("Good Morning Customer xy");
        lStripe.setForeground(colorText);
        lStripe.setFont(new Font("Century", Font.BOLD, 22));
        lStripe.setHorizontalTextPosition(SwingConstants.CENTER);
        lStripe.setHorizontalAlignment(SwingConstants.CENTER);
        lStripe.setForeground(colorText);
        cp.add(lStripe);

        cp.setBackground(colorBackground);
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

        bBalance.setBounds(125, 100, 200, 50);
        bBalance.setText("Balance");
        bBalance.setMargin(new Insets(2, 2, 2, 2));
        bBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bBalance_ActionPerformed(evt);
            }
        });
        bBalance.setFont(new Font("Century", Font.PLAIN, 18));
        bBalance.setBackground(colorBackground);
        bBalance.setForeground(colorText);
        bBalance.setHorizontalTextPosition(SwingConstants.CENTER);
        bBalance.setSelected(false);
        cp.add(bBalance);

        lInstruction.setBounds(0, 50, 450, 25);
        lInstruction.setText("Please choose an option from below");
        lInstruction.setFont(new Font("Century", Font.PLAIN, 12));
        lInstruction.setHorizontalAlignment(SwingConstants.CENTER);
        lInstruction.setHorizontalTextPosition(SwingConstants.CENTER);
        lInstruction.setForeground(colorText);
        cp.add(lInstruction);

        bWithdrawal.setBounds(125, 160, 200, 50);
        bWithdrawal.setText("Withdrawal");
        bWithdrawal.setMargin(new Insets(2, 2, 2, 2));
        bWithdrawal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bWithdrawal_ActionPerformed(evt);
            }
        });
        bWithdrawal.setFont(new Font("Century", Font.PLAIN, 18));
        bWithdrawal.setBackground(colorBackground);
        bWithdrawal.setForeground(colorText);
        bWithdrawal.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(bWithdrawal);

        bDeposit.setBounds(125, 220, 200, 50);
        bDeposit.setText("Deposit");
        bDeposit.setMargin(new Insets(2, 2, 2, 2));
        bDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDeposit_ActionPerformed(evt);
            }
        });
        bDeposit.setBackground(colorBackground);
        bDeposit.setForeground(colorText);
        bDeposit.setFont(new Font("Century", Font.PLAIN, 18));
        bDeposit.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(bDeposit);

        bLogout.setBounds(125, 280, 200, 50);
        bLogout.setText("Logout");
        bLogout.setMargin(new Insets(2, 2, 2, 2));
        bLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLogout_ActionPerformed(evt);
            }
        });
        bLogout.setHorizontalTextPosition(SwingConstants.CENTER);
        bLogout.setFont(new Font("Century", Font.PLAIN, 18));
        bLogout.setBackground(colorBackground);
        bLogout.setForeground(colorText);
        cp.add(bLogout);

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
        // Ende Komponenten

        setVisible(true);
    } // end of public Loginmenue

    // Anfang Methoden

    public void bLanguage_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bLanguage_ActionPerformed

    public void bDark_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        if (colorBackground == Automat.lightColor) {
            new Loginmenue(Automat.darkColor, Automat.lightColor);
        } else {
            new Loginmenue(Automat.lightColor, Automat.darkColor);
        }
    } // end of bDark_ActionPerformed

    public void bBalance_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Balance(colorBackground, colorText);

    } // end of bBalance_ActionPerformed

    public void bWithdrawal_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Withdrawal(colorBackground, colorText);

    } // end of bWithdrawal_ActionPerformed

    public void bDeposit_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Deposit(colorBackground, colorText);

    } // end of bDeposit_ActionPerformed

    public void bLogout_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen
        dispose();
        new Startmenue(colorBackground, colorText);
        new Logout(colorBackground, colorText);
    } // end of bLogout_ActionPerformed

    public void bHelp_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of b_ActionPerformed

    // Ende Methoden
} // end of class Loginmnue

