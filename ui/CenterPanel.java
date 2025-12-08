package ui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanel extends JPanel {

    private ArrayList<JTextArea> stackAreas;
    private int stackCount;

    public CenterPanel(int stackCount) {
        this.stackCount = stackCount;
        this.stackAreas = new ArrayList<>();

        // GridLayout: یک ردیف، n ستون
        setLayout(new GridLayout(1, stackCount, 10, 10));

        for (int i = 0; i < stackCount; i++) {
            JPanel panel = new JPanel(new BorderLayout());

            // Label for stack number
            panel.add(new JLabel("Stack " + (i + 1)), BorderLayout.NORTH);

            // Text area for stack content
            JTextArea area = new JTextArea();
            area.setEditable(false);
            stackAreas.add(area);

            JScrollPane scroll = new JScrollPane(area);
            panel.add(scroll, BorderLayout.CENTER);

            add(panel);
        }
    }

    // برای بروز رسانی هر استک از بیرون
    public void setStackText(int index, String text) {
        if (index >= 0 && index < stackAreas.size()) {
            stackAreas.get(index).setText(text);
        }
    }

    // برای گرفتن تعداد استک‌ها
    public int getStackCount() {
        return stackCount;
    }
}

