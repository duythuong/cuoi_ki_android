package com.example.duynguyen.new_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duynguyen.new_app.doi_tuong.doi_tuong_foods_drink;
import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {
    private static final String TAG = "FIREBASE";
    Intent intent;
    String str_id,str_img,str_name,str_title;
    doi_tuong_foods_drink value;
    CollapsingToolbarLayout myCollapsingToolbar;
    TextView textView;
    ActionBar actionBar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent = getIntent();
        str_id = intent.getStringExtra("id");
        str_img = intent.getStringExtra("img");
        str_name = intent.getStringExtra("name");
        str_title = intent.getStringExtra("title");
        tootle(str_name);

        System.out.println(str_img);
        textView = findViewById(R.id.text_title);
//        textView.setText(str_title);

        imageView = (ImageView)findViewById(R.id.header);
        Picasso.get().load(str_img).error(R.drawable.img1).into(imageView);


    }
    private void tootle(String str_name){
        actionBar = getSupportActionBar();
        actionBar.setTitle(str_name);
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
