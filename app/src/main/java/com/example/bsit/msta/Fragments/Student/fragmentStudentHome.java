package com.example.bsit.msta.Fragments.Student;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/9/2016.
 */
public class fragmentStudentHome extends Fragment implements  View.OnClickListener {

    Button mRequest;

    public fragmentStudentHome() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //to Inflate fragment
        RelativeLayout inflates = (RelativeLayout) inflater.inflate(R.layout.fragment_student_home, container, false);
        mRequest = (Button) inflates.findViewById(R.id.btnRequest);
        mRequest.setOnClickListener(this);
        return inflates;

    }


    protected void sendEmail() {

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));

        String[] to = {"frederickalago@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL, to);
        i.putExtra(Intent.EXTRA_SUBJECT, "Request for Advisorship");
        i.putExtra(Intent.EXTRA_TEXT, "Frederick Prescious Alago is requesting advising schedule.");
        i.setType("message/rfc822");

        Intent chooser = Intent.createChooser(i, "Choose Application to Send");
        startActivity(chooser);


        Toast.makeText(getContext(), "You have requested advising schedule", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }




}
