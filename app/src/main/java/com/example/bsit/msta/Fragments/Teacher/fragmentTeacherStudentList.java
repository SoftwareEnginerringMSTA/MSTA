package com.example.bsit.msta.Fragments.Teacher;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bsit.msta.Adapters.StudentAdapter;
import com.example.bsit.msta.Controllers.StudentControllers;
import com.example.bsit.msta.MainInterface.StudentDetails;
import com.example.bsit.msta.R;

/**
 * Created by BSIT on 3/10/2016.
 */
public class fragmentTeacherStudentList extends Fragment implements AdapterView.OnItemClickListener {


    private ListView mListView;
    private TextView mTvEmpty;
    private StudentControllers mController;

    public fragmentTeacherStudentList() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mController = new StudentControllers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //to Inflate fragment
        return inflater.inflate(R.layout.fragment_teacher_student_list,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);
        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // create a new instance of adapter
        StudentAdapter adapter = new StudentAdapter(getActivity(),
                R.layout.student_list_item, mController.getStudents());

        // set the adapter
        mListView.setAdapter(adapter);

        if (adapter.isEmpty()) {
            mTvEmpty.setVisibility(View.VISIBLE);
        } else {
            mTvEmpty.setVisibility(View.GONE);
        }

        // set item click listener
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), StudentDetails.class);
        intent.putExtra(StudentDetails.EXTRA_POSITION, position);
        startActivity(intent);
    }
}
