package com.fisc.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton optionA, optionB, optionC, optionD;

    private ArrayList<String> questionStatus = new ArrayList<>();

    private String[][] questions = {
            {
                    "1. Para lograr que el algoritmo pueda leer los datos de entrada para que pueda comenzar con los procesamientos. ¿Qué se debe tener en cuenta a la hora de crear el algoritmo?",
                    "a) Se debe pensar en donde se va a procesar la variable de entrada del algoritmo.",
                    "b) Se debe tener en cuenta que tipo de entrada va a leer el algoritmo (números, caracteres, etc.).",
                    "c) Debemos pensar en cómo se va a imprimir el resultado al final de los procesos.",
                    "d) Es necesario pensar en que operaciones se puede usar el dato que va a pedir tu algoritmo."
            },
            {
                    "2. Si queremos calcular la circunferencia de un círculo dado su radio y la fórmula (2*π*R), ¿Qué valores de la fórmula son variables y qué valores son constantes?",
                    "a) El valor de π es variable",
                    "b) Los valores π y R son constantes.",
                    "c) El valor de π es constante y R es variable.",
                    "d) Ninguna de las anteriores."
            },
            {
                    "3. Un administrador de base de datos del Banco Doge desea escribir un programa que calcule el interés simple de un préstamo. ¿Cuáles serían los datos necesarios para realizar el cálculo?",
                    "a) Crédito y débito.",
                    "b) Capital Inicial y Capital final.",
                    "c) Monto y cantidad de veces que se compone al año.",
                    "d) Capital, tasa de interés y tiempo en años ."
            },
            {
                    "4. Los algoritmos se crean para que puedan lidiar con los escenarios en los que se necesita, pero para que estos algoritmos puedan ser los óptimos a la hora de resolver una tarea. ¿Qué debemos pensar primero para que el algoritmo se adapte a la tarea que se debe resolver?",
                    "a) Debes pensar en que lenguaje de programación lo vas a crear.",
                    "b) Debemos preguntarnos qué tipo de resultado queremos obtener con el algoritmo.",
                    "c) Se debe tomar en cuenta las decisiones positivas (un escenario en “si”) y las negativas (un escenario en “no”).",
                    "d) Las respuestas anteriores no son las correctas para la pregunta."
            },
            {
                    "5. En la operación 5+7(9*3)-28, ¿Cuál sub-operación se realiza primero?",
                    "a) (9*3)",
                    "b) 5-28",
                    "c) 7(9)",
                    "d) 5+7"
            }
    };

    private char[] answers = {'b', 'c', 'd', 'c', 'a'};
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
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity.this, "Seleccionar respuesta", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (checkAnswer()) {
                        score++;
                        questionStatus.add("La pregunta " + (questionNumber + 1) + " fue correcta");
                    } else {
                        questionStatus.add("La pregunta " + (questionNumber + 1) + " fue incorrecta");
                    }
                    questionNumber++;
                    if (questionNumber < questions.length) {
                        loadQuestion();
                    } else {
                        Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                        intent.putExtra("score", score);
                        intent.putStringArrayListExtra("questionStatus", questionStatus);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[questionNumber][0]);
        optionA.setText(questions[questionNumber][1]);
        optionB.setText(questions[questionNumber][2]);
        optionC.setText(questions[questionNumber][3]);
        optionD.setText(questions[questionNumber][4]);
        radioGroup.clearCheck();
    }

    private boolean checkAnswer() {
        int selectedOptionId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedOptionId);
        return selectedOption.getText().toString().charAt(0) == answers[questionNumber];
    }
}
