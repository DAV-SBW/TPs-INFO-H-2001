package Exos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Date {

    private static final int daysInMonths[]={31,28,31,30,31,30,31,31,30,31,30,31};
    private static final String monthInFrench[]={
            "Janvier", "Février", "Mars",
            "Avril", "Mai", "Juin", "Juillet", "Aout",
            "Septembre", "Octobre", "Novembre", "Decembre"
    };
    private static final String dayInFrench[]={
            "Lundi", "Mardi", "Mercredi",
            "Jeudi", "Vendredi", "Samedi",
            "Dimanche"
    };

    int day;
    int month;
    int year;

    public Date(int day, int month, int year){
        setMonth(month);
        setYear(year);
        setDay(day);
    }


    /**
     *  increments the date of one day
     **/
    public void increment(){
        if(lastDayOfMonth()) {
            setDay(1);
            if(month == 12){
                setMonth(1);
                setYear(year+1);
            } else {
                setMonth(month+1);
            }
        } else {
            setDay(day+1);
        }
    }

    /**
     *  @returns The number of days in the month this date belongs to.
     **/
    private int daysInMonth(){
        return Date.daysInMonths(month, year);
    }


    private static int daysInMonths(int month, int year) {
        int days = daysInMonths[month-1];
        if (month == 2 && Date.isLeapYear(year)){
            days += 1;
        }
        return days;
    }

    /**
     * @returns true if this is the last day of the month.
     */
    private boolean lastDayOfMonth(){
        return day == daysInMonth();
    }


    /**
     * @returns the day number in the current year this date represents.
     */
    public int dayOfYear(){
        int dayOfYear = this.day;
        for(int i = 1; i < month; i++)
            dayOfYear += Date.daysInMonths(i, year);
        return dayOfYear;
    }

    /**
     * @returns 0=monday, 1=tuesday, ..., 6=sunday
     * see http://en.wikipedia.org/wiki/Zeller's_congruence
     */
    public int dayOfWeek(){
        int m = this.month; // local copies because
        int y = this.year;  // month and year can be modified
        if(m == 1 || m == 2)
        {
            m += 12;
            y--;
        }

        int century = y/100;
        int yearOfCentury = y%100;
        int dayOfWeek = (day +
                + (((m+1)*26)/10)
                + yearOfCentury
                + (yearOfCentury/4)
                + (century/4)
                + 5*century) % 7;

        return (dayOfWeek+5)%7;
    }

    /**
     * @param year
     * @return true if it is a leap year.
     */
    private static boolean isLeapYear(int year){
        return year % 400 ==0 || (year %100 != 0 && year % 4 ==0);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * @param year
     * Sets the year.
     */

    public void setYear(int year){
        if(isLeapYear(this.year) && !isLeapYear(year) && lastDayOfMonth() && month == 2){
            throw new RuntimeException();
        } else {
            this.year = year;
        }
    }

    /**
     * Sets the day. But after have set the year and month !
     * @param day
     */
    private void setDay(int day) {
        if (day >= 1 && day <= this.daysInMonth()) {
            this.day = day;
        } else {
            throw new RuntimeException("C'est pas un bon jour...Nique ta race");
        }
    }

    /**
     * Sets the month.
     * @param month
     */
    private void setMonth(int month) {
        if (month >= 1 && month <=12){
            this.month = month;
        } else {
            throw new RuntimeException("Tu connais une année qui compte " + month + " Mois trouduc ?");
        }
    }


    public String toString(){
        return dayInFrench[dayOfWeek()]+" "+day+" "+
                monthInFrench[month-1]+" "+year+
                " le "+dayOfYear()+" ième jour de l'année";
    }

    public void writeToFile(String filename){
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(filename));
            file.write(this.toString());
            file.close();
        } catch (IOException e) {
            System.out.println("Problème pour écrire la date dans le fichier : \n" +e.getMessage());
        }
    }
}
