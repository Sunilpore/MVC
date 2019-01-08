package keepnote.com.notekeep.data;

public class ListItem {

    /*If we make variable final then we can't set it except for when it get initialize in a constructor
    private final String dateTime;*/


    private String dateTime;
    private String msg;
    private int colorRes;


    public ListItem(String dateTime, String msg, int colorRes) {
        this.dateTime = dateTime;
        this.msg = msg;
        this.colorRes = colorRes;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }
}
