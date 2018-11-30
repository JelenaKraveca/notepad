package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by yelena.kraveca on 11/30/2018.
 */
public class Alarm extends StikyNote {
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void askData() {
        super.askData();
        time = Main.askTime("Time");
    }


    @Override
    public boolean contains(String str) {
        return super.contains(str)|| getFormatedTime().contains(str);

    }

    public String getFormatedTime() {
        return time.format(Main.TIME_FORMATTER);
    }

    @Override
    public String toString() {
        return "Alarm{" +
                " id=" + getId() +
                ", text='" + getText() + '\'' +
                " time=" + getFormatedTime() +
                '}';
    }
}


