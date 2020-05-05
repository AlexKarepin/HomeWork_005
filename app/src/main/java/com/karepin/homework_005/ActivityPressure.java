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

public class ActivityPressure extends AppCompatActivity {
    private ArrayList<Pressure> list = new ArrayList<>();
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
        myPressureUp = findViewById(R.id.fieldPressureUp);
        myPressureDown = findViewById(R.id.fieldPressureDown);
        myPulse = findViewById(R.id.fieldPulse);
        myTachycar = findViewById(R.id.fieldTahicardia);
        myDate = findViewById(R.id.fieldCalendar);

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
        Button buttonSavePressure = findViewById(R.id.buttonSavePressure);
        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // объявляем Intent для перехода после сохранения на главное активити
                Intent intent = new Intent(ActivityPressure.this, MainActivity.class);
                // добавляем проверку на пустые строки
                String newPressureUp = (String) myPressureUp.getText().toString();
                String newPressureDown = (String) myPressureDown.getText().toString();
                String newPulse = (String) myPulse.getText().toString();
                if (selectedDate == null) {
                    selectedDate = new Date(myDate.getDate());
                }
                if (newPressureUp.isEmpty() || newPressureDown.isEmpty() || newPulse.isEmpty()) {
                    Toast.makeText(ActivityPressure.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    return;
                }
                // создаем экземпляр класса и добавляем в список
                Pressure pressure = new Pressure(Integer.parseInt(newPressureUp), Integer.parseInt(newPressureDown), Integer.parseInt(newPulse), myTachycar.isChecked(), selectedDate);
                list.add(pressure);
                // выводим сохраненные объекты
                StringBuilder sb = new StringBuilder();
                for (Pressure a : list) {
                    sb.append(a);
                }
                Toast.makeText(ActivityPressure.this, sb.toString(), Toast.LENGTH_LONG).show();
                // переходим на главную активити
                startActivity(intent);
            }
        });
    }
}

