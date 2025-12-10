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

        setLayout(new GridLayout(1, stackCount, 10, 10));

        for (int i = 0; i < stackCount; i++) {
            JPanel panel = new JPanel(new BorderLayout());

            panel.add(new JLabel("Stack " + (i + 1)), BorderLayout.NORTH);

            JTextArea area = new JTextArea();
            area.setEditable(false);
            stackAreas.add(area);

            JScrollPane scroll = new JScrollPane(area);
            panel.add(scroll, BorderLayout.CENTER);

            add(panel);
        }
    }

    public void setStackText(int index, String text) {
        if (index >= 0 && index < stackAreas.size()) {
            stackAreas.get(index).setText(text);
        }
    }

    public int getStackCount() {
        return stackCount;
    }
}

