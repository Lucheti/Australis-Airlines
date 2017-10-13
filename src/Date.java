import java.util.Calendar;


public class Date {
    int year = Calendar.YEAR;
    int month = Calendar.MONTH;
    int week = Calendar.WEEK_OF_YEAR;
    int day = Calendar.DAY_OF_WEEK;
    int hour = Calendar.HOUR_OF_DAY;
    int minute = Calendar.MINUTE;

    String getDate (){
        return day + "/" + month + "/" +year;
    }
    String getTime (){
        return hour + ":" + minute;
    }
    int getWeek () { return week;}
}
