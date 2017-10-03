package com.example.lcassiol.android_quizzgame;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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

    String questions[] = {"Earth is the third planet from the Sun.",
            "How many fingers have a hand?",
            "Complete the word: Coca-",
            "What weight of the earth?",
            "If you have five lemons and you have sold two, how much do you have?",};

    String optionA[] = {"True",
            "Two",
            "Nah",
            "5,972 × 10^24 kg",
            "2"};

    String optionB[] = {"False",
            "Five",
            "Blue",
            "5,962 × 10^24 kg",
            "3"};

    String optionC[] = {"True and False?",
            "Six, obviously!",
            "Cola",
            "5,942 × 10^24 kg",
            "8"};

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
        resultMessage(btnSubmit);
    }

    public void updateQuestion(View view){

        if(questionNumber == questions.length){
            radioOptionA.setEnabled(false);
            radioOptionB.setEnabled(false);
            radioOptionC.setEnabled(false);
            radioGroup.clearCheck();

            checktAnswer();
        }else{
            txtQuestion.setText(questions[questionNumber]);
            radioOptionA.setText(optionA[questionNumber]);
            radioOptionB.setText(optionB[questionNumber]);
            radioOptionC.setText(optionC[questionNumber]);

            radioGroup.clearCheck();
            questionNumber++;
        }


    }

    public void resultMessage(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Result");
        alertDialog.setMessage("Right Answers: " + rightAnswers);
        alertDialog.setButton(Dialog.BUTTON_POSITIVE,"Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent personInfoIntent = new Intent(getApplicationContext(), ResultActivity.class);
                personInfoIntent.putExtra("result",rightAnswers);

                startActivity(personInfoIntent);
            }
        });
        alertDialog.show();
        btnSubmit.setEnabled(false);

    }


}
