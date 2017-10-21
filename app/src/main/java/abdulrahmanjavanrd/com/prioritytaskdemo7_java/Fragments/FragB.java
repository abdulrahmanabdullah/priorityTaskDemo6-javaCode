package abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.Constant.ConstantList;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;

/**
 * Created by abdulrahman on 10/21/17.
 */

public class FragB extends Fragment{

    // Button for add new items in our list .
    Button btnAddItem ;

    // edit text ..
    EditText editText ;
    //onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_b_layout,container,false);
//        btnAddItem = view.findViewById(R.id.btn_add_new_material);
        editText = view.findViewById(R.id.et_add_material);
        return view ;
    }

    public void addNewItem(View view){
       String takeItem = editText.getText().toString();
   List<String> localList=ConstantList.mList(takeItem);
   // TODO: pass this list to listView or recycler view .

    }
}
