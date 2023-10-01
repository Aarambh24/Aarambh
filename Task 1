import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public CalculatorApp() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton = new JButton("Add");
        subButton = new JButton("Subtract");
        mulButton = new JButton("Multiply");
        divButton = new JButton("Divide");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

        add(new JLabel("Number 1: "));
        add(num1Field);
        add(new JLabel("Number 2: "));
        add(num2Field);
        add(new JLabel("Result: "));
        add(resultField);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());

        if (e.getSource() == addButton) {
            resultField.setText(String.valueOf(num1 + num2));
        } else if (e.getSource() == subButton) {
            resultField.setText(String.valueOf(num1 - num2));
        } else if (e.getSource() == mulButton) {
            resultField.setText(String.valueOf(num1 * num2));
        } else if (e.getSource() == divButton) {
            if (num2 != 0) {
                resultField.setText(String.valueOf(num1 / num2));
            } else {
                resultField.setText("Cannot divide by zero");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}
