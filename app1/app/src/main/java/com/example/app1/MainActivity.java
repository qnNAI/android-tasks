package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PHONE = "phone";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String TAG = "taxi";
    EditText phoneField;
    EditText nameField;
    EditText surnameField;
    String phoneStr;
    String nameStr;
    String surnameStr;
    boolean isExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Main activity onCreate called.");
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        phoneField = findViewById(R.id.phoneInput);
        nameField = findViewById(R.id.nameInput);
        surnameField = findViewById(R.id.surnameInput);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        phoneStr = preferences.getString(PHONE, "");
        nameStr = preferences.getString(NAME, "");
        surnameStr = preferences.getString(SURNAME, "");
        if (!phoneStr.isEmpty() && !nameStr.isEmpty() && !surnameStr.isEmpty()) {
            phoneField.setText(phoneStr);
            nameField.setText(nameStr);
            surnameField.setText(surnameStr);
            button.setText("LOG IN");
            isExists = true;
        }
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "Main activity onClick called.");
        Intent intent = new Intent(this, SecondActivity.class);
        if (!isExists) {
            phoneStr = phoneField.getText().toString();
            nameStr = nameField.getText().toString();
            surnameStr = surnameField.getText().toString();
            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(PHONE, phoneStr);
            editor.putString(NAME, nameStr);
            editor.putString(SURNAME, surnameStr);
            editor.apply();
        }
        intent.putExtra(PHONE, phoneStr);
        intent.putExtra(NAME, nameStr);
        intent.putExtra(SURNAME, surnameStr);
        startActivity(intent);
    }
}