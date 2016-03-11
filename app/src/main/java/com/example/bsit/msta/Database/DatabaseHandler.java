package com.example.bsit.msta.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bsit.msta.Entities.Students;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BSIT on 3/11/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentList";
    private static final String TABLE_STUDENTS = "students";

    private static final String KEY_STUDENT_ID ="student_id";
    private static final String KEY_PASSWORD="password";
    private static final String KEY_STUDENT_NAME="student_name";
    private static final String KEY_COURSE="course";
    private static final String KEY_YEAR_LEVEL="year_level";
    private static final String KEY_ADVISOR="advisor";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_STUDENT_ID + " INTEGER PRIMARY KEY,"+ KEY_STUDENT_NAME + " TEXT,"
                + KEY_COURSE + " TEXT,"+ KEY_YEAR_LEVEL + " TEXT,"+ KEY_PASSWORD + " TEXT," +
                 KEY_ADVISOR + " TEXT" + ")";
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_STUDENTS);
        onCreate(db);
    }

    // Adding new contact
    public void addStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_NAME, student.getName()); // Student Name
        values.put(KEY_STUDENT_ID, student.getId()); // Student ID
        values.put(KEY_PASSWORD,student.getPassword());// Student Password
        values.put(KEY_COURSE,student.getCourse());// Course
        values.put(KEY_YEAR_LEVEL,student.getYearLevel()); // Year Level
        values.put(KEY_ADVISOR,student.getAdvisor());// Advisor

        // Inserting Row
        db.insert(TABLE_STUDENTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single student
    public Students getStudents(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENTS, new String[] { KEY_STUDENT_ID,
                        KEY_STUDENT_NAME, KEY_COURSE,KEY_YEAR_LEVEL,KEY_ADVISOR }, KEY_STUDENT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Students student = new Students(cursor.getString(0),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5));
        // return contact
        return student;
    }

                // Getting All student
        public List<Students> getAllStudents() {
        List<Students> studentList = new ArrayList<Students>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Students student = new Students();
                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setCourse(cursor.getString(2));
                student.setYearLevel(cursor.getString(3));
                student.setAdvisor(cursor.getString(4));
                // Adding student to list
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        // return student list
        return studentList;
    }

    // Getting student Count
    public int getStudentCount() {
        String countQuery = "SELECT  * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single student
    public int updateStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_NAME, student.getName());
        values.put(KEY_COURSE, student.getCourse());
        values.put(KEY_YEAR_LEVEL,student.getYearLevel());
        values.put(KEY_ADVISOR,student.getAdvisor());

        // updating row
        return db.update(TABLE_STUDENTS, values, KEY_STUDENT_ID + " = ?",
                new String[] { String.valueOf(student.getId()) });
    }

    // Deleting single contact
    public void deleteStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS, KEY_STUDENT_ID + " = ?",
                new String[] { String.valueOf(student.getId()) });
        db.close();
    }


}
