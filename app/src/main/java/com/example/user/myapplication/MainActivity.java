package com.example.user.myapplication;

import android.content.Intent;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends  BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent (this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        //ListView
        // listView();
            // RecyclerView
            RecyclerView recyclerView = findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter();
        }

        //data
        List<String> fruits = Arrays.asList("水蜜桃","葡萄","芒果");
        ArrayAdapter adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {

              //  String nickname = getSharedPreferences("user", MODE_PRIVATE)
              //          .getString("NICKNMAE", null);
                //int age = getSharedPreferences("user", MODE_PRIVATE)
                 //       .getInt("AGE", 0);
               // int gender = getSharedPreferences("user", MODE_PRIVATE)
               //         .getInt("Gender", 0);
              //  if (nickname == null || age == 0 || gender == 0) {
                if(!user.isValid()){
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }
            }
        }}
    }
