package com.example.bsit.msta.Fragments.Student;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bsit.msta.R;
import com.example.bsit.msta.decorators.EventDecorator;
import com.example.bsit.msta.decorators.HighlightWeekendsDecorator;
import com.example.bsit.msta.decorators.MySelectorDecorator;
import com.example.bsit.msta.decorators.OneDayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by BSIT on 3/9/2016.
 */
public class fragmentStudentCalendar extends Fragment implements OnDateSelectedListener{

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();

    @Bind(R.id.calendarView)
    MaterialCalendarView widget;

    @Bind(R.id.textView)
    TextView textView;


    public fragmentStudentCalendar() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //to Inflate fragment

        RelativeLayout inflates = (RelativeLayout) inflater.inflate(R.layout.fragment_student_calendar, container, false);
        ButterKnife.bind(container);


        textView = (TextView) inflates.findViewById(R.id.textView);
        widget = (MaterialCalendarView) inflates.findViewById(R.id.calendarView);
        widget.setOnDateChangedListener(this);
        textView.setText(getSelectedDatesString());
        widget.setOnDateChangedListener(this);
        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

        Calendar calendar = Calendar.getInstance();
        widget.setSelectedDate(calendar.getTime());

        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
        widget.setMinimumDate(calendar.getTime());

        calendar.set(calendar.get(Calendar.YEAR), Calendar.DECEMBER, 31);
        widget.setMaximumDate(calendar.getTime());

        widget.addDecorators(
                new MySelectorDecorator(getActivity()),
                new HighlightWeekendsDecorator(),
                oneDayDecorator
        );
        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());

        return inflates;

    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        textView.setText(getSelectedDatesString());

    }

//    @Override
//    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
//        mDelegate.getSupportActionBar().setTitle(FORMATTER.format(date.getDate()));
//    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "  ";
        }

        return FORMATTER.format(date.getDate());
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                CalendarDay day = CalendarDay.from(calendar);
                dates.add(day);
                calendar.add(Calendar.DATE, 5);
            }

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (getActivity().isFinishing()) {
                return;
            }

            widget.addDecorator(new EventDecorator(Color.RED, calendarDays));
        }
    }


}
