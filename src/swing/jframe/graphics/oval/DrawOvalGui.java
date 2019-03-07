package swing.jframe.graphics.oval;

import swing.jframe.graphics.oval.Oval;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 20/02/2019 / 20:25
 * Class: DrawOvalGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class DrawOvalGui extends JFrame {

    private JSlider slider;
    private Oval panel;
    private JLabel hint;

    public DrawOvalGui()
    {
        super("Oval Slider");
        panel = new Oval();
        panel.setBackground(Color.ORANGE);

        hint = new JLabel("Press \"r\" to refresh slider values to the height of the panel ");

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, panel.getPreferredSize().height - 20, 10);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                panel.setD(slider.getValue());
            }
        });

        slider.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (e.getKeyChar() == 'r')
                    JOptionPane.showMessageDialog(null, "slider maximum refreshed to " + panel.getHeight());
                    slider.setMaximum(panel.getHeight() - 20);
            }
        });

        add(slider, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }
}
