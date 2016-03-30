package com.example.bsit.msta.MainInterface;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bsit.msta.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  EditText mUser;
    private EditText mPass;
    private Button mLogin;
    private Button mSignup;

    public static final String KEY_MYPREFERENCES = "MyPrefs" ;
    public static final String KEY_ID = "id";
    public static final String KEY_PASS = "password";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        mUser = (EditText) findViewById(R.id.edtUser);
        mPass = (EditText) findViewById(R.id.edtPass);
        mLogin = (Button) findViewById(R.id.btnLogin);
        mSignup = (Button) findViewById(R.id.btnSignup);
        sharedpreferences = getSharedPreferences(KEY_MYPREFERENCES, Context.MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.btnLogin:
                String user = mUser.getText().toString();
                String pass = mPass.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(KEY_ID, user);
                editor.putString(KEY_PASS, pass);
                editor.apply();

                if(user.contentEquals("2013007248") && pass.contentEquals("12345")){
                    intent = new Intent(this, StudentProfile.class);
                startActivity(intent);
                }
                else if(user.contentEquals("12345") && pass.contentEquals("67890")){
                    intent = new Intent(this, TeacherProfile.class);
                    startActivity(intent);
                }
                else if(user.isEmpty()){
                    mUser.setError("Invalid Credentials");
                }
                else if(pass.isEmpty()){
                    mPass.setError("Invalid Credentials");
                }
                else if(!user.contentEquals("2013007248") && !pass.contentEquals("12345")){
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
                else if(!user.contentEquals("12345") && !pass.contentEquals("67890")){
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSignup:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);break;
        }
    }
}
