package fr.utt.if26.projetv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dico extends AppCompatActivity {
    ListView listView;
    int ID;

    Persistance bdd = new Persistance(this);
    //Terme T = new Terme(0,"i","t",1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dico);

        Intent myintent = getIntent();

        ID=myintent.getIntExtra("ID",0);

        listView = (ListView)findViewById(R.id.ListViewDico);
        List<Terme> listDico = bdd.listerTermes(ID);
        List<String> values = ListeTitre(listDico) ;

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myintent= new Intent (view.getContext(),Def.class);
                    startActivityForResult(myintent,0);
                }
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
