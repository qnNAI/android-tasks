package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "taxi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Second activity onCreate called.");
        setContentView(R.layout.activity_second);
        Button pathBtn = findViewById(R.id.pathBtn);
        Button taxiBtn = findViewById(R.id.taxiBtn);
        pathBtn.setOnClickListener(this);
        taxiBtn.setOnClickListener(this);
        taxiBtn.setEnabled(false);
        Intent intent = getIntent();
        TextView nameTxt = findViewById(R.id.nameText);
        TextView phoneTxt = findViewById(R.id.phoneText);
        nameTxt.setText(intent.getStringExtra("name") + " " + intent.getStringExtra("surname"));
        phoneTxt.setText(intent.getStringExtra("phone"));
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "Second activity onClick called.");
        switch (view.getId()) {
            case R.id.pathBtn:
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.taxiBtn:
                Toast.makeText(getApplicationContext(), "Wait for Taxi. Good luck!", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "Second activity onActivityResult called.");
        if (data == null) {
            return;
        }
        TextView view = findViewById(R.id.pathInfoText);
        StringBuilder buffer = new StringBuilder();
        String streetFrom = data.getStringExtra("streetFrom");
        String houseFrom = data.getStringExtra("houseFrom");
        String flatFrom = data.getStringExtra("flatFrom");
        String streetTo = data.getStringExtra("streetTo");
        String houseTo = data.getStringExtra("houseTo");
        String flatTo = data.getStringExtra("flatTo");

        if (!streetFrom.isEmpty() && !houseFrom.isEmpty() && !flatFrom.isEmpty() && !streetTo.isEmpty()
        && !houseTo.isEmpty() && !flatTo.isEmpty()) {
            buffer.append("Taxi will arrive at ").append(streetFrom)
                    .append(", ").append(houseFrom).append(", ")
                    .append(flatFrom).append(" in 5 minutes and take you in ")
                    .append(streetTo).append(", ")
                    .append(houseTo).append(", ")
                    .append(flatTo).append(". If you are agree click Call Taxi");
            view.setText(buffer.toString());
            Button btnCallTaxi = findViewById(R.id.taxiBtn);
            btnCallTaxi.setEnabled(true);
        } else {
            view.setText("Fail to process address!");
        }
    }
}
