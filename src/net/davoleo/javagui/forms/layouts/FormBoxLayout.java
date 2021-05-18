package net.davoleo.javagui.forms.layouts;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 05/01/2019 / 16:55
 * Class: FormBoxLayout
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class FormBoxLayout extends JFrame {

    public FormBoxLayout()
    {
        super("Box Layout Example");
        Container content = getContentPane();
        setLayout(new BoxLayout(content, BoxLayout.X_AXIS));

        JPanel sx = new JPanel();
        JPanel dx = new JPanel();
        JPanel separator = new JPanel();

        sx.setLayout(new BoxLayout(sx, BoxLayout.Y_AXIS));
        separator.setLayout(new BoxLayout(separator, BoxLayout.X_AXIS));
        dx.setLayout(new BoxLayout(dx, BoxLayout.Y_AXIS));

        add(sx);
        add(separator);
        add(dx);

        content.setBackground(Color.BLACK);

        separator.add(new JButton("Button1"));
        separator.add(new JButton("Button2"));
        separator.add(new JButton("Button3"));

        JLabel label1 = new JLabel("YYYYY");
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setForeground(Color.WHITE);
        sx.add(label1);

        JLabel label2 = new JLabel("YYYYY");
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setForeground(Color.WHITE);
        sx.add(label2);

        JLabel label3 = new JLabel("YYYYY");
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setForeground(Color.WHITE);
        sx.add(label3);

        JLabel label4 = new JLabel("XXXXX");
        label4.setOpaque(true);
        label4.setBackground(Color.RED);
        label4.setForeground(Color.YELLOW);
        dx.add(label4);

        JLabel label5 = new JLabel("XXXXX");
        label5.setOpaque(true);
        label5.setBackground(Color.GREEN);
        label5.setForeground(Color.YELLOW);
        dx.add(label5);

        JLabel label6 = new JLabel("XXXXX");
        label6.setOpaque(true);
        label6.setBackground(Color.BLUE);
        label6.setForeground(Color.YELLOW);
        dx.add(label6);


    }

}
