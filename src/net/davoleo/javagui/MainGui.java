package net.davoleo.javagui;

import net.davoleo.javagui.forms.JFrameGui;
import net.davoleo.javagui.forms.controls.*;
import net.davoleo.javagui.forms.event.ActionEventGui;
import net.davoleo.javagui.forms.event.KeyEventGui;
import net.davoleo.javagui.forms.event.MouseEventGui;
import net.davoleo.javagui.forms.graphics.ColorPickerGui;
import net.davoleo.javagui.forms.graphics.GFX;
import net.davoleo.javagui.forms.graphics.oval.DrawOvalGui;
import net.davoleo.javagui.forms.layouts.*;
import net.davoleo.javagui.forms.practice.BrowserGui;
import net.davoleo.javagui.forms.practice.GuiTest;
import net.davoleo.javagui.forms.practice.messenger.Client;
import net.davoleo.javagui.forms.practice.messenger.Server;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/03/2019 / 18:01
 * Class: MainGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MainGui {
    private JButton buttonGui;
    private JPanel contentPanel;
    private JButton checkboxGui;
    private JButton comboboxGui;
    private JButton listGui;
    private JButton multilistGui;
    private JButton radiobuttonGui;
    private JButton tabbedpaneGui;
    private JPanel controlGuis;
    private JPanel eventGuis;
    private JButton actioneventGui;
    private JButton keyeventGui;
    private JButton mouseeventGui;
    private JButton drawovalGui;
    private JButton colorpickerGui;
    private JButton graphicsGui;
    private JPanel gfxGuis;
    private JButton absoluteGui;
    private JPanel layoutGuis;
    private JButton borderGui;
    private JButton boxGui;
    private JButton flowGui;
    private JButton iOBoxesGui;
    private JPanel otherGuis;
    private JButton browserGui;
    private JButton designerTestGui;
    private JButton firstJFrameGui;
    private JRadioButton radioMetal;
    private JRadioButton radioNimbus;
    private JPanel themePanel;
    private JRadioButton radioWindows;
    private JRadioButton radioWindowsC;
    private JRadioButton radioMotif;
    private JButton messengerServer;
    private JButton messengerClient;
    private JButton gridGui;

    public MainGui()
    {
        radioMetal.setText(LookAndFeels.METAL.getText());
        radioNimbus.setText(LookAndFeels.NIMBUS.getText());
        radioMotif.setText(LookAndFeels.MOTIF.getText());
        radioWindows.setText(LookAndFeels.WINDOWS.getText());
        radioWindowsC.setText(LookAndFeels.WINDOWS_CLASSIC.getText());

        ItemListener themeListener = new ThemeChangeHandler();
        radioMetal.addItemListener(themeListener);
        radioNimbus.addItemListener(themeListener);
        radioMotif.addItemListener(themeListener);
        radioWindows.addItemListener(themeListener);
        radioWindowsC.addItemListener(themeListener);

        //OTHER GUIs --------------------------------------------------
        iOBoxesGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Util.runIOBoxes();
            }
        });
        firstJFrameGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrameGui gui = new JFrameGui();
                gui.setSize(200,100);
                gui.setVisible(true);
            }
        });
        designerTestGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame designerGuiTest = new JFrame("Designer Form Test");
                designerGuiTest.setContentPane(new GuiTest().getMainPanel());
                designerGuiTest.pack();
                designerGuiTest.setLocation(Util.centerScreen(designerGuiTest.getWidth(), designerGuiTest.getHeight()));
                designerGuiTest.setVisible(true);
            }
        });
        browserGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BrowserGui browser = new BrowserGui();
                browser.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            }
        });
        messengerServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Server imServer = new Server();
                imServer.setLocation(Util.centerScreen(imServer.getWidth(), imServer.getHeight()));
                Thread thread = new Thread(imServer::startServer);
                thread.start();
            }
        });
        messengerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Client imClient = new Client("127.0.0.1");
                imClient.setLocation(Util.centerScreen(imClient.getWidth(), imClient.getHeight()));
                Thread thread = new Thread(imClient::startClient);
                thread.start();
            }
        });

        //Event GUIs ---------------------------------------------------
        actioneventGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ActionEventGui actionEventGui = new ActionEventGui();
                actionEventGui.setSize(500,100);
                actionEventGui.setVisible(true);
                actionEventGui.setLocation(Util.centerScreen(actionEventGui.getWidth(), actionEventGui.getHeight()));
            }
        });
        keyeventGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                KeyEventGui keyGui = new KeyEventGui();
                keyGui.setSize(200, 200);
                keyGui.setVisible(true);
                keyGui.setLocation(Util.centerScreen(keyGui.getWidth(), keyGui.getHeight()));
            }
        });
        mouseeventGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MouseEventGui mouseGui = new MouseEventGui();
                mouseGui.setSize(400, 400);
                mouseGui.setVisible(true);
                mouseGui.setLocation(Util.centerScreen(mouseGui.getWidth(), mouseGui.getHeight()));
            }
        });

        //Controls GUIs ---------------------------------------------------
        buttonGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButtonGui buttonGui = new JButtonGui();
                buttonGui.setSize(300, 100);
                buttonGui.setVisible(true);
                buttonGui.setLocation(Util.centerScreen(buttonGui.getWidth(), buttonGui.getHeight()));
            }
        });
        checkboxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JCheckboxGui checkboxGui = new JCheckboxGui();
                checkboxGui.setSize(270, 100);
                checkboxGui.setVisible(true);
                checkboxGui.setLocation(Util.centerScreen(checkboxGui.getWidth(), checkboxGui.getHeight()));
            }
        });
        comboboxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboboxGui comboboxGui = new JComboboxGui();
                comboboxGui.setSize(300, 100);
                comboboxGui.setVisible(true);
                comboboxGui.setLocation(Util.centerScreen(comboboxGui.getWidth(), comboboxGui.getHeight()));
            }
        });
        radiobuttonGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                JRadioButtonGui radioButtonGui = new JRadioButtonGui();
                radioButtonGui.setSize(300, 100);
                radioButtonGui.setVisible(true);
                radioButtonGui.setLocation(Util.centerScreen(radioButtonGui.getWidth(), radioButtonGui.getHeight()));
            }
        });
        listGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JListGui listGui = new JListGui();
                listGui.setSize(100, 200);
                listGui.setVisible(true);
                listGui.setLocation(Util.centerScreen(listGui.getWidth(), listGui.getHeight()));
            }
        });
        multilistGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JMultiListGui multiListGui = new JMultiListGui();
                multiListGui.setSize(350, 120);
                multiListGui.setVisible(true);
                multiListGui.setLocation(Util.centerScreen(multiListGui.getWidth(), multiListGui.getHeight()));
            }
        });
        tabbedpaneGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame tabbedPaneGui = new JFrame("JTabbedPane Example!");
                tabbedPaneGui.setContentPane(new JTabbedPaneGui().getPanel1());
                tabbedPaneGui.pack();
                tabbedPaneGui.setVisible(true);
                tabbedPaneGui.setLocation(Util.centerScreen(tabbedPaneGui.getWidth(), tabbedPaneGui.getHeight()));
            }
        });

        //Layouts GUIs ---------------------------------------------------
        borderGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FormBorderLayout borderLayout = new FormBorderLayout();
                borderLayout.setSize(600, 500);
                borderLayout.setVisible(true);
                borderLayout.setLocation(Util.centerScreen(borderLayout.getWidth(), borderLayout.getHeight()));
            }
        });
        boxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FormBoxLayout boxLayout = new FormBoxLayout();
                boxLayout.setSize(350, 150);
                boxLayout.setVisible(true);
                boxLayout.setLocation(Util.centerScreen(boxLayout.getWidth(), boxLayout.getHeight()));
            }
        });
        absoluteGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FormAbsoluteLayout absoluteLayout = new FormAbsoluteLayout();
                absoluteLayout.setSize(200, 150);
                absoluteLayout.setVisible(true);
                absoluteLayout.setLocation(Util.centerScreen(absoluteLayout.getWidth(), absoluteLayout.getHeight()));
            }
        });
        flowGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame flowLayout = new JFrame("Flow Layout Example!");
                flowLayout.setContentPane(new FormFlowLayout().getPanel1());
                flowLayout.pack();
                flowLayout.setVisible(true);
                flowLayout.setLocation(Util.centerScreen(flowLayout.getWidth(), flowLayout.getHeight()));
            }
        });

        gridGui.addActionListener(event -> {
            FormGridLayout gridLayout = new FormGridLayout();
            gridLayout.setVisible(true);
            gridLayout.setLocation(Util.centerScreen(gridLayout.getWidth(), gridLayout.getHeight()));
        });

        //GFX GUIs -------------------------------------------------------
        graphicsGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame gfxFrame = new JFrame("Drawing Graphics!");
                GFX graphicsPanel = new GFX();
                gfxFrame.add(graphicsPanel);
                gfxFrame.setSize(200, 500);
                gfxFrame.setVisible(true);
                gfxFrame.setLocation(Util.centerScreen(gfxFrame.getWidth(),gfxFrame.getHeight()));
            }
        });
        colorpickerGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ColorPickerGui colorPickerGui = new ColorPickerGui();
                colorPickerGui.setSize(425, 150);
                colorPickerGui.setVisible(true);
                colorPickerGui.setLocation(Util.centerScreen(colorPickerGui.getWidth(), colorPickerGui.getHeight()));
            }
        });
        drawovalGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DrawOvalGui ovalGui = new DrawOvalGui();
                ovalGui.pack();
                ovalGui.setVisible(true);
                ovalGui.setLocation(Util.centerScreen(ovalGui.getWidth(), ovalGui.getHeight()));
            }
        });
    }

    public void refreshForm()
    {
        Main.mainGUI.repaint();
        for (Component component : this.contentPanel.getComponents())
            component.repaint();
    }

    public JPanel getContentPanel()
    {
        return contentPanel;
    }

    private class ThemeChangeHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getStateChange() != ItemEvent.SELECTED)
                return;

            try {
                String themeText = ((JRadioButton) e.getItem()).getText();
                LookAndFeels feels = LookAndFeels.getThemeByText(themeText);

                if (feels != null) {
                    UIManager.setLookAndFeel(feels.getCanonicalName());
                    SwingUtilities.updateComponentTreeUI(Main.mainGUI);
                }
                else
                    JOptionPane.showMessageDialog(Main.mainGUI,"Internal Naming Error while switching theme","Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}
