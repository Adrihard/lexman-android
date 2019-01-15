package fr.utt.if26.projetv4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopLex extends Activity {
    int ID;
    Persistance bdd = new Persistance(this);
    Button Supprimer;
    Button Modifier;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_lex);

        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));
        Intent my_intent8 = getIntent();

        ID=my_intent8.getIntExtra("IDhell",0);

        Supprimer = (Button) findViewById(R.id.bSuppLex);
        Supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bdd.supprimerLexique(ID);
            }
        });
        Modifier = (Button) findViewById(R.id.bModLex);
        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent (v.getContext(),ModifLex.class);
                intent.putExtra("ID",ID);
                startActivityForResult(intent,ID);

            }
        });
    }

}

