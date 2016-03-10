package com.example.bsit.msta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bsit.msta.UserInterface.SignUp;
import com.example.bsit.msta.UserInterface.TeacherProfile;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  EditText mUser;
    private EditText mPass;
    private Button mLogin;
    private Button mSignup;



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
    }


    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.btnLogin:
                intent = new Intent(this, TeacherProfile.class);
                startActivity(intent);break;
            case R.id.btnSignup:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);break;
        }


    }
}
