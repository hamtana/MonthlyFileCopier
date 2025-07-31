package FileProcessing;

// Counts how many days are in a month of a given year and return it as an integer
public class CheckMonth {
    public static int getDaysInMonth(String month, String year){
        int daysInMonth = 0;

        if(month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")){
            daysInMonth = 30;
        } else if(month.equals("February")) {
            daysInMonth = (Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0) || (Integer.parseInt(year) % 400 == 0) ? 29 : 28;
        } else {
            daysInMonth = 31;
        }

        return daysInMonth;
    }

}
