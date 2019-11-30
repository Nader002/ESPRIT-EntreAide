/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;

import java.util.Date;

/**
 *
 * @author Ahri
 */
public class OffreRevision {


    private int id;

    private int idUser;

    private String niveau;
    private String date;

    public OffreRevision(String niveau, String matiere, String description, int heure, String lieu, int nbreEtudiant) {
        this.niveau = niveau;
        this.matiere = matiere;
        this.description = description;
        this.heure = heure;
        this.lieu = lieu;
        this.nbreEtudiant = nbreEtudiant;
    }
    
    
    
    
    public OffreRevision(String niveau, String matiere, String description, int heure, String lieu, int nbreEtudiant, String date) {
        this.niveau = niveau;
        this.matiere = matiere;
        this.description = description;
        this.heure = heure;
        this.lieu = lieu;
        this.nbreEtudiant = nbreEtudiant;
        this.date = date;
    }
    
    

    private String image;

    private String matiere;

    private String description;

    

    private int heure;

    private String lieu;

    private int nbreEtudiant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OffreRevision(int id, int idUser, String niveau, String matiere, String description, String date, int heure, String lieu, int nbreEtudiant) {
        this.id = id;
        this.idUser = idUser;
        this.niveau = niveau;
        this.matiere = matiere;
        this.description = description;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.nbreEtudiant = nbreEtudiant;
    }

    public int getHeure() {
        return heure;
    }

    public OffreRevision() {
    }

    public OffreRevision(int id, int idUser, String niveau, String matiere) {
        this.id = id;
        this.idUser = idUser;
        this.niveau = niveau;
        this.matiere = matiere;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbreEtudiant() {
        return nbreEtudiant;
    }

    public void setNbreEtudiant(int nbreEtudiant) {
        this.nbreEtudiant = nbreEtudiant;
    }

    @Override
    public String toString() {
        return "OffreRevision{" + "id=" + id + ", idUser=" + idUser + ", niveau=" + niveau + ", image=" + image + ", matiere=" + matiere + ", description=" + description + ", date=" + date + ", heure=" + heure + ", lieu=" + lieu + ", nbreEtudiant=" + nbreEtudiant + '}';
    }    
}
