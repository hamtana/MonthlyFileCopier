package FileProcessing;

import java.nio.file.Files;

public class FileCopier {

    /**
     * Copies a file from sourcePath to destinationPath.
     *
     * @param sourcePath      The path of the source file.
     * @param destinationPath The path where the file should be copied.
     */
    public static void copyFile(String sourcePath, String destinationPath) {
       // Copy File
        try {
            Files.copy(java.nio.file.Paths.get(sourcePath), java.nio.file.Paths.get(destinationPath));
            System.out.println("File copied from " + sourcePath + " to " + destinationPath);
        } catch (Exception e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    /**
     * Copies daily sheets for a given month and year from sourcePath to destinationPath.
     *
     * @param sourcePath      The path of the source file.
     * @param destinationPath The path where the files should be copied.
     * @param month           The month for which daily sheets are to be copied.
     * @param year            The year for which daily sheets are to be copied.
     */
    public static void copyDailySheet(String sourcePath, String destinationPath, String month, String year) {

        int daysInMonth = CheckMonth.getDaysInMonth(month, year);

        for (int day = 1; day <= daysInMonth; day++) {
            String dayString = String.format("%02d", day);

        }



    }

    public static void copyAmCapacityMeeting(String sourcePath, String destinationPath, String month, String year) {


    }



}

