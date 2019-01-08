package keepnote.com.notekeep;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import keepnote.com.notekeep.data.DataSourceInterface;
import keepnote.com.notekeep.data.ListItem;
import keepnote.com.notekeep.logic.Controller;
import keepnote.com.notekeep.view.ViewInterface;

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    /**
     *Test Double
     * Specifically a "Mock"
     */
    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem (
        "6:30AM 06/01/2017",
        "Check out content like Fragmented Podcast to expose yourself to the knowledge",
        R.color.RED
    );

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view,dataSource);
    }

    @Test
    public void onGetListDataSuccessful(){
        //Set up any data we need for the Test
        ArrayList<ListItem> listOfData = new ArrayList();
        listOfData.add(testItem);

        //Set up our Mocks to return the Data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        //Call the method (Unit) we are testing
        controller.getListFromDataSource();

        //Check how the Tested Class responds to the data it recieves
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterView(listOfData);

    }


    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateTime(),
                testItem.getMsg(),
                testItem.getColorRes()
                /*testViewRoot*/);
    }


    // @Test
    // public void onGetListDataUnsuccessful() {
    /**************************
     *
     * Unit Test Homework:
     *
     * Implement the "View", so that when we don't recieve a List, it shows some kind of
     * error message to the user. This is common practice that you should learn!
     *
     * I've written some hints you'll have to decipher into Java code:
     *************************/
    //1 Set up your Mock dataSource

    //2 Call the method you wish to test on the Controller

    //3 Verify that the View has been told to show a message (I'd suggest showing a Toast for now)

    //Profit???

    // }

}
