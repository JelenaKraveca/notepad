package lv.ctco.notepad;

/**
 * Created by yelena.kraveca on 11/23/2018.
 */
public class Record {
    private static  int counter = 0;
    private int id;

    public Record(){
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

}
