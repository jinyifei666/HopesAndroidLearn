package top.jinyifei.hopes.models;

/**
 * Created by acera on 2017/7/24.
 */

public class Contact {

    private String displayName;
    private String number;

    public Contact(){
        super();
    }

    public Contact(String displayName, String number) {
        super();
        this.displayName=displayName;
        this.number=number;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
