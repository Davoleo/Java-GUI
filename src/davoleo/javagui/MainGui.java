package davoleo.javagui;

import davoleo.javagui.forms.JFrameGui;
import davoleo.javagui.forms.controls.*;
import davoleo.javagui.forms.event.ActionEventGui;
import davoleo.javagui.forms.event.KeyEventGui;
import davoleo.javagui.forms.event.MouseEventGui;
import davoleo.javagui.forms.graphics.ColorPickerGui;
import davoleo.javagui.forms.graphics.GFX;
import davoleo.javagui.forms.graphics.oval.DrawOvalGui;
import davoleo.javagui.forms.layouts.FormAbsoluteLayout;
import davoleo.javagui.forms.layouts.FormBorderLayout;
import davoleo.javagui.forms.layouts.FormBoxLayout;
import davoleo.javagui.forms.layouts.FormFlowLayout;
import davoleo.javagui.forms.practice.BrowserGui;
import davoleo.javagui.forms.practice.GuiTest;
import swing.jframe.controls.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public MainGui()
    {
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
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                designerGuiTest.setVisible(true);
            }
        });
        browserGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BrowserGui browser = new BrowserGui();
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
            }
        });
        keyeventGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                KeyEventGui keyGui = new KeyEventGui();
                keyGui.setSize(200, 200);
                keyGui.setVisible(true);
            }
        });
        mouseeventGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MouseEventGui mouseGui = new MouseEventGui();
                mouseGui.setSize(400, 400);
                mouseGui.setVisible(true);
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
            }
        });
        checkboxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JCheckboxGui checkboxGui = new JCheckboxGui();
                checkboxGui.setSize(270, 100);
                checkboxGui.setVisible(true);
            }
        });
        comboboxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboboxGui comboboxGui = new JComboboxGui();
                comboboxGui.setSize(300, 100);
                comboboxGui.setVisible(true);
            }
        });
        radiobuttonGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                JRadioButtonGui radioButtonGui = new JRadioButtonGui();
                radioButtonGui.setSize(300, 100);
                radioButtonGui.setVisible(true);
            }
        });
        listGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JListGui listGui = new JListGui();
                listGui.setSize(100, 200);
                listGui.setVisible(true);
            }
        });
        multilistGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JMultiListGui multiListGui = new JMultiListGui();
                multiListGui.setSize(350, 120);
                multiListGui.setVisible(true);
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
                borderLayout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        boxGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FormBoxLayout boxLayout = new FormBoxLayout();
                boxLayout.setSize(350, 150);
                boxLayout.setVisible(true);
            }
        });
        absoluteGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FormAbsoluteLayout absoluteLayout = new FormAbsoluteLayout();
                absoluteLayout.setSize(200, 150);
                absoluteLayout.setVisible(true);
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
            }
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
            }
        });
        colorpickerGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ColorPickerGui colorPickerGui = new ColorPickerGui();
                colorPickerGui.setSize(425, 150);
                colorPickerGui.setVisible(true);
            }
        });
        drawovalGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DrawOvalGui ovalGui = new DrawOvalGui();
                ovalGui.pack();
                ovalGui.setVisible(true);
            }
        });
    }

    public JPanel getContentPanel()
    {
        return contentPanel;
    }
}
