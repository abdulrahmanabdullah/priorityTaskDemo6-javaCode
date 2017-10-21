package abdulrahmanjavanrd.com.prioritytaskdemo7_java;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments.FragA;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments.FragB;

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
    }



   // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        transaction.add(R.id.frag_two_position,fragB,"fragB").commit();
    }
// Fragment C ..
    public void fragmentC(){

    }
}
