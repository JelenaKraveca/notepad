package lv.ctco.notepad;

import java.time.LocalDate;

/**
 * Created by yelena.kraveca on 11/30/2018.
 */
public class Reminder extends Alarm {
    private LocalDate date;

    public void setDate(LocalDate date) {
        this.date = date;    }


    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)|| getFormatedDate().contains(str);

    }



    public void askData() {
        super.askData();
        date = Main.askDate("Date");
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                " date='" + getFormatedDate() + '\'' +
                " time='" + getFormatedTime() + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    private String getFormatedDate() {
        return date.format(Main.DATE_FORMATTER);
    }
}
