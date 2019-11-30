/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;

import java.util.Date;

/**
 *
 * @author ryhab
 */
public class Colocation {
    private int id_col;	
private int id_user;
private String adress;
private String fumeur;
private String alcoolique;
private String parking;
private String garage;
private float prix;	
private String description;	
private int meuble;
private String type	;
private Date date;
private int nbr_chdemd;
private int nbr_chdispo;
private String img1;	
private String img2;	
private String img3;	
private String img4;
private double latitude;
private double longitude;

    public Colocation() {
    }

    public int getId_col() {
        return id_col;
    }

    public void setId_col(int id_col) {
        this.id_col = id_col;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFumeur() {
        return fumeur;
    }

    public void setFumeur(String fumeur) {
        this.fumeur = fumeur;
    }

    public String getAlcoolique() {
        return alcoolique;
    }

    public void setAlcoolique(String alcoolique) {
        this.alcoolique = alcoolique;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMeuble() {
        return meuble;
    }

    public void setMeuble(int meuble) {
        this.meuble = meuble;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbr_chdemd() {
        return nbr_chdemd;
    }

    public void setNbr_chdemd(int nbr_chdemd) {
        this.nbr_chdemd = nbr_chdemd;
    }

    public int getNbr_chdispo() {
        return nbr_chdispo;
    }

    public void setNbr_chdispo(int nbr_chdispo) {
        this.nbr_chdispo = nbr_chdispo;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Colocation(int id_col) {
        this.id_col = id_col;
    }

    @Override
    public String toString() {
        return "Colocation{" + "id_col=" + id_col + ", id_user=" + id_user + ", adress=" + adress + ", fumeur=" + fumeur + ", alcoolique=" + alcoolique + ", parking=" + parking + ", garage=" + garage + ", prix=" + prix + ", description=" + description + ", meuble=" + meuble + ", type=" + type + ", date=" + date + ", nbr_chdemd=" + nbr_chdemd + ", nbr_chdispo=" + nbr_chdispo + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

   
    public Colocation(String adress, float prix, String description, int nbr_chdispo, String img1) {
        this.adress = adress;
        this.prix = prix;
        this.description = description;
        this.nbr_chdispo = nbr_chdispo;
        this.img1 = img1;
    }
    
    

}
