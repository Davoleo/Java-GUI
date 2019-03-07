package davoleo.javagui.forms.layouts;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 05/01/2019 / 16:24
 * Class: FormBorderLayout
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class FormBorderLayout extends JFrame {

    public FormBorderLayout()
    {
        super("Border Layout Example");
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Un'etichetta dentro la finestra esempio");
        add(label, BorderLayout.WEST);
        label.setText("E INVECE NO!");
        label.setForeground(Color.RED);
        //Per lo sfondo della finestra bisogna accedere al pane del contenuto del frame
        getContentPane().setBackground(Color.BLACK);

        //Lo sfondo delle label di default è trasparente, bisogna dunque settarlo come opaco prima di poter vedere il colore
        label.setOpaque(true);
        label.setBackground(Color.DARK_GRAY);

        JLabel label2 = new JLabel("seconda etichetta...");
        label2.setOpaque(true);
        label2.setBackground(Color.YELLOW);
        add(label2, BorderLayout.EAST);

        JLabel label3 = new JLabel("Top Label");
        label3.setForeground(Color.WHITE);
        add(label3, BorderLayout.NORTH);

        JLabel label4 = new JLabel("Bottom Label");
        label4.setForeground(Color.WHITE);
        add(label4, BorderLayout.SOUTH);

        JButton button = new JButton("Center Button");
        add(button);

    }

}
