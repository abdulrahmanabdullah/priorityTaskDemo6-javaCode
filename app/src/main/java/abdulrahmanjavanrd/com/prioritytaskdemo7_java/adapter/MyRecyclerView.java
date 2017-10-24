package abdulrahmanjavanrd.com.prioritytaskdemo7_java.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.model.ConstantList;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyviewHolder> {
    // List
    private int numbersItems ;
private   ConstantList mData ;
    private ArrayList<String> currentList ;
private LayoutInflater mLayout ;

private  int staticList;
/************ Constructor *******************/
public MyRecyclerView(int totalItemInList){
    this.mData = new ConstantList();
    currentList = mData.getGlobalList();
    this.numbersItems = totalItemInList ;
    staticList = currentList.size();
}
    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext() ;
    LayoutInflater inflater = LayoutInflater.from(context);
    boolean shouldAttachToParentImmediately = false;

        View view =inflater.inflate(R.layout.layout_item_list,parent,shouldAttachToParentImmediately);

        // call inner class -> ViewHolder Class .
        MyviewHolder holder = new MyviewHolder(view);

        // return view with file layout and with context .
        return holder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        Log.d("recycler","onBind : " + position);
    holder.tv_items.setText(currentList.get(position));
    }

    @Override
    public int getItemCount() {
        return staticList;
    }

    /************ ViewHolder Class   *******************/
    // class view holder ...
    class MyviewHolder extends RecyclerView.ViewHolder{
        // declare TextView, that in layout_item_list file .
        TextView tv_items ;
       /**********Constructor **************/
        public MyviewHolder (View view){
            super(view);
            tv_items = view.findViewById(R.id.tv_itmes_list);
        }

        void bind(int p){

        }
    }
    /**********************End ViewHolder Class ******************************/

}
