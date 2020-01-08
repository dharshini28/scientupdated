package com.tutorial.ScientToolsApp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private TextView namey;
    private TextView departmenty;
    private TextView rollnoy;
    private TextView tooly;
    private DatabaseReference mDatabase;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        namey = (TextView) findViewById(R.id.tv1);
        departmenty = (TextView) findViewById(R.id.tv2);
        rollnoy = (TextView) findViewById(R.id.tv3);
        tooly = (TextView) findViewById(R.id.tv4);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
            mDatabase = FirebaseDatabase.getInstance().getReference(username);

            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String department = dataSnapshot.child("department").getValue().toString();
                    String rollno = dataSnapshot.child("rollno").getValue().toString();
                    String tool = dataSnapshot.child("tool").getValue().toString();

                        namey.setText(name);
                        departmenty.setText(department);
                        rollnoy.setText(rollno);
                        tooly.setText(tool);
                    }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
    }


