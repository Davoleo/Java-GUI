package net.davoleo.javagui.forms.layouts;

import javax.swing.*;
import java.awt.*;

public class FormGridLayout extends JFrame {

    public FormGridLayout()
    {
        this.setTitle("Grid Layout Example");

        this.setSize(400, 300);;
        this.setLocation(200, 100);

        //Stores components in a grid-like fashion
        //Params: 4 and 2 refer to the number of rows and columns
        //Params 10 and 20 refer to the horizontal and vertical gap between components
        this.setLayout(new GridLayout(4, 2, 10, 20));

        JButton b1 = new JButton("B1");
        JButton b2 = new JButton("B2");
        JButton b3 = new JButton("B3");
        JButton b4 = new JButton("B4");
        JButton b5 = new JButton("B5");
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
    }
}
