package com.example.bsit.msta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsit.msta.Entities.Students;
import com.example.bsit.msta.R;

import java.util.List;

/**
 * Created by BSIT on 3/29/2016.
 */
public class StudentAdapter extends ArrayAdapter<Students>{

    private Context mContext;
    private int         mLayoutId;
    private List<Students> mStudents;

    public StudentAdapter(Context context, int resource, List<Students> students) {
        super(context, resource, students);

        mContext = context;
        mLayoutId = resource;
        mStudents = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.imgStudents = (ImageView) convertView.findViewById(R.id.imgStudents);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvGenre = (TextView) convertView.findViewById(R.id.tvCourse);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Students students = mStudents.get(position);

        if (students != null) {
            if (viewHolder.imgStudents != null) {
                viewHolder.imgStudents.setImageResource(students.getmImageId());
            }
            if (viewHolder.tvName != null) {
                viewHolder.tvName.setText(students.getName());
            }
            if (viewHolder.tvGenre != null) {
                viewHolder.tvGenre.setText(students.getCourse());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        public ImageView imgStudents;
        public TextView  tvName;
        public TextView  tvGenre;
    }


}
