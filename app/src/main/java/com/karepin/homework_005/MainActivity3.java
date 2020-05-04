package com.karepin.homework_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    Button button;
    private static final String TAG = "MyLog";
    ArrayList<Other> list = new ArrayList<>();
    private EditText myWeight;
    private EditText mySteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        saveOther();
        myWeight = findViewById(R.id.editText8);
        mySteps = findViewById(R.id.editText9);
    }

    private void saveOther() {
        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                String newWeight = myWeight.getText().toString();
                String newSteps = mySteps.getText().toString();
                while (true) {
                    if (newWeight.isEmpty() || newSteps.isEmpty()) {
                        Toast.makeText(MainActivity3.this, "Ошибка, введите данные", Toast.LENGTH_LONG).show();
                    } else {
                        Other other = new Other(Double.parseDouble(newWeight), Integer.parseInt(newSteps));
                        list.add(other);
                        StringBuilder sb = new StringBuilder();
                        for (Other a : list) {
                            sb.append(a);
                        }
                        Toast.makeText(MainActivity3.this, sb.toString(), Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    break;
                }
            }
        });
    }
}


