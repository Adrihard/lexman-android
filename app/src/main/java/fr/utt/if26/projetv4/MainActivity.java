package fr.utt.if26.projetv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public int ID;
    Persistance bdd = new Persistance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bdd.creerTerme("titre2","desc1",0);


       // List<Lexique> mesLexiques = Lexique.listerLexiques();
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        List<Lexique> listLex = bdd.listerLexiques();

        //List<String> listDico2 = listDico.get
        List<String> values = ListeTitre(listLex) ;
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    Intent myintent= new Intent (view.getContext(),Dico.class);
                    myintent.putExtra("ID",position);
                    startActivityForResult(myintent,position);

            }

        });
    }

    private List<String> ListeTitre(List<Lexique> lLex)
    {
        List<String> lTitre= new ArrayList<>();
        //int a=0;
        for (int i=0;i<lLex.size();i++)
        {
            lTitre.add(lLex.get(i).getTitre());
        }
        return lTitre;
    }

}
