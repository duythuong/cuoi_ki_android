package com.example.duynguyen.new_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.duynguyen.new_app.adapter.adapter_foods_drink;
import com.example.duynguyen.new_app.doi_tuong.doi_tuong_foods_drink;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search_foods extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mFirebaseDatabase;
    private static final String TAG = "FIREBASE";
    private ArrayList<doi_tuong_foods_drink> doituongs1 = new ArrayList<doi_tuong_foods_drink>();
    private doi_tuong_foods_drink value;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.databasetable);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        String str = intent.getStringExtra("id_search");
        firebase(str);
    }

    private void firebase(final String str) {
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference().child("foods");
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value  = dataSnapshot.child(str).getValue(doi_tuong_foods_drink.class);
                doituongs1.add(value);
                System.out.println("size "+doituongs1.size());
                recyclerview();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void recyclerview(){
        recyclerView = findViewById(R.id.data);
        adapter_foods_drink custom_list = new adapter_foods_drink(doituongs1, Search_foods.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Search_foods.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(custom_list);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
