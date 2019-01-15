package fr.utt.if26.projetv4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Def2 extends AppCompatActivity {
    TextView tTitre;
    TextView tDescription;
    String T;
    String D;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_def);

        Intent intent2 = getIntent();

        T=intent2.getStringExtra("titre");
        D=intent2.getStringExtra("desc");
        tTitre = (TextView)findViewById(R.id.textViewTitre);
        tTitre.setText(T);
        tDescription = (TextView)findViewById(R.id.textViewDescription);
        tDescription.setText(D);

    }}
