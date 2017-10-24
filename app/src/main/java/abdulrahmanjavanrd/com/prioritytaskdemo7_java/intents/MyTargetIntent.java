package abdulrahmanjavanrd.com.prioritytaskdemo7_java.intents;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;

/**
 * Created by nfs05 on 23/10/2017.
 */

public class MyTargetIntent extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.list_all_items_recycyler);
    }

}
