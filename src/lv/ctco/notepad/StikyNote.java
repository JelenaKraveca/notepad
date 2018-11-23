package lv.ctco.notepad;

/**
 * Created by yelena.kraveca on 11/23/2018.
 */
public class StikyNote extends Record {
    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StikyNote{" +
                "id=" + getId() +
                ", text='" + text + '\'' +
                '}';
    }
}
