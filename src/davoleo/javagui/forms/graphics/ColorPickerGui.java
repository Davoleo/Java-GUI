package davoleo.javagui.forms.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 30/01/2019 / 21:04
 * Class: ColorPickerGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class ColorPickerGui extends JFrame {

    private JButton button;
    private Color color = Color.WHITE;
    private JPanel panel;

    public ColorPickerGui()
    {
        super("Color Choosing GFXs");
        panel = new JPanel();
        panel.setBackground(color);

        button = new JButton("Choose a Color");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                color = JColorChooser.showDialog(null, "Pick your color", color);
                if (color == null)
                    color = Color.WHITE;

                panel.setBackground(color);
            }
        });

        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

}
