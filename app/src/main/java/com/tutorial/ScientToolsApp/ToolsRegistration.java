package com.tutorial.ScientToolsApp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ToolsRegistration extends AppCompatActivity {

    private Button firebasebutton;
    private EditText txtname;
    private EditText txtdepartment;
    private EditText txtrollno;
    private EditText txttool;
    private DatabaseReference mDatabase;
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolsregistration);
        firebasebutton = (Button) findViewById(R.id.b1);
        txtname = (EditText) findViewById(R.id.et1);
        txtdepartment = (EditText) findViewById(R.id.et2);
        txtrollno = (EditText) findViewById(R.id.et3);
        txttool = (EditText) findViewById(R.id.et4);

        firebasebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                final String username = txtname.getText().toString();
                mDatabase = FirebaseDatabase.getInstance().getReference().child(username);
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("ShowToast")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String department =txtdepartment.getText().toString();
                        String rollno = txtrollno.getText().toString();
                        String tool = txttool.getText().toString();
                        com.tutorial.ScientToolsApp.username users=new username(username,department,rollno,tool);
                        mDatabase.setValue(users);
                        Toast.makeText(ToolsRegistration.this,"Data inserted....",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });
    }


}
