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
    Button button;
    private ArrayList<Persen> list = new ArrayList<>();
    private EditText myName;
    private EditText myAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save();
        setPressure();
        other();
        myName = findViewById(R.id.editText);
        myAge = findViewById(R.id.editText2);
    }

    private void save() {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = myName.getText().toString();
                String newAge = myAge.getText().toString();
                while (true) {
                    if (newName.isEmpty() || newAge.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    } else {
                        Persen persen = new Persen(newName, newAge);
                        list.add(persen);
                        StringBuilder sb = new StringBuilder();
                        for (Persen a : list) {
                            sb.append(a);
                            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                }
            }
        });
    }

    private void setPressure() {
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        });
    }

    private void other() {
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);

            }
        });
    }
}