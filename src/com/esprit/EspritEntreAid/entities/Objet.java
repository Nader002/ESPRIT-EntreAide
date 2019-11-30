/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;



/**
 *
 * @author user
 */
public class Objet {

    private int id_objet;
    private int id_user;
    private String nom_objet;
    private String categorie;
    private String img;
    private String lieu;
    private String description;
    private String type;
    private String date ;
    private int etat;
    private String lu ;
    private String email ;
    private String contenu ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }



    public String getLu() {
        return lu;
    }

    public void setLu(String lu) {
        this.lu = lu;
    }

    public Objet(int id_objet, int id_user, String nom_objet, String categorie, String img, String lieu, String description, String type, String date, int etat, String lu) {
        this.id_objet = id_objet;
        this.id_user = id_user;
        this.nom_objet = nom_objet;
        this.categorie = categorie;
        this.img = img;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
        this.date = date;
        this.etat = etat;
        this.lu = lu;
    }
    
    

    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Objet(int id_objet, int id_user, String nom_objet, String categorie, String img, String lieu, String description, String type) {
        this.id_objet = id_objet;
        this.id_user = id_user;
        this.nom_objet = nom_objet;
        this.categorie = categorie;
        this.img = img;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
    }

    public Objet() {
    }

    public Objet(int id_objet, int id_user, String nom_objet, String categorie, String img, String lieu, String description, String type, String date) {
        this.id_objet = id_objet;
        this.id_user = id_user;
        this.nom_objet = nom_objet;
        this.categorie = categorie;
        this.img = img;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public Objet( int id_user, String nom_objet, String categorie, String img, String lieu, String description, String type, String date) {
        this.id_objet = id_objet;
        this.id_user = id_user;
        this.nom_objet = nom_objet;
        this.categorie = categorie;
        this.img = img;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
        this.date = date;
    }

 
    
    

    public Objet(int id_user, String nom_objet, String categorie, String img, String lieu, String description, String type) {
        this.id_user = id_user;
        this.nom_objet = nom_objet;
        this.categorie = categorie;
        this.img = img;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
    }

    public int getId_objet() {
        return id_objet;
    }

    public void setId_objet(int id_objet) {
        this.id_objet = id_objet;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_objet() {
        return nom_objet;
    }

    public void setNom_objet(String nom_objet) {
        this.nom_objet = nom_objet;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
   


}
