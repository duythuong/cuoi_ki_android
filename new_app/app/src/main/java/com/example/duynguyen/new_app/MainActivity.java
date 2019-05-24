package com.example.duynguyen.new_app;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duynguyen.new_app.R;
import com.example.duynguyen.new_app.home;

public class MainActivity extends AppCompatActivity {
    private Button btn_next, btn_skip;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_next = (Button) findViewById(R.id.btn_got_it);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),home.class);
                startActivity(intent);
            }
        });

    }
}

