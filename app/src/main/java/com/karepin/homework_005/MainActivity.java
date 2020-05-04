package com.karepin.homework_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonSave;
    Button buttonSetPressure;
    Button buttonSetOther;
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
        buttonSave = findViewById(R.id.button);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = myName.getText().toString();
                try {
                    Integer.parseInt(newName);
                    Toast.makeText(MainActivity.this, "Введите имя! ", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                }
                String newAge = myAge.getText().toString();
                if (newName.isEmpty() || newAge.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                } else {
                    Person person = new Person(newName, Integer.parseInt(newAge));
                    list.add(person);
                    StringBuilder sb = new StringBuilder();
                    for (Person a : list) {
                        sb.append(a);
                    }
                    Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setPressure() {
        buttonSetPressure = findViewById(R.id.buttonPressure);
        buttonSetPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        });
    }

    private void setOtherData() {
        buttonSetOther = findViewById(R.id.buttonOther);
        buttonSetOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);

            }
        });
    }
}