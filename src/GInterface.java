import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

public class GInterface extends JFrame implements ActionListener {
    private static final JFrame frame = new JFrame("CALCULATOR");
    private static final JTextField textField = new JTextField(26);
    private static final GridLayout layoutForButtons = new GridLayout(4, 4);
    private static final JPanel mainPanel = new JPanel();
    private static final JPanel panelForButtons = new JPanel();
    private static final GInterface listener = new GInterface();
    private static StringBuilder str = new StringBuilder();


    public static void work() {
        setButtons();
        panelForButtons.setLayout(layoutForButtons);
        mainPanel.add(textField);
        mainPanel.add(panelForButtons);
        frame.add(mainPanel);
        frame.setSize(360, 180);
        frame.setVisible(true);
    }

    private static void setButtons() {
        for (int i = 0; i < 10; i++) {
            addButton(Integer.toString(i));
        }
        Stream.of("+", "-", "/", "c", "*", "=")
                .forEach(GInterface::addButton);
    }

    private static void addButton(String name) {
        JButton jTmp = new JButton(name);
        jTmp.addActionListener(listener);
        panelForButtons.add(jTmp);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String s1 = e.getActionCommand();
        if (s1.charAt(0) == 'c') {
            textField.setText("");
            str = new StringBuilder();
        } else if (s1.charAt(0) == '=') {
            String s = textField.getText();
            textField.setText(Calculus.calculator(s));
            str = new StringBuilder(Calculus.calculator(s));
        } else {
            str.append(e.getActionCommand());
            textField.setText(str.toString());
        }
    }
}
