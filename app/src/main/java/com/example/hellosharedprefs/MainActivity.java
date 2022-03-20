package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnOran, btnPur, btnBrown, btnBlue, btnCount, btnReset, btnSave;
    int i = 0;
    String currentColor = "#FFFFFF";
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("helloSharePrefs", Context.MODE_PRIVATE);
        textView = findViewById(R.id.textView);
        btnCount = findViewById(R.id.btnCount);
        btnOran = findViewById(R.id.btnOran);
        btnPur = findViewById(R.id.btnPur);
        btnBlue = findViewById(R.id.btnBlue);
        btnBrown = findViewById(R.id.btnBrown);
        btnSave = findViewById(R.id.btnSave);
        btnReset = findViewById(R.id.btnReset);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                textView.setText(String.valueOf(i));
            }
        });
        btnOran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#FF5722"));
                currentColor = "#FF5722";
            }
        });

        btnPur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#9C27B0"));
                currentColor = "#9C27B0";
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#3F51B5"));
                currentColor = "#3F51B5";
            }
        });

        btnBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#6E2528"));
                currentColor = "#6E2528";
            }
        });

           i = mPreferences.getInt("count", 0);
           textView.setText(String.valueOf(i));
           currentColor = mPreferences.getString("color", currentColor);
           textView.setBackgroundColor(Color.parseColor(currentColor));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putInt("count", i);
                editor.putString("color", currentColor);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.remove("count");
                editor.remove("color");
                editor.apply();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

}