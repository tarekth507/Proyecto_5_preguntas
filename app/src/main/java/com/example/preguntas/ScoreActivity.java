package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity {

    private Button restartButton;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        restartButton = findViewById(R.id.restartButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        int score = getIntent().getIntExtra("score", 0);
        scoreTextView.setText("Score: " + score);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
