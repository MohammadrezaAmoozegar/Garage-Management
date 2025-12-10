package controller;

import ui.TopPanel;
import ui.CenterPanel;
import ui.BottomPanel;
import model.ParkingManager;
import model.MyStack;
import model.MyQueue;

import javax.swing.*;

public class ParkingController {

    private ParkingManager manager;
    private TopPanel top;
    private CenterPanel center;
    private BottomPanel bottom;

    public ParkingController(ParkingManager manager, TopPanel top, CenterPanel center, BottomPanel bottom) {
        this.manager = manager;
        this.top = top;
        this.center = center;
        this.bottom = bottom;

        setupListeners();
        refreshUI();
    }

    private void setupListeners() {

        // 1) Enter First Empty Stack
        top.getBtnEnterFirstEmpty().addActionListener(e -> {
            String carText = top.getCarId();
            if (!isValidInt(carText)) {
                JOptionPane.showMessageDialog(null, "Invalid Car ID.");
                return;
            }
            int carId = Integer.parseInt(carText);
            String msg = manager.addCarToFirstAvailable(carId);
            JOptionPane.showMessageDialog(null, msg);
            refreshUI();
        });

        // 2) Enter Specific Stack
        top.getBtnEnterSpecificStack().addActionListener(e -> {
            String carText = top.getCarId();
            String stackText = top.getStackNumber();
            if (!isValidInt(carText) || !isValidInt(stackText)) {
                JOptionPane.showMessageDialog(null, "Invalid input.");
                return;
            }
            int carId = Integer.parseInt(carText);
            int stackNum = Integer.parseInt(stackText);
            String msg = manager.addCarToStack(carId, stackNum);
            JOptionPane.showMessageDialog(null, msg);
            refreshUI();
        });

        // 3) Exit Stack
        top.getBtnExit().addActionListener(e -> {
            String stackText = top.getStackNumber();
            if (!isValidInt(stackText)) {
                JOptionPane.showMessageDialog(null, "Enter stack number.");
                return;
            }
            int stackNum = Integer.parseInt(stackText);
            String msg = manager.removeFromStack(stackNum);
            JOptionPane.showMessageDialog(null, msg);
            refreshUI();
        });

        // 4) Find Car
        top.getBtnFind().addActionListener(e -> {
            String carText = top.getCarId();
            if (!isValidInt(carText)) {
                JOptionPane.showMessageDialog(null, "Invalid Car ID.");
                return;
            }
            int carId = Integer.parseInt(carText);
            String msg = manager.find(carId);
            JOptionPane.showMessageDialog(null, msg);
        });

        // 5) Sort Stack
        top.getBtnSort().addActionListener(e -> {
            String stackText = top.getStackNumber();
            if (!isValidInt(stackText)) {
                JOptionPane.showMessageDialog(null, "Invalid stack number.");
                return;
            }
            int stackNum = Integer.parseInt(stackText);
            manager.sortStack(stackNum);
            JOptionPane.showMessageDialog(null, "Stack sorted.");
            refreshUI();
        });

        // 6) Swap Stacks
        top.getBtnSwap().addActionListener(e -> {
            String s1 = JOptionPane.showInputDialog("Enter first stack number:");
            String s2 = JOptionPane.showInputDialog("Enter second stack number:");
            if (!isValidInt(s1) || !isValidInt(s2)) {
                JOptionPane.showMessageDialog(null, "Invalid inputs.");
                return;
            }
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            String msg = manager.swapStacks(a, b);
            JOptionPane.showMessageDialog(null, msg);
            refreshUI();
        });
    }

    private boolean isValidInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // O(n^2)
    private void refreshUI() {
        // Update stacks
        MyStack[] stacks = manager.getStacks();
        for (int i = 0; i < stacks.length; i++) {
            center.setStackText(i, stacks[i].toString());
        }

        // Update queue
        MyQueue q = manager.getQueue();
        bottom.setQueueText(q.toString());
    }
}
