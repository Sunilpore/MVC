package keepnote.com.notekeep.data;

import java.util.List;

/**
 * This is a contract between Classes that dictate how they can talk to each other
 * without giving implementation details
 */

public interface DataSourceInterface {

    List <ListItem> getListOfData();
}
