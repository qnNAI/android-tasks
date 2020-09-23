package com.example.app2test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import reader.FileReader;
import reader.Reader;
import writer.FileWriter;
import writer.Writer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<String> lines;
    private List<String> answers;
    private int size;
    private int current;
    TextView question;
    RadioButton btn1;
    RadioButton btn2;
    RadioButton btn3;
    RadioButton btn4;
    Button submit;
    RadioGroup radioGroup;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        Reader fileReader = new FileReader();
        Writer writer = new FileWriter();
        try {
            writer.write(this);
            lines = fileReader.read(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        size = lines.size();
        current = 0;
        if (size % 6 != 0 || size < 6) {
            return;
        }
        setViewText();
        submit = findViewById(R.id.btnSubmit);
        submit.setText("Подтвердить");
        submit.setOnClickListener(this);
        answers = new ArrayList<>(size / 6);
    }


    @Override
    public void onClick(View view) {
        int btnId = radioGroup.getCheckedRadioButtonId();
        switch (btnId) {
            case R.id.rbtn1:
                answers.add((current / 6 + 1) + (lines.get(current + 5).equals("1") ? " +" : " -"));
                break;
            case R.id.rbtn2:
                answers.add((current / 6 + 1) + (lines.get(current + 5).equals("2") ? " +" : " -"));
                break;
            case R.id.rbtn3:
                answers.add((current / 6 + 1) + (lines.get(current + 5).equals("3") ? " +" : " -"));
                break;
            case R.id.rbtn4:
                answers.add((current / 6 + 1) + (lines.get(current + 5).equals("4") ? " +" : " -"));
                break;
        }
        current += 6;
        if (current < size) {
            if (current == size - 6) {
                submit.setText("Завершить тест");
            }
            setViewText();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("answers", (Serializable) answers);
            startActivity(intent);
        }
    }

    private void setViewText() {
        question = findViewById(R.id.question);
        question.setText(lines.get(current));

        btn1 = findViewById(R.id.rbtn1);
        btn1.setText(lines.get(current + 1));
        btn1.setChecked(true);
        btn2 = findViewById(R.id.rbtn2);
        btn2.setText(lines.get(current + 2));
        btn3 = findViewById(R.id.rbtn3);
        btn3.setText(lines.get(current + 3));
        btn4 = findViewById(R.id.rbtn4);
        btn4.setText(lines.get(current + 4));
    }
}