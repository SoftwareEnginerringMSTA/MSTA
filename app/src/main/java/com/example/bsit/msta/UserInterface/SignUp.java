package com.example.bsit.msta.UserInterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/9/2016.
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private Button mSign;
    private EditText mName;
    private EditText mPass;
    private EditText mId;
    private EditText mYearLevel;
    private Spinner mAdvisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Teachers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAdvisor.setAdapter(adapter);

        mName.addTextChangedListener(new MyTextWatcher(mName));
        mPass.addTextChangedListener(new MyTextWatcher(mPass));
        mId.addTextChangedListener(new MyTextWatcher(mId));
        mYearLevel.addTextChangedListener(new MyTextWatcher(mYearLevel));

    }



    public void init(){
        mSign = (Button) findViewById(R.id.btn_signup);
        mName = (EditText) findViewById(R.id.edtInputName);
        mPass = (EditText) findViewById(R.id.edtInputPass);
        mId = (EditText) findViewById(R.id.edtInputStudentNumber);
        mYearLevel = (EditText) findViewById(R.id.edtYearLevel);
        mAdvisor = (Spinner) findViewById(R.id.spnAdvisor);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
            submitForm();break;
        }
    }

    private void submitForm() {
        if(!validateName()){
            return;
        }
        if(!validatePassword()){
            return;
        }
        if(!validateStudentId()){
            return;
        }
        if(!validateYearLevel()){
            return;
        }

        Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT);

    }



    private boolean validateName() {
        if (mName.getText().toString().trim().isEmpty()) {
            mName.setError(getString(R.string.err_msg_name));
            requestFocus(mName);
            return false;
        } else {
            mName.setError("false");
        }

        return true;
    }

    private boolean validateStudentId() {
        if (mId.getText().toString().trim().isEmpty()) {
            mId.setError(getString(R.string.err_msg_student_id));
            requestFocus(mId);
            return false;
        } else {
            mId.setError("false");
        }

        return true;
    }

    private boolean validatePassword() {
        if (mPass.getText().toString().trim().isEmpty()) {
            mPass.setError(getString(R.string.err_msg_password));
            requestFocus(mPass);
            return false;
        } else {
            mPass.setError("false");
        }

        return true;
    }


    private boolean validateYearLevel() {
        if (mYearLevel.getText().toString().trim().isEmpty()) {
            mYearLevel.setError(getString(R.string.err_msg_year_level));
            requestFocus(mYearLevel);
            return false;
        } else {
            mYearLevel.setError("false");
        }

        return true;
    }



    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    private class MyTextWatcher implements TextWatcher{

        private View view;

        public MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.edtInputName:
                    validateName();
                    break;
                case R.id.edtInputPass:
                    validatePassword();
                    break;
                case R.id.edtInputStudentNumber:
                    validateStudentId();
                    break;
                case R.id.edtYearLevel:
                    validateYearLevel();
                    break;
            }

        }
    }
}
