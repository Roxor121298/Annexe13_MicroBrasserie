package com.example.myapplication;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Collection;
import java.util.Vector;
public class Gestion_BD  extends SQLiteOpenHelper {

    private static Gestion_BD instance;

    private SQLiteDatabase database;


    public static Gestion_BD getInstance(Context contexte) {
        if (instance == null)
            instance = new Gestion_BD(contexte);
        return instance;
    }

    private Gestion_BD(Context context) {
        super(context, "db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Biere (_id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, microbrasserie TEXT, etoile INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS inventeurs");
        onCreate(db);
    }

    public void ouvrirConnexion(){
        database = this.getWritableDatabase();
    }
    public void fermerConnexion(){
        database.close();
    }

    public void ajoutBiere(SQLiteDatabase db, Evaluation i){
        // besoin de faire un ContentValues (ce comporte comme un hashTable
        ContentValues values = new ContentValues();

        // Prepare the data to insert
        values.put("nom", i.getNom());
        values.put("origine", i.getMicrobrasserie());
        values.put("invention", i.getEtoile());

        db.insert("Biere", null, values);
    }
}
