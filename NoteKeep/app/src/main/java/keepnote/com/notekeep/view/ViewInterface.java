package keepnote.com.notekeep.view;

import java.util.List;

import keepnote.com.notekeep.data.ListItem;

public interface ViewInterface {

    void startDetailActivity(String dateTime, String msg, int colorRes);

    void setUpAdapterView(List<ListItem> listofData);

}
