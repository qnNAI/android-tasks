package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "taxi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Third activity onCreate called.");
        setContentView(R.layout.activity_third);
        Button btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "Third activity onClick called.");
        Intent intent = new Intent();
        EditText streetFrom = findViewById(R.id.streetFromInp);
        EditText houseFrom = findViewById(R.id.houseFromInp);
        EditText flatFrom = findViewById(R.id.flatFromInp);
        EditText streetTo = findViewById(R.id.streetToInp);
        EditText houseTo = findViewById(R.id.houseToInp);
        EditText flatTo = findViewById(R.id.flatToInp);
        intent.putExtra("streetFrom", streetFrom.getText().toString());
        intent.putExtra("houseFrom", houseFrom.getText().toString());
        intent.putExtra("flatFrom", flatFrom.getText().toString());
        intent.putExtra("streetTo", streetTo.getText().toString());
        intent.putExtra("houseTo", houseTo.getText().toString());
        intent.putExtra("flatTo", flatTo.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
