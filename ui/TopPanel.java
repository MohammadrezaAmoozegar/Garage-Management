package ui;

import javax.swing.*;
import java.awt.*;
public class TopPanel extends JPanel {

    private JTextField carIdField;
    private JTextField stackNumberField;

    private JButton btnEnterFirstEmpty;
    private JButton btnEnterSpecificStack;
    private JButton btnExit;
    private JButton btnFind;
    private JButton btnSort;
    private JButton btnSwap;

    public TopPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(1820, 40));
        this.setBackground(Color.LIGHT_GRAY);

        // Car ID Input
        add(new JLabel("Car ID:"));
        carIdField = new JTextField(8);
        add(carIdField);

        // Stack Number Input
        add(new JLabel("Stack #:"));
        stackNumberField = new JTextField(4);
        add(stackNumberField);

        // Buttons
        btnEnterFirstEmpty = new JButton("Enter First Empty");
        add(btnEnterFirstEmpty);

        btnEnterSpecificStack = new JButton("Enter Stack #");
        add(btnEnterSpecificStack);

        btnExit = new JButton("Exit");
        add(btnExit);

        btnFind = new JButton("Find");
        add(btnFind);

        btnSort = new JButton("Sort Stack");
        add(btnSort);

        btnSwap = new JButton("Swap");
        add(btnSwap);
    }

    // Getters
    public String getCarId() {
        return carIdField.getText().trim();
    }

    public String getStackNumber() {
        return stackNumberField.getText().trim();
    }

    public JButton getBtnEnterFirstEmpty() { return btnEnterFirstEmpty; }
    public JButton getBtnEnterSpecificStack() { return btnEnterSpecificStack; }
    public JButton getBtnExit() { return btnExit; }
    public JButton getBtnFind() { return btnFind; }
    public JButton getBtnSort() { return btnSort; }
    public JButton getBtnSwap() { return btnSwap; }
}
