package abdulrahmanjavanrd.com.prioritytaskdemo7_java.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.MainActivity;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.intents.MaterialTarget;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.model.ConstantList;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyviewHolder> {
private ArrayList<ConstantList> mList ;
private Context context ;





/************ Constructor *******************/
public MyRecyclerView(ArrayList<ConstantList> list,Context ctx){
    mList = list;
    this.context = ctx ;
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
    holder.setListener();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void removeItem(int p){
    mList.remove(p);
    notifyItemRemoved(p);
    notifyItemRangeChanged(p,mList.size());
    }

    public void addItme(int p , ConstantList list){
        mList.add(p,list);
        notifyItemInserted(p);
        notifyItemRangeChanged(p,mList.size());
    }
    /************ ViewHolder Class   *******************/
    // class view holder ...
    class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // declare TextView, that in layout_item_list file .
        TextView tv_items ;
        ImageView imageView ;
        ImageView add_item ;
        ImageView del_item ;
        ConstantList currentList ;
        int position ;
       /**********Constructor **************/
        public MyviewHolder (View view){
            super(view);
            tv_items = view.findViewById(R.id.tv_itmes_list);
            imageView = view.findViewById(R.id.img_card);
            add_item = view.findViewById(R.id.img_add_item);
            del_item = view.findViewById(R.id.img_del_item);
        }

        void bind(ConstantList list , int p){
            tv_items.setText(list.getMateril());
            imageView.setImageResource(list.getImageID());
            this.currentList = list ;
            this.position = p ;
        }

        public void setListener(){
            add_item.setOnClickListener(MyviewHolder.this);
            del_item.setOnClickListener(MyviewHolder.this);
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_add_item :
                    String str = currentList.getMateril();
                    Intent mIntent = new Intent(context,MainActivity.class);
                    mIntent.putExtra("task",str);
                    context.startActivity(mIntent);
//                    addItme(position,currentList);
                    break;
                case  R.id.img_del_item:
                    removeItem(position);
                    break;
            }
        }
    }
    /**********************End ViewHolder Class ******************************/

}
