package abdulrahmanjavanrd.com.prioritytaskdemo7_java.model;

import java.util.ArrayList;
import java.util.List;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class ConstantList {

    private String materil;
    private int imageID ;

    private void setMateril(String str){
        materil = str ;
    }

    private void setImageID(int id){
        this.imageID = id;
    }
    public int getImageID() {
        return imageID;
    }

    public String getMateril(){
        return materil ;
    }


    public static ArrayList<ConstantList> getData(){
        ArrayList<ConstantList> list = new ArrayList<>();
        String[] materils = allMaterial();
        int[] image;
        for (int i =0 ; i < materils.length ;i++){
            ConstantList constantList = new ConstantList();
            constantList.setMateril(materils[i]);
            if (materils[i].equalsIgnoreCase("java")){
                image = javaImage() ;
            }else
                image = getImages();
            constantList.setImageID(image[i]);
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

    private static int[] getImages(){
        int[] images ={
                /*
                * 0,2,4,6,8> java
                * 1,3,5,7 > kotlin
                *
                * */
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.kotlin02,
                R.drawable.python,
                R.drawable.js,
                R.drawable.firebase,
        };
        return images ;
    }

    private static int[] javaImage(){
       int[] javaImg={
               R.drawable.java_small,
       };
       return javaImg;
    }
}
