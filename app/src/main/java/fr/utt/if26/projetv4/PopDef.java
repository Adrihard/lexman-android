package fr.utt.if26.projetv4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopDef extends Activity {
    int ID;
    Persistance bdd = new Persistance(this);
    Button Supprimer;
    Button Modifier;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_def);

        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        Supprimer = (Button) findViewById(R.id.bSuppDef);
        Supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = getIntent();

                ID=myintent.getIntExtra("ID",0);

                bdd.supprimerTerme(ID);
            }
        });
        Modifier = (Button) findViewById(R.id.bModDef);
        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = getIntent();

                ID=myintent.getIntExtra("ID",0);

                Intent intent= new Intent (v.getContext(),ModifDef.class);
                intent.putExtra("ID",ID);
                startActivityForResult(intent,ID);

            }
        });
    }

    }
