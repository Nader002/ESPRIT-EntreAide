/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;

/**
 *
 * @author Ahri
 */
public class DemandeRevision {
    private int id;

    private int idUser;

    private String niveau;

    private String image;

    private String matiere;

    private String description;

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

    @Override
    public String toString() {
        return "DemandeRevision{" + "id=" + id + ", idUser=" + idUser + ", niveau=" + niveau + ", image=" + image + ", matiere=" + matiere + ", description=" + description + '}';
    }

    public DemandeRevision(String niveau, String matiere, String description) {
        this.niveau = niveau;
        this.matiere = matiere;
        this.description = description;
    }

    public DemandeRevision() {
    }

}
