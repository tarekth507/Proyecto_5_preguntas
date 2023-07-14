package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton optionA, optionB, optionC, optionD;

    // Preguntas y respuestas
    // Estas preguntas no son las finales, sino que se colocaron para realizar una primera prueba del código
    private String[][] questions = {
            {
                    "¿Qué es un algoritmo?",
                    "a) Un lenguaje de programación.",
                    "b) Un conjunto de instrucciones para resolver un problema.",
                    "c) Un tipo de dato utilizado en matemáticas.",
                    "d) Una aplicación de inteligencia artificial."
            },
            {
                    "¿Cuál es el objetivo principal de un algoritmo?",
                    "a) Resolver problemas complejos de manera eficiente.",
                    "b) Generar datos estadísticos.",
                    "c) Crear interfaces de usuario intuitivas.",
                    "d) Optimizar el rendimiento de hardware."
            },
            {
                    "¿Cuál de las siguientes opciones NO es un ejemplo de un algoritmo de ordenamiento?",
                    "a) Burbuja (Bubble Sort).",
                    "b) Selección (Selection Sort).",
                    "c) Inserción (Insertion Sort).",
                    "d) HTML (HyperText Markup Language)."
            },
            {
                    "¿Qué es la complejidad de un algoritmo?",
                    "a) La dificultad de implementarlo en un lenguaje de programación específico.",
                    "b) El número de instrucciones que contiene el algoritmo.",
                    "c) La cantidad de recursos (tiempo o memoria) que requiere para ejecutarse.",
                    "d) La medida de cuántos pasos son necesarios para resolver un problema."
            },
            {
                    "¿Cuál es el enfoque principal de los algoritmos de aprendizaje automático (machine learning)?",
                    "a) Resolver problemas de seguridad informática.",
                    "b) Analizar grandes volúmenes de datos.",
                    "c) Mejorar la velocidad de procesamiento de computadoras.",
                    "d) Automatizar tareas repetitivas en sistemas operativos."
            }
    };

    private char[] answers = {'b', 'a', 'd', 'c', 'b'};
    private int score = 0;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        nextButton = findViewById(R.id.nextButton);
        questionTextView = findViewById(R.id.questionTextView);
        radioGroup = findViewById(R.id.radioGroup);
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAnswer()) {
                    score++;
                }
                questionNumber++;
                if (questionNumber < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Carga la pregunta y las opciones de respuesta
    private void loadQuestion() {
        questionTextView.setText(questions[questionNumber][0]);
        optionA.setText(questions[questionNumber][1]);
        optionB.setText(questions[questionNumber][2]);
        optionC.setText(questions[questionNumber][3]);
        optionD.setText(questions[questionNumber][4]);
        radioGroup.clearCheck();
    }

    // Verifica si la respuesta seleccionada es correcta
    private boolean checkAnswer() {
        int selectedOptionId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedOptionId);
        return selectedOption.getText().toString().charAt(0) == answers[questionNumber];
    }
}
