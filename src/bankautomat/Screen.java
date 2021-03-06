package bankautomat;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Klasse für das Anzeigen der einzelnen Menüs
 */
public class Screen extends JFrame {
    public static JTextField Inputfield1; // Zum Eingeben einer Kontonnummer, nicht implementiert
    public static JTextField Inputfield2;
    public static JTextField Inputfield3;
    public static JTextField Inputfield4;
    public JFrame Mainframe;
    public JLabel messageJLabel;
    public JLabel messageJLabel2; // zeigt eine Meldung über dem Login Status an
    public JLabel messageJLabel3;
    public JLabel messageJLabel4;
    public JLabel messageJLabel5;
    public JLabel messageJLabel8;
    public JLabel messageJLabel9;
    public JLabel messageJLabel10;
    public JButton loginbutton; // kreiert einen neuen Login
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton Exit;
    public int accnum = 0;
    public int PIN = 0;
    public JLabel messageJLabel6;
    public JLabel messageJLabel7;

    public Screen() {
        Mainframe = new JFrame();
        // Versuch Fenster mittig auszurichten
        Mainframe.setLocationRelativeTo(null);
    }

    /**
     * Zeigt einen Text an
     *
     * @param message anzuzeigender Text
     */
    public void displayMessage(String message) {
        System.out.print(message);
    } // Ende der Methode "displayMessage"

    /**
     * Zeigt einen Text am Anfang der Zeile an
     *
     * @param message anzuzeigender Text
     */
    public void displayMessageLine(String message) {
        System.out.println(message);
    } // Ende der Methode "displayMessageLine"

    /**
     * Zeigt einen Betrag in Dollar an
     *
     * @param amount Geldsumme
     */
    public void displayDollarAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    } // Ende der Methode "displayDollarAmount"

    /**
     * Generiert die Login GUI
     */
    public void createlogin() {

        Mainframe.setTitle("ATM");
        messageJLabel4 = new JLabel("Insert your credit/debit card then                             ");
        messageJLabel = new JLabel("  Enter your PIN number:    ");

        // Inputfield1 = new JTextField(10);

        messageJLabel2 = new JLabel(" 														                  ");
        Inputfield2 = new JTextField(10);
        loginbutton = new JButton("Login");
        messageJLabel3 = new JLabel("");
        Mainframe.setLayout(new FlowLayout()); // Layout festlegen
        Mainframe.add(messageJLabel4);
        Mainframe.add(messageJLabel); // erste Eingabeaufforderung hinzufügen
        // Mainframe.add(Inputfield1);
        Mainframe.add(Inputfield2);
        Mainframe.add(messageJLabel2);
        // Mainframe.add(loginbutton);
        // Nachrichtkennzeichnung hinzufügen
        Mainframe.add(messageJLabel3);
        Inputfield2.setEditable(false);
        Mainframe.repaint();

    }

    /**
     * Generiert die Hauptmenü GUI eines normalen Kontos
     */
    public void createmenu() {
        Mainframe.getContentPane().removeAll();
        messageJLabel = new JLabel("Welcome");
        messageJLabel2 = new JLabel("1 - Balance");
        messageJLabel3 = new JLabel("2 - Withdrawal");
        messageJLabel4 = new JLabel("3 - Deposit");
        messageJLabel5 = new JLabel("4 - Exit");
        Mainframe.setLayout(new FlowLayout()); // Layout festlegen
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel2); // erste Eingabeaufforderung hinzufügen
        Mainframe.add(messageJLabel3); // zweite Eingabeaufforderung hinzufügen
        Mainframe.add(messageJLabel4); // Nachrichtenkennzeichnung hinzufügen
        Mainframe.add(messageJLabel5);
        Mainframe.repaint();
    }

    /**
     * Generiert die Kontostandübersicht GUI
     */
    public void creatBalanceGUI() {
        Mainframe.getContentPane().removeAll();
        messageJLabel = new JLabel("Balance Information:        ");
        messageJLabel2 = new JLabel("Avaliable Balance:");
        messageJLabel3 = new JLabel("Total Balance:");
        Exit = new JButton("Back");
        Mainframe.setLayout(new FlowLayout());
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel2);
        Mainframe.add(messageJLabel3);
        Mainframe.add(Exit);
        Mainframe.repaint();
    }

    /**
     * Generiert die Auszahlungsmenü GUI
     */
    public void createWithdrawGUI() {
        Mainframe.getContentPane().removeAll();
        Mainframe.revalidate();
        messageJLabel = new JLabel("Withdraw Menu:                       ");
        messageJLabel2 = new JLabel("1 - $20 ");
        messageJLabel3 = new JLabel("2 - $40 ");
        messageJLabel4 = new JLabel("3 - $60 ");
        messageJLabel5 = new JLabel("4 - $100 ");
        messageJLabel6 = new JLabel("5 - $200 ");
        messageJLabel7 = new JLabel("            Choose an amount to withdraw");
        Exit = new JButton("Cancel");
        Mainframe.setLayout(new FlowLayout());
        Mainframe.add(messageJLabel);
        Mainframe.add(messageJLabel2);
        Mainframe.add(messageJLabel3);
        Mainframe.add(messageJLabel4);
        Mainframe.add(messageJLabel5);
        Mainframe.add(messageJLabel6);
        Mainframe.add(Exit);
        Mainframe.add(messageJLabel7);
        Mainframe.repaint();

    }

    /**
     * Generiert die Einzahlungsmenü GUI
     */
    public void CreateDepositGUI() {
        Mainframe.getContentPane().removeAll();
        messageJLabel2 = new JLabel("Please enter a deposit amount in CENTS");
        messageJLabel3 = new JLabel("");
        Inputfield2 = new JTextField(10);
        Inputfield2.setEditable(false);
        button1 = new JButton("Deposit");
        Exit = new JButton("Cancel");
        Mainframe.add(messageJLabel2);
        Mainframe.add(messageJLabel3);
        Mainframe.add(Inputfield2);
        Mainframe.add(Exit);
        Mainframe.repaint();
    }

    /**
     * erneuert ein Fenster
     */
    public void setGUI() {
        repaint();
    }

    /**
     * Generiert das Administratormenü
     */
    public void createAdminpage() {
        messageJLabel = new JLabel("View Users:");
        messageJLabel2 = new JLabel("Account number:");
        messageJLabel3 = new JLabel("Avaliable Balance:");
        messageJLabel4 = new JLabel("Total Balance:");
        messageJLabel5 = new JLabel("________________________________________________");
        button1 = new JButton("Next");
        button4 = new JButton("Previous");
        Exit = new JButton("Back");
        Inputfield1 = new JTextField(10);
        Inputfield2 = new JTextField(10);
        Inputfield3 = new JTextField(10);
        Inputfield4 = new JTextField(10);
        Mainframe.setLayout(new FlowLayout());
        messageJLabel6 = new JLabel("Add Account: ");
        messageJLabel7 = new JLabel("User name: ");
        Mainframe.add(messageJLabel);
        messageJLabel8 = new JLabel("          Account number: ");
        Mainframe.add(messageJLabel2);
        messageJLabel10 = new JLabel("                                       PIN: ");

        messageJLabel9 = new JLabel("              Balance number: ");
        button2 = new JButton("Add");
        button3 = new JButton("Delete");

        Mainframe.add(messageJLabel3);
        Mainframe.add(messageJLabel4);
        Mainframe.add(button4);
        Mainframe.add(button1);
        Mainframe.add(button3);
        Mainframe.add(messageJLabel5);
        Mainframe.add(messageJLabel6);
        Mainframe.add(messageJLabel7);
        Mainframe.add(Inputfield1);
        Mainframe.add(messageJLabel8);
        Mainframe.add(Inputfield2);
        Mainframe.add(messageJLabel10);
        Mainframe.add(Inputfield4);
        Mainframe.add(messageJLabel9);
        Mainframe.add(Inputfield3);

        Mainframe.add(button2);

        Mainframe.add(Exit);
        Mainframe.repaint();
    }

} // Ende der Klasse "Screen"

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/