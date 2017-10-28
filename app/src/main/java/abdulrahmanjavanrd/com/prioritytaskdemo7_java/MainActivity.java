package abdulrahmanjavanrd.com.prioritytaskdemo7_java;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments.FragA;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments.FragB;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.intents.MaterialTarget;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    // Fragment manager ..
    private FragmentManager manager ;
    private FragmentTransaction transaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //toolbar
        Toolbar toolbar =findViewById(R.id.toolbar_layout);
        toolbar.setTitle(R.string.title_main_page);
        toolbar.setSubtitle(R.string.sub_title_main_page);
        setSupportActionBar(toolbar);
        // Drawer layout
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
          this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView ..
        NavigationView navigation = findViewById(R.id.nav_layout);
        navigation.setNavigationItemSelectedListener(this);

        // call fragments ..
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        fragmentA();
        fragmentB();

        getWhichItemAdd();
    }



   // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.setting_btn){
            Toast.makeText(this,"setting" , Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.sync_process:
                Toast.makeText(this,"sync_pro",Toast.LENGTH_LONG).show();
                break;
            case R.id.done_process:
                Toast.makeText(this,"sync_pro",Toast.LENGTH_LONG).show();
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true ;
    }

    // fragment 1 ..
    public void fragmentA(){
        FragA fragA = new FragA();
        transaction.add(R.id.frag_one_position,fragA,"fragA").commit();
    }
// Fragment B ..
    public void fragmentB(){
        FragB fragB = new FragB();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.frag_two_position,fragB,"fragB").commit();
    }
// Fragment C ..
    public void fragmentC(){

    }
    public void showAllMaterial(View view){
        // Now create new Intent to contain list material and adapter for recycler .
        Intent mIntent = new Intent(this,MaterialTarget.class);
        startActivity(mIntent);
    }

    public void getWhichItemAdd(){
        Intent mIntent = getIntent();
String str = mIntent.getStringExtra("k");
        Toast.makeText(this," okay you doing well , : " + str , Toast.LENGTH_LONG).show();
    }
}
