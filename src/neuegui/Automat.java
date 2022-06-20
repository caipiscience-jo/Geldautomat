package neuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Startklasse des Automaten
 */
public class Automat {

    public static Color darkColor = new Color(25, 25, 25);
    public static Color lightColor = new Color(255, 255, 255);

    public static void main(String[] args) {
        new Startmenue(lightColor, darkColor);

    }

}
