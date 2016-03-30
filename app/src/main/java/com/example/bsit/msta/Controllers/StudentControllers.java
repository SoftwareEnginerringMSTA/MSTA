package com.example.bsit.msta.Controllers;

import com.example.bsit.msta.Entities.Students;
import com.example.bsit.msta.R;

import java.util.ArrayList;
import java.util.List;

public class StudentControllers {

    private List<Students> mStudents;

    public StudentControllers() {
        // create all the movies here
        mStudents = new ArrayList<>();
        mStudents.add(new Students("Frederick Prescious Alago", "BSIT - 3 ", "Requesting advising schedule.", R.drawable.prescious));
        mStudents.add(new Students("Kris Emmanuel Cerio", "BSCS - 3", "Request Accepted Advising at March 21 2015 2:30 pm", R.drawable.kris));
        mStudents.add(new Students("Jethro Esplanada", "BSIS - 4", "None", R.drawable.jeth));
        mStudents.add(new Students("Chadd Bailey Repunte", "BSCS - 2", "Requesting advising schedule.",R.drawable.chadd));
        mStudents.add(new Students("Giovanni Agravante", "ACT - 1", "None",R.drawable.gio));
        mStudents.add(new Students("Earvin Jay Bermudo", "ACT - 2 ", "Request Accepted Advising at March 25 2015 4:30 pm",R.drawable.earv));
        mStudents.add(new Students("James Brian Jadol", "BSIS - 4", "Requesting advising schedule.",R.drawable.jadol));
        mStudents.add(new Students("Louie Jay Timagos", "BSIT - 4", "Requesting advising schedule.",R.drawable.louie));
        mStudents.add(new Students("Bruce Wayne", "BSIT - 3", "None",R.drawable.bruce));
    }

    public List<Students> getStudents() {
        return mStudents;
    }
}
