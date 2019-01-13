package fr.utt.if26.projetv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Def extends AppCompatActivity {
    TextView tTitre;
    TextView tDescription;
    int ID;
    Persistance bdd = new Persistance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_def);

        Intent myintent = getIntent();

        ID=myintent.getIntExtra("ID",0);

        List<Terme> listTerme = bdd.listerTermes(ID);
        String Titre =(listTerme.get(ID).getTitre());
        String Description =(listTerme.get(ID).getDescriptif());

        tTitre = (TextView)findViewById(R.id.textViewTitre);
        tTitre.setText(Titre);
        tDescription = (TextView)findViewById(R.id.textViewDescription);
        tDescription.setText(Description);


        };
    }

