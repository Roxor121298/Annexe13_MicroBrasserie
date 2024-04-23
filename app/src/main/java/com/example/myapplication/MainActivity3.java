package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Vector;

public class MainActivity3 extends AppCompatActivity {

    ListView ListeBiere;

    Gestion_BD instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        instance = Gestion_BD.getInstance(getApplicationContext());

        ListeBiere = findViewById(R.id.ListeBiere);
    }

    @Override
    protected void onStart() {
        super.onStart();
        instance.ouvrirConnexion();

        Vector<String> st = null;
        try {
            st = new Vector<String>(instance.retounerBiere());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayAdapter<String> array = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,st);
        ListeBiere.setAdapter(array);
    }

    @Override
    protected void onStop() {
        super.onStop();
        instance.fermerConnexion();
    }
}