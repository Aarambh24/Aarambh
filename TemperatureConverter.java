import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame implements ActionListener {

    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JButton convertButton;
    private JTextField outputField;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel enterLabel = new JLabel("Enter Temperature:");
        JLabel resultLabel = new JLabel("Result:");

        inputField = new JTextField(10);
        unitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        convertButton = new JButton("Convert");
        outputField = new JTextField(10);

        outputField.setEditable(false); // Make the output field read-only

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(enterLabel)
                        .addComponent(resultLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputField)
                        .addComponent(outputField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(unitComboBox)
                        .addComponent(convertButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(enterLabel)
                        .addComponent(inputField)
                        .addComponent(unitComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(resultLabel)
                        .addComponent(outputField)
                        .addComponent(convertButton))
        );

        add(panel, BorderLayout.NORTH);

        convertButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double inputTemperature = Double.parseDouble(inputField.getText());
            String selectedUnit = unitComboBox.getSelectedItem().toString();

            double convertedTemperature;

            if (selectedUnit.equals("Celsius")) {
                convertedTemperature = (inputTemperature * 9/5) + 32;
                outputField.setText(String.format("%.2f Fahrenheit", convertedTemperature));
            } else if (selectedUnit.equals("Fahrenheit")) {
                convertedTemperature = (inputTemperature - 32) * 5/9;
                outputField.setText(String.format("%.2f Celsius", convertedTemperature));
            }
        } catch (NumberFormatException ex) {
            outputField.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverter converter = new TemperatureConverter();
            converter.setVisible(true);
        });
    }
}
