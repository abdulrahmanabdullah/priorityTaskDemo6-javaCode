package abdulrahmanjavanrd.com.prioritytaskdemo7_java.intents;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.adapter.MyRecyclerView;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.model.ConstantList;

public class MaterialTarget extends AppCompatActivity {

    // set ToolBar properties .
    Toolbar materialToolbar ;
    // recycler view ...
    RecyclerView recycler ;
    MyRecyclerView myRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_target);
        materialToolbar = findViewById(R.id.material_toolbar);
        materialToolbar.setTitle(R.string.material_list);
        setSupportActionBar(materialToolbar);
        recycler = findViewById(R.id.re_list_frag_b);
        setUpRecycler();
    }

    private void setUpRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        myRecyclerView = new MyRecyclerView(ConstantList.getData());
        recycler.setAdapter(myRecyclerView);
    }
}
