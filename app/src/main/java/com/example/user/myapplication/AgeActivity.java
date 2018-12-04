package com.example.user.myapplication;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int [] numbers = {19,20,21,22,23};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView =findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AgeAdapter ageadapter = new AgeAdapter();
        recyclerView.setAdapter(ageadapter);


        }

    public void next(View view) {
        int age = Integer.parseInt(((EditText) findViewById(R.id.ed_age)).getText().toString());
      //  getSharedPreferences("user", MODE_PRIVATE)
     //           .edit()
       //         .putInt("AGE", age)
         //       .apply();
        user.setAge(age);
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeHolder>{
        @NonNull
        @Override
        public AgeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new AgeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHolder holder, int position) {
        holder.ageText.setText(numbers[position]+"");
        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }
    }
    class AgeHolder extends RecyclerView.ViewHolder {
        TextView ageText;
        public AgeHolder(View itemView) {
            super(itemView);
           ageText = itemView.findViewById(R.id.tv_age);
        }
    }
}