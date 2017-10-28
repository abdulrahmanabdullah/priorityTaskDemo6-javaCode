package abdulrahmanjavanrd.com.prioritytaskdemo7_java.intents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;

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

        // enable the up button
        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayHomeAsUpEnabled(true);
        setUpRecycler();
    }


    private void setUpRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        myRecyclerView = new MyRecyclerView(ConstantList.getData(),this);
        recycler.setAdapter(myRecyclerView);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.material_menu,menu);
        return true;
    }
}
