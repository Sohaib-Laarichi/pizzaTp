package com.example.pizaatp.classes;
import java.io.Serializable;
public class Produit implements Serializable{
    private int id;
    private String nom;
   private int nbrlngredient;
   private int photo ;
   private String duree;
   private String detaislngred ;
   private String description;
   private String preparation;
    private double prix;


    private static int count = 0;

   public Produit (String nom, int nbrlngredient, int photo, String duree, String detaislngred, String description, String preparation, double prix) {
        this.id = count++;
        this.nom = nom;
        this.nbrlngredient = nbrlngredient;
        this.photo = photo;
        this.duree = duree;
        this.detaislngred = detaislngred;
        this.description = description;
        this.preparation = preparation;
        this.prix = prix;
    }
    public Produit (String nom, int nbrlngredient, int photo, String duree, String detaislngred, String description, String preparation) {
        this.id = count++;
        this.nom = nom;
        this.nbrlngredient = nbrlngredient;
        this.photo = photo;
        this.duree = duree;
        this.detaislngred = detaislngred;
        this.description = description;
        this.preparation = preparation;

    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbrlngredient() {
        return nbrlngredient;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDuree() {
        return duree;
    }

    public String getDetaislngred() {
        return detaislngred;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public double getRating() {
        return prix;
    }

    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrlngredient=" + nbrlngredient +
                ", photo=" + photo +
                ", duree=" + duree +
                ", detaislngred='" + detaislngred + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                ", prix=" + prix +
                '}';
    }
}