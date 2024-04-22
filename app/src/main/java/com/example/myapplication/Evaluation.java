package com.example.myapplication;

public class Evaluation {

    String nom;
    String microbrasserie;
    int etoile;

    public Evaluation(String nom, String microbrasserie, int etoile){
        this.nom = nom;
        this.microbrasserie = microbrasserie;
        this.etoile = etoile;
    }
    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getMicrobrasserie() {return microbrasserie;}

    public void setMicrobrasserie(String microbrasserie) {this.microbrasserie = microbrasserie;}

    public int getEtoile() {return etoile;}

    public void setEtoile(int etoile) {this.etoile = etoile;}


}
