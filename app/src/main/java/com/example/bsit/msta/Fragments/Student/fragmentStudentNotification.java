package com.example.bsit.msta.Fragments.Student;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/9/2016.
 */
public class fragmentStudentNotification extends Fragment{
    public fragmentStudentNotification() {
        //Required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //to Inflate fragment
        return inflater.inflate(R.layout.fragment_student_notification,container,false);

    }


}
