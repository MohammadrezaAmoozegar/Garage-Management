package ui;
import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private JTextArea queueArea;

    public BottomPanel() {
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1820, 150));
        this.setBackground(Color.LIGHT_GRAY);

        // Label (اختیاری ولی مفید)
        add(new JLabel("Queue:"), BorderLayout.NORTH);

        // Queue display area
        queueArea = new JTextArea();
        queueArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(queueArea);
        add(scroll, BorderLayout.CENTER);
    }

    // متدی برای بروز رسانی صف
    public void setQueueText(String text) {
        queueArea.setText(text);
    }
}
