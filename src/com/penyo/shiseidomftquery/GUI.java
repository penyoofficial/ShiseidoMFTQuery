package com.penyo.shiseidomftquery;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * 该类定义了友好的图形用户界面。
 * 
 * @author Penyo
 */
public class GUI {
    JFrame frame = new JFrame("资生堂产品生产日期查询器");
    JLabel guide = new JLabel("请在下面输入包装上的生产批号（一般是六位）：");
    JTextField infoExchange = new JTextField();
    JButton query = new JButton("查询");

    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException();
        }

        frame.add(guide, BorderLayout.NORTH);
        frame.add(infoExchange);
        frame.add(query, BorderLayout.SOUTH);

        frame.setSize(350, 105);
        frame.setVisible(true);

        query.addActionListener(e -> infoExchange.setText(new Core(infoExchange.getText()).toString()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
