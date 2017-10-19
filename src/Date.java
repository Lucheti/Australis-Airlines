import java.util.Calendar;


public class Date {
    int day;
    int month;
    int hour;
    int minute;

    public Date() {
        this.day = Calendar.DAY_OF_WEEK;
        this.month = Calendar.MONTH;
    }
    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }
    public Date(int day, int month , int hour , int minute) {
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
    }


//    **si implementamos las horas vamos a tener q activar este constructor**
//    public Date(int day, int month, int hour, int minute) {
//        this.day = day;
//        this.month = month;
//    }

    public String toString (){
        return day + "/" + month ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (day != date.day) return false;
        if (month != date.month) return false;
        return hour == date.hour;
    }

}
