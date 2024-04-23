package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

public class Gestion_BD  extends SQLiteOpenHelper {

    private static Gestion_BD instance;

    private SQLiteDatabase db;


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
        db.execSQL("DROP TABLE IF EXISTS Biere");
        onCreate(db);
    }

    public void emptyDatabase(){
        db.execSQL("DROP TABLE IF EXISTS Biere");
        onCreate(db);
    }

    public void ouvrirConnexion(){
        db = this.getWritableDatabase();
    }
    public void fermerConnexion(){
        db.close();
    }

    public void ajoutBiere( Evaluation i){
        // besoin de faire un ContentValues (ce comporte comme un hashTable
        ContentValues values = new ContentValues();

        // Prepare the data to insert
        values.put("nom", i.getNom());
        values.put("microbrasserie", i.getMicrobrasserie());
        values.put("etoile", i.getEtoile());

        db.insert("Biere", null, values);
    }

    public Vector<String> retounerBiere() throws Exception {
        Cursor cursor = db.rawQuery("SELECT nom FROM Biere ORDER BY etoile DESC LIMIT 3" ,null);
        Vector<String> vecteur = new Vector<String>();

        while (cursor.moveToNext()) {
            // la méthode getcolumnIndexOrThrow permet de ne pas créer d'erreur si le nom de colonmne n'existe pas
            // getcolumnIndex permet d'utiliser un String (nom de la colonne a la place de son incrementation de colonne)
            vecteur.add(cursor.getString(cursor.getColumnIndexOrThrow("nom")));
            // setup avec une int qui réfère au numéro de la colonne
            //vecteur.add(cursor.getString(0));
        }
        if( vecteur.size() < 3){
            throw new Exception ("moins de 3 enregistrement");
        }

        cursor.close();
        return vecteur;
    }
}
