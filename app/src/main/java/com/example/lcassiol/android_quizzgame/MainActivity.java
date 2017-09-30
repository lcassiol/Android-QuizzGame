package com.example.lcassiol.android_quizzgame;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView txtQuestion;

    private RadioButton radioOptionA;
    private RadioButton radioOptionB;
    private RadioButton radioOptionC;

    private Button btnSubmit;

    String questions[] = {"Primeira Pergunta?",
            "Segunda Pergunta?",
            "Terceira Pergunta?",
            "Quarta Pergunta?",
            "Quinta Pergunta?",};

    String optionA[] = {"Resposta A para primeira pergunta",
            "Resposta A para segunda pergunta",
            "Resposta A para terceira pergunta",
            "Resposta A para quarta pergunta",
            "Resposta A para quinta pergunta"};

    String optionB[] = {"Resposta B para primeira pergunta",
            "Resposta B para segunda pergunta",
            "Resposta B para terceira pergunta",
            "Resposta B para quarta pergunta",
            "Resposta B para quinta pergunta"};

    String optionC[] = {"Resposta C para primeira pergunta",
            "Resposta C para segunda pergunta",
            "Resposta C para terceira pergunta",
            "Resposta C para quarta pergunta",
            "Resposta C para quinta pergunta"};

    int[] answers = new int[questions.length];
    int answersKeys[] = {1,2,3,1,2};
    int rightAnswers = 0;
    int questionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setEnabled(false);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioOptionA = (RadioButton) findViewById(R.id.optionA);
        radioOptionB = (RadioButton) findViewById(R.id.optionB);
        radioOptionC = (RadioButton) findViewById(R.id.optionC);

        updateQuestion(btnSubmit);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.optionA:
                        Log.i("s", "option n1");
                        answers[questionNumber-1] = 1;
                        break;
                    case R.id.optionB:
                        Log.i("s", "option n2");
                        answers[questionNumber-1] = 2;
                        break;
                    case R.id.optionC:
                        Log.i("s", "option n3");
                        answers[questionNumber-1] = 3;
                        break;
                    default:
                        break;


                }

                btnSubmit.setEnabled(true);
            }
        });

    }

    public void checktAnswer(){
        int countList = 0;

        for(int number: answers){
            if(number == answersKeys[countList]){
                rightAnswers++;
                Log.i("s", "Right Answer");
            }else{
                Log.i("s", "Wrong Answer");
            }
            countList++;
        }
        //call showResult
    }

    public void updateQuestion(View view){

        if(questionNumber == questions.length){
            checktAnswer();
        }else{
            txtQuestion.setText(questions[questionNumber]);
            radioOptionA.setText(optionA[questionNumber]);
            radioOptionB.setText(optionB[questionNumber]);
            radioOptionC.setText(optionC[questionNumber]);

            questionNumber++;
        }


    }


}
