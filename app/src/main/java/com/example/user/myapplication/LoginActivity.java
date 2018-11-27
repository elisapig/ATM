package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edUserid = findViewById(R.id.ed_userid);
        String userid =getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERID", "");
        edUserid.setText(userid);
    }
    public void login(View view){
        String userid = ((EditText)findViewById(R.id.ed_userid)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.ed_passwd)).getText().toString();
        if("Elisa".equals(userid)&&"1234".equals(passwd)) {
            getSharedPreferences("atm", MODE_PRIVATE)
                    .edit()
                    .putString("USERID", userid)
                    .apply();
            setResult(RESULT_OK);
            finish();
        }else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }

}
