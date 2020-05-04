package com.karepin.homework_005;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    ArrayList<Pressure> list = new ArrayList<>();
    private EditText myPressureUp;
    private EditText myPressureDown;
    private EditText myPulse;
    private Switch myTachycar;
    private CalendarView myDate;

    private Date selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saveData();
        myPressureUp = findViewById(R.id.editText3);
        myPressureDown = findViewById(R.id.editText4);
        myPulse = findViewById(R.id.editText5);
        myTachycar = findViewById(R.id.switch1);
        myDate = findViewById(R.id.calendarView);

        myDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.YEAR, year);
                calendar.set(calendar.MONTH, month);
                calendar.set(calendar.DAY_OF_MONTH, dayOfMonth);
                selectedDate = calendar.getTime();
            }
        });
    }

    private void saveData() {
        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                String newPressureUp = (String) myPressureUp.getText().toString();
                String newPressureDown = (String) myPressureDown.getText().toString();
                String newPulse = (String) myPulse.getText().toString();
                if (selectedDate == null) {
                    selectedDate = new Date(myDate.getDate());
                }
                while (true) {
                    if (newPressureUp.isEmpty() || newPressureDown.isEmpty() || newPulse.isEmpty()) {
                        Toast.makeText(MainActivity2.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    } else {
                        Pressure pr = new Pressure(Integer.parseInt(newPressureUp), Integer.parseInt(newPressureDown), Integer.parseInt(newPulse), myTachycar.isChecked(), selectedDate);
                        list.add(pr);
                        StringBuilder sb = new StringBuilder();
                        for (Pressure a : list) {
                            sb.append(a);
                            Toast.makeText(MainActivity2.this, sb.toString(), Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                    }
                    break;

                }
            }
        });
    }
}

