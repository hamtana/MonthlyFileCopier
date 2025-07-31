package Graphics;

import javax.swing.JFileChooser;
import java.io.File;

public class FileSelecter {

    public static String getFileExtension() {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the dialog title
        fileChooser.setDialogTitle("Select a File");

        // Show the open dialog
        int userSelection = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        } else {
            System.out.println("No file selected.");
        }
        return null; // Return null if no file was selected
    }

}
