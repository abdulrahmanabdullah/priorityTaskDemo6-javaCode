package abdulrahmanjavanrd.com.prioritytaskdemo7_java.SpinnerClass;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by nfs05 on 21/10/2017.
 */

public class CustomSelectSpinner1 implements OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(adapterView.getContext()," you select : "+ adapterView.getItemAtPosition(i),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
