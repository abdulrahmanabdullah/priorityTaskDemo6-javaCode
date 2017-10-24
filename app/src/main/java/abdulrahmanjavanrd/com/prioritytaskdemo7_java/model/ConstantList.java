package abdulrahmanjavanrd.com.prioritytaskdemo7_java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class ConstantList {

// global list ...
    public static ArrayList<String> globalList = new ArrayList<>();

    public ArrayList<String> getGlobalList(){
        globalList.add("java");
        globalList.add("jvm");
        globalList.add("vue.js");
        globalList.add("FireBase");
        globalList.add("java 9 ");
        globalList.add("java module");
        globalList.add("Android");
        return globalList;
    }
    // static arrayList func ..
    public static List<String> mList(String str){
        List<String> mList = new ArrayList<>();
        mList.add("Java");
        mList.add("android");
        mList.add("FireBase");
        mList.add("kotlin");
        mList.add("javaNetwork");
        globalList.add(str);
        return globalList ;
    }
}
