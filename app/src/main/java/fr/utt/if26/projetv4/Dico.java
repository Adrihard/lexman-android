package fr.utt.if26.projetv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dico extends AppCompatActivity {
    ListView listView;
    int IDL;
    int IDT;
    String titre="2";
    String desc="1";
    Button Add;

    Persistance bdd = new Persistance(this);
    //Terme T = new Terme(0,"i","t",1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dico);

        Intent myintent = getIntent();
        IDL=myintent.getIntExtra("IDL",0);

        listView = (ListView)findViewById(R.id.ListViewDico);

        final List<Terme> listDico = bdd.listerTermes(IDL);
        List<String> values = ListeTitre(listDico);
       // View v =new View();

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                  //  Intent intent= new Intent (view.getContext(),Def.class);
                 //   intent.putExtra("IDL2",IDL);
                 //   startActivityForResult(intent,IDL);
                titre=listDico.get(position).getTitre();
                desc=listDico.get(position).getDescriptif();

                Intent intent2= new Intent (view.getContext(),Def2.class);
                intent2.putExtra("titre",titre);
                intent2.putExtra("desc",desc);
                startActivityForResult(intent2,1);



            }
        });
        //listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                IDT=listDico.get(position).getId();
                Intent my_intent = new Intent(view.getContext(), PopDef.class);
                my_intent.putExtra("IDT", IDT);
                startActivityForResult(my_intent, IDT);
                return true;
            }
            });

        Add = (Button) findViewById(R.id.bAjoute);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent0 = new Intent(v.getContext(), AjoutDef.class);
                intent0.putExtra("IDl", IDL);
                startActivityForResult(intent0, 1);
            }
        });
    }


    private List<String> ListeTitre(List<Terme> lTerme)
    {
        List<String> lTitre= new ArrayList<>();
        //int a=0;
        for (int i=0;i<lTerme.size();i++)
        {
            lTitre.add(lTerme.get(i).getTitre());
        }
        return lTitre;
    }
}




