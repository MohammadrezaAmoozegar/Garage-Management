package ui;

import java.awt.BorderLayout;
import javax.swing.*;

import controller.ParkingController;
import model.ParkingManager;

public class Frame extends JFrame {

    public Frame() {

        this.setTitle("GUI Example");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1820, 980);
        this.setResizable(false);

        TopPanel topPanel = new TopPanel();
        CenterPanel centerPanel = new CenterPanel(6);
        BottomPanel bottomPanel = new BottomPanel();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        int numberOfStacks = 6;
        int capacityPerStack = 5; 

        ParkingManager manager = new ParkingManager(numberOfStacks, capacityPerStack);

        new ParkingController(manager, topPanel, centerPanel, bottomPanel);

        this.setVisible(true);
    }
}
