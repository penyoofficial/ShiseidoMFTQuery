// Copyright (c) Penyo. All rights reserved.

package com.penyo.shiseidomftquery;

import java.awt.*;
import java.awt.event.*;

/**
 * 该类定义了友好的图形用户界面。
 * 
 * @author Penyo
 */
public class GUI {
    private Frame frame = new Frame("Shiseido Products Manufacturing Time Query");
    private Label guide = new Label("Welcome to use ShiseidoMFTQuery! Input the 6-bit code on the package:");
    private TextField infoExchange = new TextField();
    private Button query = new Button("Query");

    public GUI() {
        frame.add(guide, BorderLayout.NORTH);
        frame.add(infoExchange);
        frame.add(query, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        query.addActionListener((e) -> infoExchange.setText(Core.core(infoExchange.getText())));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}