package fr.utt.if26.projetv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    Persistance bdd = new Persistance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
       // List<Lexique> listDico = bdd.listerLexiques();
bdd.creerTerme("titre2","desc1",0);
        //List<String> listDico2 = listDico.get
        String[] vaues =new String[]{"button1","button2"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,vaues);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myintent= new Intent (view.getContext(),Dico.class);
                    startActivityForResult(myintent,0);
                }
            }
        });

       // List<Lexique> mesLexiques = Lexique.listerLexiques();

        
    }
}
