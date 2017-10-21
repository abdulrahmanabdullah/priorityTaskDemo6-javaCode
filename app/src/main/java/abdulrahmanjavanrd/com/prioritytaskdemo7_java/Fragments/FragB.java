package abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.adapter.MyRecyclerView;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.model.ConstantList;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class FragB extends Fragment{

    // create object of CostantList ;
    private  ConstantList mConstantList = new ConstantList();
    // Button for add new items in our list .
    Button btnAddItem ;

    // recycler view id
    RecyclerView mRecycler ;
    // edit text ..
    EditText editText ;
    //onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_b_layout,container,false);
        editText = view.findViewById(R.id.et_add_material);
        mRecycler = view.findViewById(R.id.re_list_frag_b);
        setUpRecycler();
        return view ;
    }

    public void addNewItem(View view){
       String takeItem = editText.getText().toString();
   List<String> localList=ConstantList.mList(takeItem);
   // TODO: pass this list to listView or recycler view .

    }

    public void setUpRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setHasFixedSize(true);
        ArrayList<String> list = mConstantList.getGlobalList();
        int totalItemInList = list.size();
        MyRecyclerView recyclerView = new MyRecyclerView(totalItemInList);
        mRecycler.setAdapter(recyclerView);
    }
}
