package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    private Button restartButton;
    private TextView scoreTextView;
    private TextView questionStatusTextView; // Agrega TextView para el estado de las preguntas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        restartButton = findViewById(R.id.restartButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        questionStatusTextView = findViewById(R.id.questionStatusTextView); // Enlaza el TextView

        int score = getIntent().getIntExtra("score", 0);
        ArrayList<String> questionStatus = getIntent().getStringArrayListExtra("questionStatus"); // Recibe el estado de las preguntas
        scoreTextView.setText("Score: " + score);

        // Muestra el estado de las preguntas
        for (String status : questionStatus) {
            questionStatusTextView.append(status + "\n");
        }

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
