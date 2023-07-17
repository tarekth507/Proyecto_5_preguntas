package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>aQuiz</font>"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icon);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
