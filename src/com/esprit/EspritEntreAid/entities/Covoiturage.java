/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;

/**
 *
 * @author me
 */
public class Covoiturage {
    protected int id_cov;
    protected int id_user;
    protected String date_depart;

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }
    protected int heure_depart;
    protected int minute_depart;
    protected String ville_depart;
    protected String adr_depart;
    protected String ville_arrive;
    protected String adr_arrive;
    protected int nbr_places;
    protected int cotisation;
    protected String description;
    protected int nbr_reserve;
    protected String marque_voiture;
    protected String type_cov;
    protected String date;
   

    public Covoiturage() {
    }

    

    //constructuer complet
    public int getId_cov() {
        return id_cov;
    }

    public void setId_cov(int id_cov) {
        this.id_cov = id_cov;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

   

    public int getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(int heure_depart) {
        this.heure_depart = heure_depart;
    }

    public int getMinute_depart() {
        return minute_depart;
    }

    public void setMinute_depart(int minute_depart) {
        this.minute_depart = minute_depart;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getAdr_depart() {
        return adr_depart;
    }

    public void setAdr_depart(String adr_depart) {
        this.adr_depart = adr_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(String ville_arrive) {
        this.ville_arrive = ville_arrive;
    }

    public String getAdr_arrive() {
        return adr_arrive;
    }

    public void setAdr_arrive(String adr_arrive) {
        this.adr_arrive = adr_arrive;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public int getCotisation() {
        return cotisation;
    }

    public void setCotisation(int cotisation) {
        this.cotisation = cotisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbr_reserve() {
        return nbr_reserve;
    }

    public void setNbr_reserve(int nbr_reserve) {
        this.nbr_reserve = nbr_reserve;
    }

    public String getMarque_voiture() {
        return marque_voiture;
    }

    public void setMarque_voiture(String marque_voiture) {
        this.marque_voiture = marque_voiture;
    }

    public String getType_cov() {
        return type_cov;
    }

    public void setType_cov(String type_cov) {
        this.type_cov = type_cov;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id_cov=" + id_cov + ", heure_depart=" + heure_depart + ", minute_depart=" + minute_depart + ", ville_depart=" + ville_depart + ", adr_depart=" + adr_depart + ", ville_arrive=" + ville_arrive + ", adr_arrive=" + adr_arrive + ", nbr_places=" + nbr_places + ", cotisation=" + cotisation + ", description=" + description + '}';
    }

    public Covoiturage(int heure_depart, int minute_depart, String ville_depart, String adr_depart, String ville_arrive, String adr_arrive, int nbr_places, int cotisation, String description, int nbr_reserve) {
        this.heure_depart = heure_depart;
        this.minute_depart = minute_depart;
        this.ville_depart = ville_depart;
        this.adr_depart = adr_depart;
        this.ville_arrive = ville_arrive;
        this.adr_arrive = adr_arrive;
        this.nbr_places = nbr_places;
        this.cotisation = cotisation;
        this.description = description;
        this.nbr_reserve = nbr_reserve;
    }

    public Covoiturage(int heure_depart, int minute_depart, String ville_depart, String adr_depart, String ville_arrive, String adr_arrive, String description) {
        this.heure_depart = heure_depart;
        this.minute_depart = minute_depart;
        this.ville_depart = ville_depart;
        this.adr_depart = adr_depart;
        this.ville_arrive = ville_arrive;
        this.adr_arrive = adr_arrive;
        this.description = description;
    }

   
    

   

   
   

   
}
