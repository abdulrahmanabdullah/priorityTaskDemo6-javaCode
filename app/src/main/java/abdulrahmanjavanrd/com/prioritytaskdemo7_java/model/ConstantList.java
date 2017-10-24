package abdulrahmanjavanrd.com.prioritytaskdemo7_java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class ConstantList {

    private String materil;
// global list ...
    public static ArrayList<String> globalList = new ArrayList<>();

    private void setMateril(String str){
        materil = str ;
    }

    public String getMateril(){
        return materil ;
    }

    public ArrayList<String> getGlobalList(){
        globalList.add("java");
        globalList.add("java 9 ");
        globalList.add("java 9 ");
        globalList.add("java 9 ");
        globalList.add("java 9 ");
        globalList.add("java module");
        globalList.add("Android");
        return globalList;
    }
    public static ArrayList<ConstantList> getData(){
        ArrayList<ConstantList> list = new ArrayList<>();
        String[] materils = allMaterial();
        for (int i =0 ; i < materils.length ;i++){
            ConstantList constantList = new ConstantList();
            constantList.setMateril(materils[i]);
            list.add(constantList);
        }

        return list ;
    }
    // create array to contain all target material ..
    private static String[] allMaterial(){
        String[] datas = {"java","kotlin","pattern design ","Android","jdk9","fireBase","uve.js","python"
        ,"javaNetwork","web developer"};

        return datas ;
    }
}
