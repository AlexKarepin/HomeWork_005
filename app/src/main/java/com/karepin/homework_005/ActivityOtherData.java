package com.karepin.homework_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityOtherData extends AppCompatActivity {
    private static final String TAG = "MyLog";
    private ArrayList<Other> list = new ArrayList<>();
    private EditText myWeight;
    private EditText mySteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        saveOther();
        myWeight = findViewById(R.id.fieldWeight);
        mySteps = findViewById(R.id.fieldNumberOfSteps);
    }

    private void saveOther() {
        Button buttonSaveOther = findViewById(R.id.buttonSaveOther);
        buttonSaveOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // объявляем Intent для перехода после сохранения на главное активити
                Intent intent = new Intent(ActivityOtherData.this, MainActivity.class);
                // добавляем проверку на пустые строки
                String newWeight = myWeight.getText().toString();
                String newSteps = mySteps.getText().toString();
                if (newWeight.isEmpty() || newSteps.isEmpty()) {
                    Toast.makeText(ActivityOtherData.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    return;
                }
                // создаем экземпляр класса и добавляем в список
                Other other = new Other(Double.parseDouble(newWeight), Integer.parseInt(newSteps));
                list.add(other);
                // выводим сохраненные объекты
                StringBuilder sb = new StringBuilder();
                for (Other a : list) {
                    sb.append(a);
                }
                Toast.makeText(ActivityOtherData.this, sb.toString(), Toast.LENGTH_LONG).show();
                // переходим на главную активити
                startActivity(intent);
            }
        });
    }
}


