package com.tutorial.ScientToolsApp;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class ToolsListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Functions functions;
    private EditText editText;
    private ToolsRecyclerViewAdapter toolsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        functions= new Functions(this);

        RecyclerView recyclerView= findViewById(R.id.atl_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolsRecyclerViewAdapter= functions.ReturnAllTools();
        recyclerView.setAdapter(toolsRecyclerViewAdapter);
        editText= findViewById(R.id.editTextSearchTools);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,int i,int i1,int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence,int i,int i1,int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //new array list that will hold the filtered data
                ArrayList<ToolsListN> filterdProfiles = new ArrayList<>();
                List<ToolsListN> list= toolsRecyclerViewAdapter.getList();
                //looping through existing elements
                if (list!= null){
                    for (ToolsListN s : list) {
                        //if the existing elements contains the search input
                        if (s.getname().toLowerCase().contains(editable.toString().toLowerCase())||s.getUid().toString().toLowerCase().contains(editable.toString().toLowerCase())) {
                            //adding the element to filtered list
                            filterdProfiles.add(s);
                        }
                    }
                    toolsRecyclerViewAdapter.setData(filterdProfiles);
                }
            }
        });
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
            Intent intent = new Intent(ToolsListActivity.this,ToolsRegistration.class);
            startActivity(intent);
        } else if( id == R.id.userprofiles ) {
            Intent intent = new Intent(ToolsListActivity.this,UserProfiles.class);
            startActivity(intent);}
        if( id == R.id.tools) {
            Intent intent = new Intent(ToolsListActivity.this,ToolsDisplay.class);
            startActivity(intent);
        } else if( id == R.id.contacts ) {
            Intent intent = new Intent(ToolsListActivity.this,ContactUsActivity.class);
            startActivity(intent);}

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
