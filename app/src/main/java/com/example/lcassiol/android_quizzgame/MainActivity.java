package com.example.lcassiol.android_quizzgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


}
