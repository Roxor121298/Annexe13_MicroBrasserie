package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity2 extends AppCompatActivity {

    EditText nom, micro;

    RatingBar etoile;

    Button enregistrer;

    Gestion_BD instance;

    Ecouteurclick ec;
    Ecouteur ecetoile;

    Vector<Evaluation> Biere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        instance = Gestion_BD.getInstance(getApplicationContext());

        nom = findViewById(R.id.noms);
        micro = findViewById(R.id.MicroBrasserie);
        enregistrer = findViewById(R.id.enregistrer);
        etoile = findViewById(R.id.etoile);
        ec = new Ecouteurclick();
        ecetoile = new Ecouteur();
        enregistrer.setOnClickListener(ec);
        etoile.setOnClickListener(ec);

        Biere = new Vector<Evaluation>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        instance.ouvrirConnexion();
    }

    @Override
    protected void onStop() {
        super.onStop();
        instance.fermerConnexion();
    }

    private class Ecouteur implements  AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            float currentRating = etoile.getRating();
            etoile.setRating(currentRating + 1);
            System.out.println(etoile.getRating());
        }
    }

    private class Ecouteurclick implements View.OnClickListener {

        @Override
        public void onClick(View node) {

            if(node == enregistrer){
            String nomNode = nom.getText().toString();
            String microNode = micro.getText().toString();
            Integer etoileNode =(int) etoile.getRating();
            instance.ajoutBiere(new Evaluation(nomNode,microNode, etoileNode));
            finish();
            }
            else if(node == etoile){
                float currentRating = etoile.getRating();
                etoile.setRating(currentRating + 1);
                System.out.println("etoile.getRating()");
            }

        }
    }
}