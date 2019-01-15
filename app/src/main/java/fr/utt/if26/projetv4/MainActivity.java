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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListView listView2;
    public int IDhell;
    Persistance bdd = new Persistance(this);
    Button Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bdd.creerLexique("lex1","descl1");

        listView = (ListView) findViewById(R.id.listViewLex);
        final List<Lexique> listLex = bdd.listerLexiques();
        //List<String> listDico2 = listDico.get
        List<String> values = ListeTitre(listLex);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int IDL = listLex.get(position).getId();
                //bdd.creerTerme("ter1","desct1",IDL);
                Intent myintent = new Intent(view.getContext(), Dico.class);
                myintent.putExtra("IDL", IDL);
                // startActivityForResult(myintent,IDL);
                startActivityForResult(myintent, 1);
            }

        });

        Add = (Button) findViewById(R.id.bAjoute2);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent8 = new Intent(v.getContext(), AjoutLexique.class);
                startActivityForResult(intent8, 1);
            }
        });
        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                IDhell=listLex.get(position).getId();
                Intent my_intent8 = new Intent(view.getContext(), PopLex.class);
                my_intent8.putExtra("IDhell", IDhell);
                startActivityForResult(my_intent8, 1);
                return true;
            }
        });
    }

        private List<String> ListeTitre (List < Lexique > lLex)
        {
            List<String> lTitre = new ArrayList<>();
            //int a=0;
            for (int i = 0; i < lLex.size(); i++) {
                lTitre.add(lLex.get(i).getTitre());
            }
            return lTitre;
        }


}
