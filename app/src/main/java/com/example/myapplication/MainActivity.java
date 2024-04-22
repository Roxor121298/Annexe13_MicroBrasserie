package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gestion_BD instance = Gestion_BD.getInstance(getApplicationContext());

        instance.ouvrirConnexion();

        Evaluation Biere1 = new Evaluation("Pic_a_bois","Trou du yabe", 2);
        Evaluation Biere2 = new Evaluation("La Ritch 2.0", "On la fait chez nous aek Sam", 4);
        Evaluation Biere3 = new Evaluation("La Lageux", "Saint-Bock", 3);
        Evaluation Biere4 = new Evaluation("Framboise jaune", "Le Réservoir", 2);

        instance.ajoutBiere(instance,Biere1);

        instance.fermerConnexion();
    }
}