package jframe.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMultiListGui extends JFrame {

    private JList leftList, rightList;
    private JButton moveButton;
    private static String[] food = {"bacon", "wings", "ham", "beef", "more bacon"};

    public JMultiListGui()
    {
        super("Multi-List");
        setLayout(new FlowLayout());

        leftList =  new JList(food);
        leftList.setVisibleRowCount(3);
        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftList));

        moveButton = new JButton("Copy =>");
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rightList.setListData(leftList.getSelectedValuesList().toArray());
            }
        });
        add(moveButton);

        rightList = new JList();
        rightList.setVisibleRowCount(3);
        rightList.setFixedCellWidth(100);
        rightList.setFixedCellHeight(15);
        rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(rightList));
    }

}
