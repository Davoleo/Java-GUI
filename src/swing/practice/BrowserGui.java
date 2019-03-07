package swing.practice;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 05/03/2019 / 23:27
 * Class: BrowserGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class BrowserGui extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    //Constructor
    public BrowserGui()
    {
        super("Browser");

        addressBar = new JTextField("Enter a URL bish!");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loadHTMLPage(e.getActionCommand());
            }
        });

        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e)
            {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                    loadHTMLPage(e.getURL().toString());
            }
        });
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    //Load html page to display
    private void loadHTMLPage(String userText)
    {
        try
        {
            display.setPage(new URL(userText));
            addressBar.setText(userText);
        }
        catch (IOException e)
        {
            System.out.println("WELCOME TO THE MALFORMED URL");
        }
    }

}
