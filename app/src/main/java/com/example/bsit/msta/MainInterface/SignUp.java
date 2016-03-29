package com.example.bsit.msta.MainInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bsit.msta.Database.DatabaseHandler;
import com.example.bsit.msta.Entities.Students;
import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/9/2016.
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private Button mSign;
    private EditText mName;
    private EditText mPass;
    private EditText mId;
    private Spinner mAdvisor;
    private Spinner mCourse;
    private Spinner mYearLevel;

    private String name ="name";
    private String password="password";
    private String id="id";
    private String course="course";
    private String advisor="advisor";
    private String yearLevel="yearLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
        initAdapters();
        mName.addTextChangedListener(new MyTextWatcher(mName));
        mPass.addTextChangedListener(new MyTextWatcher(mPass));
        mId.addTextChangedListener(new MyTextWatcher(mId));

    }



    public void initAdapters(){

        ArrayAdapter adapterAdvisor, adapterCourse,adapterYearLevel;

        adapterAdvisor = ArrayAdapter.createFromResource(this, R.array.Teachers, android.R.layout.simple_spinner_item);
        adapterAdvisor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAdvisor.setAdapter(adapterAdvisor);

        adapterCourse = ArrayAdapter.createFromResource(this,R.array.Course,android.R.layout.simple_spinner_item);
        adapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourse.setAdapter(adapterCourse);

        adapterYearLevel = ArrayAdapter.createFromResource(this,R.array.YearLevel,android.R.layout.simple_spinner_item);
        adapterYearLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mYearLevel.setAdapter(adapterYearLevel);

        mAdvisor.setOnItemSelectedListener(this);
        mCourse.setOnItemSelectedListener(this);
        mYearLevel.setOnItemSelectedListener(this);


    }




    public void init(){
        mSign = (Button) findViewById(R.id.btn_signup);
        mName = (EditText) findViewById(R.id.edtInputName);
        mPass = (EditText) findViewById(R.id.edtInputPass);
        mId = (EditText) findViewById(R.id.edtInputStudentNumber);
        mAdvisor = (Spinner) findViewById(R.id.spnAdvisor);
        mCourse = (Spinner) findViewById(R.id.spnCourse);
        mYearLevel = (Spinner) findViewById(R.id.spnYearLevel);

    }

    @Override
    public void onClick(View v) {
        submitForm();
        }

    private void submitForm() {

        if (!validateStudentId()) {
            return;
        } else if (!validatePassword()) {
            return;
        } else if (!validateName()) {
            return;
        } else {
            name = mName.getText().toString();
            password = mPass.getText().toString();
            id = mId.getText().toString();
            advisor = mAdvisor.getSelectedItem().toString();
            course = mCourse.getSelectedItem().toString();
            yearLevel = mYearLevel.getSelectedItem().toString();

            DatabaseHandler db = new DatabaseHandler(this);
            try {
                db.addStudent(new Students(name, password, id, course, advisor, yearLevel));
            }catch (Exception ex){
                ex.printStackTrace();
            }

            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,StudentProfile.class);
            startActivity(intent);


        }

    }


    private boolean validateName() {
        if (mName.getText().toString().trim().isEmpty()) {
            mName.setError(getString(R.string.err_msg_name));
            requestFocus(mName);
            return false;
        } else {
            mName.setError(null);
        }

        return true;
    }

    private boolean validateStudentId() {
        if (mId.getText().toString().trim().isEmpty()) {
            mId.setError(getString(R.string.err_msg_student_id));
            requestFocus(mId);
            return false;
        } else {
            mId.setError(null);
        }

        return true;
    }

    private boolean validatePassword() {
        if (mPass.getText().toString().trim().isEmpty()) {
            mPass.setError(getString(R.string.err_msg_password));
            requestFocus(mPass);
            return false;
        } else {
            mPass.setError(null);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

            }

        }
    }
}
