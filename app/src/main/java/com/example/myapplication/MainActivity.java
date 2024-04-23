package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Ecouteurclick ec;

    Button Ajouter, Voir;
    Gestion_BD instance;

    Vector <Evaluation> Biere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = Gestion_BD.getInstance(getApplicationContext());
        instance.ouvrirConnexion();
        instance.emptyDatabase();

        ec = new Ecouteurclick();

        Ajouter = findViewById(R.id.Ajouter);
        Voir = findViewById(R.id.Voir);

        Ajouter.setOnClickListener(ec);
        Voir.setOnClickListener(ec);

        Biere = new Vector<Evaluation>();

        Biere.add(new Evaluation("Pic_a_bois","Trou du yabe", 2));
        Biere.add(new Evaluation("La Ritch 2.0", "On la fait chez nous aek Sam", 4));
        Biere.add(new Evaluation("Lagueux Lager", "Saint-Bock", 3));
        Biere.add(new Evaluation("Framboise jaune", "Le Réservoir", 2));

    }

   /* @Override
    protected void onStart() {
        super.onStart();
        instance.ouvrirConnexion();
        instance.emptyDatabase();
        instance.ajoutBiere(Biere.elementAt(0));
        instance.ajoutBiere(Biere.elementAt(1));
        instance.ajoutBiere(Biere.elementAt(2));
    }

    @Override
    protected void onStop() {
        super.onStop();
        instance.fermerConnexion();
    }*/

    private class Ecouteur implements  AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

    private class Ecouteurclick implements View.OnClickListener {

        @Override
        public void onClick(View node) {

            if(node == Voir){
                Intent i = new Intent(getApplicationContext(), MainActivity3.class );
                startActivity(i);
                //finish();

            }
            else if(node == Ajouter) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class );
                startActivity(i);
                //finish();
            }

        }
    }

}

