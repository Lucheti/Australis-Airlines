import java.util.Calendar;


public class Date {
    int day;
    int month;
    //ESTO ES PARA QUE EN CASO DE QUE NO NOS PASEN UN HORARIO HAY UN HORARIO PREDETERMINADO 00:00
    int hour = 0;
    int minute = 0;

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
        return day + "/" + month + " " + (hour<10? "0"+hour:hour) + ":" + (minute<10? "0"+minute:minute);
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

    public boolean isBefore(Date dateToCompare) {
        if (dateToCompare == null || getClass() != dateToCompare.getClass()) return false;


        if ((month == dateToCompare.month)&&(day == dateToCompare.day)) return hour < dateToCompare.hour;
        if (month == dateToCompare.month) return day <= dateToCompare.day;
        return month < dateToCompare.month;
    }
}

