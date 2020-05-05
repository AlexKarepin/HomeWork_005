package com.karepin.homework_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Person> list = new ArrayList<>();
    private EditText myName;
    private EditText myAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveName();
        setPressure();
        setOtherData();
        myName = findViewById(R.id.fieldForName);
        myAge = findViewById(R.id.fieldForAge);
    }

    private void saveName() {
        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // добавляем проверку на пустые строки
                String newName = myName.getText().toString();
                String newAge = myAge.getText().toString();
                if (newName.isEmpty() || newAge.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    return;
                }
                // преобразовываем строку с возрастом в int
                int age;
                try {
                    age = Integer.parseInt(newAge);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Возраст некорректный", Toast.LENGTH_LONG).show();
                    return;
                }
                // создаем экземпляр класса и добавляем в список
                    Person person = new Person(newName, Integer.parseInt(newAge));
                    list.add(person);
                // выводим сохраненные объекты
                    StringBuilder sb = new StringBuilder();
                    for (Person a : list) {
                        sb.append(a);
                    }
                    Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
                }
        });
    }

    private void setPressure() {
        Button buttonSetPressure = findViewById(R.id.buttonPressure);
        buttonSetPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ActivityPressure.class);
                startActivity(in);
            }
        });
    }

    private void setOtherData() {
        Button buttonSetOther = findViewById(R.id.buttonOther);
        buttonSetOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityOtherData.class);
                startActivity(intent);

            }
        });
    }
}