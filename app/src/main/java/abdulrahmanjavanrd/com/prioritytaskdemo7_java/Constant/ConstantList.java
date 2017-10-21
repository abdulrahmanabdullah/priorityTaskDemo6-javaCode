package abdulrahmanjavanrd.com.prioritytaskdemo7_java.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class ConstantList {


    // static arrayList func ..
    public static List<String> mList(String str){

        List<String> mList = new ArrayList<>();
       mList.add("Java");
        mList.add("android");
        mList.add("FireBase");
        mList.add("kotlin");
        mList.add("javaNetwork");
        mList.add(str);
        return mList ;
    }
}
