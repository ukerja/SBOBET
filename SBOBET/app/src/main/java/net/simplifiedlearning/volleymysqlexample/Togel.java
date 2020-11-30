package net.simplifiedlearning.volleymysqlexample;

/**
 * Created by Belal on 10/18/2017.
 */

public class Togel {

    private final String period;
    private final String day;
    private final String date;
    private final String number;

    public Togel(String period, String day, String date, String number) {


        this.period = period;
        this.day = day;
        this.date = date;
        this.number = number;

    }

    public String getPeriod() {
        return period;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }

}
