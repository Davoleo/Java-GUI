package davoleo.javagui.forms.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 04/01/2019 / 15:18
 * Class: JComboboxGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JComboboxGui extends JFrame{

    private JComboBox box;
    private JLabel picture;

    private static String[] filename = {"../../../../resources/40x40.png", "../../../../resources/ingot_blue.png"};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};

    public JComboboxGui()
    {
        super("ComboBox!");
        setLayout(new FlowLayout());

        box = new JComboBox(filename);

        box.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if(e.getStateChange() == ItemEvent.SELECTED)
                        picture.setIcon(pics[box.getSelectedIndex()]);
                }
            }
        );

        add(box);
        picture=new JLabel(pics[0]);
        add(picture);
    }


}
