package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * erstes Fenster des Bankautomaten
 */

public class Startmenue extends JFrame {
    Color colorBackground;
    Color colorText;
    // Anfang Attribute
    private String input;
    private JLabel lStripe = new JLabel();
    private JLabel lInstruction = new JLabel();
    private JLabel lAccountNumber = new JLabel();
    private JTextField fAccountNumber = new JTextField();
    private JLabel lPin = new JLabel();
    private JTextField fPin = new JTextField();
    private JButton b1 = new JButton();
    private JButton b2 = new JButton();
    private JButton b3 = new JButton();
    private JButton b4 = new JButton();
    private JButton b5 = new JButton();
    private JButton b6 = new JButton();
    private JButton b7 = new JButton();
    private JButton b8 = new JButton();
    private JButton b9 = new JButton();
    private JButton bDelete = new JButton();
    private JButton b0 = new JButton();
    private JButton bCorrect = new JButton();
    private JButton bEnter = new JButton();
    private JButton bLanguage = new JButton();
    private JButton bDark = new JButton();
    private JButton bAdmin = new JButton();
    private JButton bHelp = new JButton();
    // Ende Attribute

    public Startmenue(Color background, Color text) {
        this.colorBackground = background;
        this.colorText = text;
        // Frame-Initialisierung
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 450;
        int frameHeight = 550;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setTitle("Bankautomat");
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

        // Tastenfeld Buttons
        b1.setBounds(112, 200, 75, 50);
        b1.setText("1");
        b1.setMargin(new Insets(2, 2, 2, 2));
        b1.setFocusable(false);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b1_ActionPerformed(evt);
            }
        });

        b1.setBackground(colorBackground);
        b1.setForeground(colorText);
        b1.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b1);

        b2.setBounds(187, 200, 75, 50);
        b2.setText("2");
        b2.setMargin(new Insets(2, 2, 2, 2));
        b2.setFocusable(false);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b2_ActionPerformed(evt);
            }
        });
        b2.setBackground(colorBackground);
        b2.setForeground(colorText);
        b2.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b2);

        b3.setBounds(262, 200, 75, 50);
        b3.setText("3");
        b3.setMargin(new Insets(2, 2, 2, 2));
        b3.setFocusable(false);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b3_ActionPerformed(evt);
            }
        });
        b3.setBackground(colorBackground);
        b3.setForeground(colorText);
        b3.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b3);

        b4.setBounds(112, 250, 75, 50);
        b4.setText("4");
        b4.setMargin(new Insets(2, 2, 2, 2));
        b4.setFocusable(false);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b4_ActionPerformed(evt);
            }
        });
        b4.setFont(new Font("Century", Font.BOLD, 22));
        b4.setBackground(colorBackground);
        b4.setForeground(colorText);
        cp.add(b4);

        b5.setBounds(187, 250, 75, 50);
        b5.setText("5");
        b5.setMargin(new Insets(2, 2, 2, 2));
        b5.setFocusable(false);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b5_ActionPerformed(evt);
            }
        });
        b5.setBackground(colorBackground);
        b5.setForeground(colorText);
        b5.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b5);

        b6.setBounds(262, 250, 75, 50);
        b6.setText("6");
        b6.setMargin(new Insets(2, 2, 2, 2));
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b6_ActionPerformed(evt);
            }
        });
        b6.setBackground(colorBackground);
        b6.setForeground(colorText);
        b6.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b6);

        b7.setBounds(112, 300, 75, 50);
        b7.setText("7");
        b7.setMargin(new Insets(2, 2, 2, 2));
        b6.setFocusable(false);
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b7_ActionPerformed(evt);
            }
        });
        b7.setBackground(colorBackground);
        b7.setForeground(colorText);
        b7.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b7);

        b8.setBounds(187, 300, 75, 50);
        b8.setText("8");
        b8.setMargin(new Insets(2, 2, 2, 2));
        b8.setFocusable(false);
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b8_ActionPerformed(evt);
            }
        });
        b8.setFont(new Font("Century", Font.BOLD, 22));
        b8.setBackground(colorBackground);
        b8.setForeground(colorText);
        b8.setBorderPainted(true);
        cp.add(b8);

        b9.setBounds(262, 300, 75, 50);
        b9.setText("9");
        b9.setMargin(new Insets(2, 2, 2, 2));
        b9.setFocusable(false);
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b9_ActionPerformed(evt);
            }
        });
        b9.setFont(new Font("Century", Font.BOLD, 22));
        b9.setBackground(colorBackground);
        b9.setForeground(colorText);
        cp.add(b9);

        bDelete.setBounds(112, 350, 75, 50);
        bDelete.setText("Delete");
        bDelete.setMargin(new Insets(2, 2, 2, 2));
        bDelete.setFocusable(false);
        bDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDelete_ActionPerformed(evt);
            }
        });
        bDelete.setBackground(colorBackground);
        bDelete.setForeground(colorText);
        bDelete.setFont(new Font("Century", Font.BOLD, 16));
        cp.add(bDelete);

        b0.setBounds(187, 350, 75, 50);
        b0.setText("0");
        b0.setMargin(new Insets(2, 2, 2, 2));
        b0.setFocusable(false);
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b0_ActionPerformed(evt);
            }
        });
        b0.setBackground(colorBackground);
        b0.setForeground(colorText);
        b0.setFont(new Font("Century", Font.BOLD, 22));
        cp.add(b0);

        bCorrect.setBounds(262, 350, 75, 50);
        bCorrect.setText("Correct");
        bCorrect.setMargin(new Insets(2, 2, 2, 2));
        bCorrect.setFocusable(false);
        bCorrect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bCorrect_ActionPerformed(evt);
            }
        });
        bCorrect.setBackground(colorBackground);
        bCorrect.setForeground(colorText);
        bCorrect.setFont(new Font("Century", Font.BOLD, 16));
        cp.add(bCorrect);

        bEnter.setBounds(112, 400, 225, 30);
        bEnter.setText("Enter");
        bEnter.setMargin(new Insets(2, 2, 2, 2));
        bEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bEnter_ActionPerformed(evt);
            }
        });
        bEnter.setBackground(colorBackground);
        bEnter.setForeground(colorText);
        bEnter.setFont(new Font("Century", Font.BOLD, 16));
        cp.add(bEnter);

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

        bAdmin.setBounds(265, 455, 50, 50);
        bAdmin.setText("Admin");
        bAdmin.setMargin(new Insets(2, 2, 2, 2));
        bAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAdmin_ActionPerformed(evt);
            }
        });
        bAdmin.setBackground(colorBackground);
        bAdmin.setForeground(colorText);
        bAdmin.setFont(new Font("Century", Font.PLAIN, 12));
        cp.add(bAdmin);

        bHelp.setBounds(-1, -1, 25, 25);
        bHelp.setText("?");
        bHelp.setMargin(new Insets(2, 2, 2, 2));
        bHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bHelp_ActionPerformed(evt);
            }
        });
        bHelp.setBackground(colorBackground);
        bHelp.setForeground(colorText);
        bHelp.setFont(new Font("Century", Font.PLAIN, 12));
        bHelp.setHorizontalTextPosition(SwingConstants.CENTER);
        bHelp.setBorderPainted(true);

        cp.add(bHelp);
        // Ende Komponenten

        setVisible(true);
    } // end of public aaaaa

    // Anfang
    public JTextField checkField() {
        JTextField current = null;
        if (fAccountNumber.isFocusOwner()) {
            current = fAccountNumber;
        } else {
            if (fPin.isFocusOwner()) {
                current = fPin;
            }
        }
        return current;
    }

    public void b1_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 1);

    } // end of b1_ActionPerformed

    public void b2_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 2);
    } // end of b2_ActionPerformed

    public void b3_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 3);

    } // end of b3_ActionPerformed

    public void b4_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 5);
    } // end of b4_ActionPerformed

    public void b5_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 5);

    } // end of b5_ActionPerformed

    public void b6_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 6);

    } // end of b6_ActionPerformed

    public void b7_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 7);

    } // end of b7_ActionPerformed

    public void b8_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 8);

    } // end of b8_ActionPerformed

    public void b9_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 9);

    } // end of b9_ActionPerformed

    public void bDelete_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText("");

    } // end of bDelete_ActionPerformed

    public void b0_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        current.setText(current.getText() + 0);

    } // end of b0_ActionPerformed

    public void bCorrect_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        JTextField current = checkField();
        String input = current.getText();
        current.setText(input.substring(0, input.length() - 1));


    } // end of bCorrect_ActionPerformed

    public void bLanguage_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen

    } // end of bLanguage_ActionPerformed

    public void bDark_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
        if (colorBackground == Automat.lightColor) {
            new Startmenue(Automat.darkColor, Automat.lightColor);
        } else {
            new Startmenue(Automat.lightColor, Automat.darkColor);
        }

    } // end of bDark_ActionPerformed

    public void bAdmin_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
        new Admin(colorBackground, colorText);

    } // end of bAdmin_ActionPerformed

    public void bEnter_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen
        dispose();
        new Loginmenue(colorBackground, colorText);

    } // end of bEnter_ActionPerformed

    public void bHelp_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einf�gen

    } // end of bHelp_ActionPerformed

    // Ende Methoden
} // end of class aaaaa

