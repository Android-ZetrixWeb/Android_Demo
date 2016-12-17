package com.example.hp.drower;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        //ActionBar actionBar = getSupportActionBar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_item_attachment:
                        fragment = HomeFragment.newInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.am_flContainer,fragment).commit();
                        break;
                    case R.id.navigation_item_images:
                        fragment = ImageFragment.newInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.am_flContainer,fragment).commit();
                        break;
                    case R.id.navigation_item_location:
                        fragment = Location.newInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.am_flContainer,fragment).commit();
                        break;

                }
                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                return true;
            }

        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        //actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon);

        fragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.am_flContainer,fragment).commit();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
             }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void callSignup()
    {
        if (fragment instanceof HomeFragment)
            ((HomeFragment)fragment).viewPager.setCurrentItem(1);
    }
    public void calllogin()
    {
        if (fragment instanceof HomeFragment)
            ((HomeFragment)fragment).viewPager.setCurrentItem(2);
    }
    public void afterlogin()
    {
        if (fragment instanceof HomeFragment)
            ((HomeFragment)fragment).viewPager.setCurrentItem(0);
    }

}
