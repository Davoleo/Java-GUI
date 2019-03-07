package davoleo.javagui.forms;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 02/12/2018 / 00:10
 * Class: JFrameGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JFrameGui extends JFrame {

    private JLabel label1;

    public JFrameGui()
    {
        super("A super nice title bar");
        setLayout(new FlowLayout());

        label1 = new JLabel("this is a label");
        label1.setToolTipText("I suggest you that this is a label");

        add(label1);
    }
}
