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
public class Reservation {
    protected int id_cov;
    protected int id_user_offre;
    protected int id_user_demande;
    protected String etas;
   // protected Date date;

    public Reservation() {
    }

    public int getId_cov() {
        return id_cov;
    }

    public void setId_cov(int id_cov) {
        this.id_cov = id_cov;
    }

    public int getId_user_offre() {
        return id_user_offre;
    }

    public void setId_user_offre(int id_user_offre) {
        this.id_user_offre = id_user_offre;
    }

    public int getId_user_demande() {
        return id_user_demande;
    }

    public void setId_user_demande(int id_user_demande) {
        this.id_user_demande = id_user_demande;
    }

    public String getEtas() {
        return etas;
    }

    public void setEtas(String etas) {
        this.etas = etas;
    }

   


    public Reservation(int id_cov, int id_user_offre, int id_user_demande) {
        this.id_cov = id_cov;
        this.id_user_offre = id_user_offre;
        this.id_user_demande = id_user_demande;
    }

    @Override
    public String toString() {
        return  etas ;
    }
    
    
    
    
    
}
