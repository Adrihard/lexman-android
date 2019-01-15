package fr.utt.if26.projetv4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutDef extends AppCompatActivity {
    int IDl;
    String titre="";
    String descriptions="";
    Persistance bdd = new Persistance(this);
    Button Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoute_def);

        Intent intent0 = getIntent();
        IDl=intent0.getIntExtra("IDl",0);

        Add = (Button) findViewById(R.id.bAddDef);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText EditTitre = (EditText) findViewById(R.id.etTitreAj);
                titre = EditTitre.getText().toString();

                EditText EditDesc = (EditText) findViewById(R.id.etDescAj);
                descriptions = EditDesc.getText().toString();

                bdd.creerTerme(titre, descriptions, IDl);
                //Toast.makeText(ModifDef.this,"je fais modifier bouton titre"+titre+" desc "+descriptions+ "ID"+IDl,Toast.LENGTH_SHORT).show();

            }
        });




    }
}