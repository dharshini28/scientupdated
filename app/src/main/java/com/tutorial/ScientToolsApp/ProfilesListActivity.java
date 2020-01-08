package com.tutorial.ScientToolsApp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;


public class ProfilesListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Functions functions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager= findViewById(R.id.am_pager);
        TabLayout tabLayout= findViewById(R.id.am_pager_strip);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        functions= new Functions(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private class PagerAdapter extends FragmentPagerAdapter {
        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return new IndividualProfileFragment(functions.ReturnAllIndividualProfile());
                case 1: return new ClubProfileFragment(functions.ReturnAllClubProfile());

                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Individuals";
                case 1: return "Clubs";

                default:return null;
            }
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if( id == R.id.register) {
            Intent intent = new Intent(ProfilesListActivity.this,ToolsRegistration.class);
            startActivity(intent);
        } else if( id == R.id.userprofiles ) {
            Intent intent = new Intent(ProfilesListActivity.this,ProfilesListActivity.class);
            startActivity(intent);}
        if( id == R.id.tools) {
            Intent intent = new Intent(ProfilesListActivity.this,ToolsListActivity.class);
            startActivity(intent);
        } else if( id == R.id.contacts ) {
            Intent intent = new Intent(ProfilesListActivity.this,ContactUsActivity.class);
            startActivity(intent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
