package keepnote.com.notekeep.utils;

import android.util.Log;

public class LogHelper {

    private static String SuccessTAG = "success_tag";
    private static String ErrorTAG = "error_tag";

    public static void successLog(String msg){
        Log.d(SuccessTAG,msg);
    }

    public static void errorLog(String msg){
        Log.d(ErrorTAG,msg);
    }


}
