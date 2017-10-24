package abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;

/**
 * Created by nfs05 on 23/10/2017.
 */

public class ListItemsFrag extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_all_items_recycyler,container,false);
        return view;
    }
}
