package com.tutorial.ScientToolsApp;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class
UserProfiles extends AppCompatActivity {
   ArrayList<username> list;
   DatabaseReference reference;
   RecyclerView recyclerView;
   SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofiles);

     reference = FirebaseDatabase.getInstance().getReference();
     recyclerView= findViewById(R.id.rv);
     searchView = findViewById(R.id.searchview);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(reference!=null){
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if( dataSnapshot.exists() ) {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(username.class));
                        }

                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(UserProfiles.this,databaseError.getMessage(),Toast.LENGTH_LONG);
                }
            });
        }
        if(searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return false;
                }
            });


        }
    }

    private void search(String str) {
        ArrayList<username> mylist = new ArrayList<>();
        for(username object : list){
            if(object.getName().toLowerCase().contains(str.toLowerCase())){
                mylist.add(object);
            }
        }
        AdapterClass adapterClass = new AdapterClass(mylist);
        recyclerView.setAdapter(adapterClass);
    }
}