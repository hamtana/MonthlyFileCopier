package Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

// Import dropdown menu
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import FileProcessing.FileCopier;
import Graphics.FileSelecter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static Graphics.FileSelecter.getFileExtension;


public class GUI extends JFrame {

    public GUI() {
        setTitle("File Copier");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        // Create a label for the month selection
        JLabel monthLabel = new JLabel("Select Month:");
        monthLabel.setBounds(50, 20, 100, 25);
        panel.add(monthLabel);

        // Create a dropdown menu for month selection
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(150, 20, 150, 25);
        panel.add(monthComboBox);

        // Create a label for the year selection
        JLabel yearLabel = new JLabel("Select Year:");
        yearLabel.setBounds(50, 60, 100, 25);
        panel.add(yearLabel);

        // Create a text field for year input
        JTextField yearTextField = new JTextField();
        yearTextField.setBounds(150, 60, 150, 25);
        panel.add(yearTextField);

        // Add a JFile Chooser to retrieve the source path of the file
        File sourceFile = FileSelecter.getFileExtension();
        String sourcePath = sourceFile.getAbsolutePath();
        String destinationPath = sourceFile.getParent(); // Use the parent directory as the destination

        // Add a Drop down menu to select the file copier method
        String[] methods = {"Daily Sheet", "AM Capacity Meeting", "PM Capacity Meeting"};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);
        methodComboBox.setBounds(320, 20, 200, 25);
        panel.add(methodComboBox);

        // Create a button to copy files
        JButton copyButton = new JButton("Copy Files");
        copyButton.setBounds(50, 100, 250, 30);
        panel.add(copyButton);

        // Add action listener to the button
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                String enteredYear = yearTextField.getText();

                // Validate the year input
                if (enteredYear.isEmpty() || !enteredYear.matches("\\d{4}")) {
                    System.out.println("Please enter a valid year.");
                    return;
                }
                else {
                    // Call the file copying method (to be implemented)
                    // Check which method has been selected, Daily Sheet, AM Capacity Meeting, or PM Capacity Meeting.
                    FileCopier.copyDailySheet(sourcePath, destinationPath, selectedMonth, enteredYear);
                    System.out.println("Files copied for " + selectedMonth + " " + enteredYear);
                }
                }


        }
        );


    }
}
