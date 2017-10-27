package abdulrahmanjavanrd.com.prioritytaskdemo7_java.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.model.ConstantList;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyviewHolder> {
private ArrayList<ConstantList> mList ;
/************ Constructor *******************/
public MyRecyclerView(ArrayList<ConstantList> list){
    mList = list;
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
    ConstantList currentList = mList.get(position);
    holder.bind(currentList,position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /************ ViewHolder Class   *******************/
    // class view holder ...
    class MyviewHolder extends RecyclerView.ViewHolder{
        // declare TextView, that in layout_item_list file .
        TextView tv_items ;
        ImageView imageView ;
        ConstantList currentList ;
        int position ;
       /**********Constructor **************/
        public MyviewHolder (View view){
            super(view);
            tv_items = view.findViewById(R.id.tv_itmes_list);
            imageView = view.findViewById(R.id.img_card);
        }

        void bind(ConstantList list , int p){
            tv_items.setText(list.getMateril());
            imageView.setImageResource(list.getImageID());
            this.currentList = list ;
            this.position = p ;
        }

    }
    /**********************End ViewHolder Class ******************************/

}
