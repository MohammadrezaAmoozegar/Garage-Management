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

        // -----------------------------
        // ساخت پنل‌ها
        // -----------------------------
        TopPanel topPanel = new TopPanel();
        CenterPanel centerPanel = new CenterPanel(6);
        BottomPanel bottomPanel = new BottomPanel();

        // اضافه کردن به فریم
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // -----------------------------
        // ساخت لاجیک (ParkingManager)
        // -----------------------------
        int numberOfStacks = 6;
        int capacityPerStack = 5; // یا هر عددی که پروژه نیاز دارد

        ParkingManager manager = new ParkingManager(numberOfStacks, capacityPerStack);

        // -----------------------------
        // ساخت کنترلر و اتصال UI به لاجیک
        // -----------------------------
        new ParkingController(manager, topPanel, centerPanel, bottomPanel);

        // -----------------------------
        // نمایش فریم
        // -----------------------------
        this.setVisible(true);
    }
}
