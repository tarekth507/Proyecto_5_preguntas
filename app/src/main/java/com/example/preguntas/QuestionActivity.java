package com.example.preguntas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private Button nextButton;
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton optionA, optionB, optionC, optionD;

    // Preguntas y respuestas
    // Estas preguntas no son las finales, sino que se colocaron para realizar una primera prueba del código
    private String[][] questions = {
            {
                    "1. Para lograr que el algoritmo sea creado de manera excelente, es necesario que este sea el óptimo, de manera que la carga de memoria y procesamiento sea lo más ligera posible para la computadora. Por lo tanto, existe una medida de complejidad para los algoritmos. ¿Sabes cuál es una de las formas de medir esa complejidad del algoritmo en cuestión?",
                    "a) Observando cuán extenso es el código del algoritmo que estamos usando.",
                    "b) Teniendo un conteo de cuantas operaciones básicas (como lo que es suma o división) tiene el algoritmo.",
                    "c) Contando cuantos if o if-else tiene el algoritmo que estamos viendo.",
                    "d) Observando la cantidad de archivos de memoria que utiliza nuestro algoritmo."
            },
            {
                    "2. Tenemos el siguiente código\nif a > b {\ntemp = a\na = b\nb = temp\n}\n¿Cuál es el propósito de este programa?",
                    "a) Intercambiar los valores de “a” y “b”.",
                    "b) Almacenar el valor mayor en una variable temporal para uso posterior.",
                    "c) Asegurarse de que el valor mayor siempre este almacenado en “b” y el menor en “a”.",
                    "d) Que “a” siempre sea el mayor."
            },
            {
                    "3. Un administrador de base de datos del Banco Doge desea escribir un programa que calcule el interés simple de un préstamo. ¿Cuáles serían los datos necesarios para realizar el cálculo?",
                    "a)	Crédito y débito.",
                    "b)	Capital Inicial y Capital final.",
                    "c)	Monto y cantidad de veces que se compone al año.",
                    "d)	Capital, tasa de interés y tiempo en años ."
            },
            {
                    "4. Este tipo de algoritmo es diferente debido a la forma en la que procesa sus tareas durante la compilación. Funciona de manera única, ya que está diseñado con el objetivo de obtener respuestas de la forma más rápida posible. Esto se logra al realizar tareas de manera simultánea durante la ejecución. ¿A qué tipo de algoritmo nos referimos en la descripción anterior?",
                    "a) Se refiere al algoritmo de recursividad.",
                    "b) La descripción trata del algoritmo de procesos secuenciales.",
                    "c) Habla acerca del algoritmo paralelo.",
                    "d) Las respuestas anteriores no contienen la respuesta correcta."
            },
            {
                    "5. Si “n” es el tamaño de la entrada de un algoritmo, un programa de complejidad O(n!) le tomará una cierta cantidad de tiempo realizar las operaciones necesarias para llegar al resultado dependiendo del valor “n”. Este tiempo sería:",
                    "a)	Imposiblemente largo. A cierto punto, el tamaño de la entrada resultaría en un tiempo de ejecución inconcebible, siendo un algoritmo de demasiada complejidad.",
                    "b)	Lento. Cualquier tamaño de entrada es calculable pero se puede optimizar.",
                    "c)	Rápido, es un algoritmo altamente efectivo que puede manejar cualquier tamaño de entrada en tan solo milisegundos.",
                    "d)	Lineal, manejará entradas de tamaño razonable pero tomará demasiado tiempo se le dan demasiadas cifras."
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
