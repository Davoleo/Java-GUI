package jframe.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 02/01/2019 / 15:50
 * Class: JRadioButtonGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JRadioButtonGui extends JFrame {

    private JTextField textbox = new JTextField("This text is controlled by Radio Buttons", 25);
    private JRadioButton plainButton, boldButton, italicButton, boldItalicButton;
    private ButtonGroup group = new ButtonGroup();
    private Font plainFont, boldFont, italicFont, boldItalicFont;

    public JRadioButtonGui()
    {
        super("Radio Buttons");
        setLayout(new FlowLayout());

        //Adding the textbox to the GUI
        add(textbox);

        //RadioButtons init
        plainButton = new JRadioButton("Plain", true);
        boldButton = new JRadioButton("Bold", false);
        italicButton = new JRadioButton("Italic", false);
        boldItalicButton = new JRadioButton("Bold & Italic", false);

        //Adding RadioButtons to the GUI
        add(plainButton); add(boldButton); add(italicButton); add(boldItalicButton);

        //Adding buttons to a button group, so that they are linked together
        group.add(plainButton); group.add(boldButton); group.add(italicButton); group.add(boldItalicButton);

        //Init the four Fonts
        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        //Setting a default Font
        textbox.setFont(plainFont);

        //Adding a listener to the buttons which also uses the Fonts
        plainButton.addItemListener(new JRadioButtonHandler(plainFont));
        boldButton.addItemListener(new JRadioButtonHandler(boldFont));
        italicButton.addItemListener(new JRadioButtonHandler(italicFont));
        boldItalicButton.addItemListener(new JRadioButtonHandler(boldItalicFont));
    }

    private class JRadioButtonHandler implements ItemListener
    {
        private Font font;

        JRadioButtonHandler(Font font)
        {
            this.font = font;
        }

        //Sets the font at runtime when the event is TRIGGERED
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            textbox.setFont(font);
        }
    }

}
