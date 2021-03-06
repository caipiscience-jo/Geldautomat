package bankautomat;

import java.util.Scanner;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;// program uses Scanner to obtain user input

/**
 * Klasse für die Erzeugung des Tastenfeldes
 */
public class Keypad {
    public static JButton B1;
    public static JButton B2;
    public static JButton B3;
    public static JButton B4;
    public static JButton B5;
    public JButton B6;
    public JButton B7;
    public JButton B8;
    public JButton B9;
    public JButton B0;
    public JButton BClear;
    public JButton BEnter;
    private Scanner input; // liest Daten aus der Befehlszeile
    private String userinput;


    // argumentloser Konstruktor initialisiert den Scanner
    public Keypad() {
        input = new Scanner(System.in);
    } // Ende des argumentlosem Tastaturfelds-Konstruktors

    // Rückgabe eines vom Benutzer eingegebenen Integer-Wertes
    public int getInput() {
        return input.nextInt(); // wir nehmen an, dass der Benutzer eine Integer-Zahl eingibt
    } // Ende der Methode "getInput"

    /**
     * Initialisiert die Buttons des Tastenfelds
     */
    public void setbuttons() {

        B1 = new JButton("1");
        B1.setText("1");
        B2 = new JButton("2");
        B3 = new JButton("3");
        B4 = new JButton("4");
        B5 = new JButton("5");
        B6 = new JButton("6");
        B7 = new JButton("7");
        B8 = new JButton("8");
        B9 = new JButton("9");
        B0 = new JButton("0");
        BClear = new JButton("Clear");
        BEnter = new JButton("Enter");

    }

    /**
     * Fügt die Buttons auf das Tastenfeld hinzu
     *
     * @return Panel mit dem zugefügten Buttons
     */
    public JPanel addkeypad() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(180, 160));
        panel.setBackground(Color.gray);
        panel.setLayout(new FlowLayout());
        panel.add(B1);
        panel.add(B2);
        panel.add(B3);
        panel.add(B4);
        panel.add(B5);
        panel.add(B6);
        panel.add(B7);
        panel.add(B8);
        panel.add(B9);
        panel.add(BClear);
        panel.add(B0);
        panel.add(BEnter);

        return panel;
    }

    /**
     * Gibt den Text in einem Eingabefeld zurück
     *
     * @return eingegebener Text
     */
    public String userinput() {
        return userinput();
    }

    /**
     * Leert Text im Eingabefeld
     */
    public void resetuserinput() {
        userinput = "";
    }

} // Ende der Klasse "Keypad"  


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/