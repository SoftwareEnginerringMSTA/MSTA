package com.example.bsit.msta.MainInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsit.msta.Controllers.StudentControllers;
import com.example.bsit.msta.Entities.Students;
import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/29/2016.
 */
public class StudentDetails extends AppCompatActivity{
    public static final String EXTRA_POSITION = "key_position";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Intent intent = getIntent();
        if (intent == null) {
            throw new RuntimeException("MovieDetailsActivity is expecting an int extra passed by Intent");
        }

        // checks if a movie is present
        int position = intent.getIntExtra(EXTRA_POSITION, -1);
        if (position == -1) {
            throw new IllegalArgumentException("position passed is invalid.");
        }

        StudentControllers controller = new StudentControllers();
        Students students = controller.getStudents().get(position);

        if (students == null) {
            throw new NullPointerException("No movie found at the passed position.");
        }

        // find all views
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(students.getName());
        }

        ImageView imgStudents = (ImageView) findViewById(R.id.imgStudents);
        TextView tvGenre = (TextView) findViewById(R.id.tvStudentName);
        TextView tvRequest = (TextView) findViewById(R.id.tvRequest);

        imgStudents.setImageResource(students.getmImageId());
        tvGenre.setText(students.getName());
        tvRequest.setText(students.getPassword());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
