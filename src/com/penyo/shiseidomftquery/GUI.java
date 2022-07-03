package com.penyo.shiseidomftquery;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 该类定义了友好的图形用户界面。
 * 
 * @author Penyo
 */
public class GUI {
    Frame frame = new Frame("资生堂产品生产日期查询器");
    Label guide = new Label("请在下面输入包装上的生产批号（一般是六位）：");
    TextField infoExchange = new TextField();
    Button query = new Button("查询");

    public GUI() {
        frame.add(guide, BorderLayout.NORTH);
        frame.add(infoExchange);
        frame.add(query, BorderLayout.SOUTH);

        frame.setSize(350, 105);
        frame.setVisible(true);

        query.addActionListener(e -> infoExchange.setText(new Core(infoExchange.getText()).toString()));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}