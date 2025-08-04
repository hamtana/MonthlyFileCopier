package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import FileProcessing.FileCopier;
import static Graphics.FileSelecter.getFileExtension;

public class GUI extends JFrame {

    public GUI() {
        setTitle("File Copier");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        JLabel monthLabel = new JLabel("Select Month:");
        monthLabel.setBounds(50, 20, 100, 25);
        panel.add(monthLabel);

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(150, 20, 150, 25);
        panel.add(monthComboBox);

        JLabel yearLabel = new JLabel("Select Year:");
        yearLabel.setBounds(50, 60, 100, 25);
        panel.add(yearLabel);

        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(150, 60, 150, 25);
        panel.add(yearTextField);

        String[] methods = {"Daily Sheet", "AM Capacity Meeting", "PM Capacity Meeting"};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);
        methodComboBox.setBounds(320, 20, 200, 25);
        panel.add(methodComboBox);

        JButton copyButton = new JButton("Copy Files");
        copyButton.setBounds(50, 100, 250, 30);
        panel.add(copyButton);

        // Label to show copy status
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(50, 150, 700, 25);
        panel.add(messageLabel);

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                String enteredYear = yearTextField.getText();

                if (enteredYear.isEmpty() || !enteredYear.matches("\\d{4}")) {
                    messageLabel.setText("❌ Please enter a valid 4-digit year.");
                    return;
                }

                File sourceFile = getFileExtension();
                if (sourceFile == null) {
                    messageLabel.setText("❌ No file selected.");
                    return;
                }

                String sourcePath = sourceFile.getAbsolutePath();
                String destinationPath = sourceFile.getParent();

                String selectedMethod = (String) methodComboBox.getSelectedItem();

                switch (selectedMethod) {
                    case "AM Capacity Meeting":
                        FileCopier.copyAmCapacityMeeting(sourcePath, destinationPath, selectedMonth, enteredYear);
                        messageLabel.setText("✅ AM Capacity Meeting files copied to: " + destinationPath);
                        break;
                    case "PM Capacity Meeting":
                        FileCopier.copyPmCapacityMeeting(sourcePath, destinationPath, selectedMonth, enteredYear);
                        messageLabel.setText("✅ PM Capacity Meeting files copied to: " + destinationPath);
                        break;
                    default:
                        FileCopier.copyDailySheet(sourcePath, destinationPath, selectedMonth, enteredYear);
                        messageLabel.setText("✅ Daily Sheet files copied to: " + destinationPath);
                        break;
                }

                panel.revalidate();
                panel.repaint();
            }
        });
    }
}
