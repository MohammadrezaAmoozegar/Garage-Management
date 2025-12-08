package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Frame extends JFrame{
    public Frame(){
        this.setTitle("GUI Example");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1820, 980);
        this.setResizable(false);

        this.add(new TopPanel(),BorderLayout.NORTH);
        this.add(new CenterPanel(6));
        this.add(new BottomPanel(),BorderLayout.SOUTH);

        this.setVisible(true);

        
    }
}
