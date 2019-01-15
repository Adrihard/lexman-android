package fr.utt.if26.projetv4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ModifDef extends AppCompatActivity {
    int ID;
    String titre="";
    String descriptions="";
    Persistance bdd = new Persistance(this);
    Button Modif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_def);

        Intent myintent = getIntent();
        ID=myintent.getIntExtra("ID",0);

        Modif = (Button) findViewById(R.id.bModiDef);
        Modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText EditTitre = (EditText) findViewById(R.id.etTitre);
                titre = EditTitre.getText().toString();

                EditText EditDesc = (EditText) findViewById(R.id.etDesc);
                descriptions = EditDesc.getText().toString();

                bdd.modifierTerme(ID, titre, descriptions);
                Toast.makeText(ModifDef.this,"je fais modifier bouton titre"+titre+" desc "+descriptions+ "ID"+ID,Toast.LENGTH_SHORT).show();
            }
        });




    }
}
