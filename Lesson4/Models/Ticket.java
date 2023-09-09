package Lesson4.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Модель билета
 */
public class Ticket{

    private int routeNumber;
    private  int place;
    private  int price;
    private  Date date;
    private boolean isValid;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public Ticket(int routeNumber, int place, int price, Date date, boolean isValid) {
        this.routeNumber = routeNumber;
        this.place = place;
        this.price = price;
        this.date = date;
        this.isValid = isValid;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public boolean getValid() {
        return isValid;
    }


    @Override
    public String toString() {
        return "Билет: " +
                " маршрут: " + routeNumber +
                ", место: " + place +
                ", цена: " + price + " руб." +
                ", дата: " + formatter.format(date) +
                ", " + (isValid ? "есть" : "продан");
    }


    public String toPrint() {
        return "Билет" +
                "\nмаршрут: " + routeNumber +
                "\nместо: " + place +
                "\nцена: " + price + "руб." +
                "\nдата " + formatter.format(date);
    }

    @Override
    public int hashCode() {
        return date.hashCode() ^ (routeNumber + place + price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.equals((Ticket) obj);
    }


    public boolean equals(Ticket ticket) {
        boolean isIt = ticket != null
                && ticket.getRouteNumber() == this.routeNumber
                && ticket.getPlace() == this.place
                && ticket.getPrice() == this.price
                && ticket.getDate() == this.date
                && ticket.hashCode() == this.hashCode();

        if (isIt) {
            return true;
        }
        return false;
    }

    public void setValid(boolean b) {
        this.isValid = b;
    }
}
