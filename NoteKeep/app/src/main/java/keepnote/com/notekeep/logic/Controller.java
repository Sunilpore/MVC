package keepnote.com.notekeep.logic;

import keepnote.com.notekeep.data.DataSourceInterface;
import keepnote.com.notekeep.data.ListItem;
import keepnote.com.notekeep.view.ViewInterface;

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    
    public void getListFromDataSource() {

        //It ask a data source for List of data and then give it to the view
        //call the method on that view
        view.setUpAdapterView(dataSource.getListOfData());
    }


    public void onListItemClick(ListItem testItem) {

        view.startDetailActivity(
                testItem.getDateTime(),
                testItem.getMsg(),
                testItem.getColorRes());
    }

}
