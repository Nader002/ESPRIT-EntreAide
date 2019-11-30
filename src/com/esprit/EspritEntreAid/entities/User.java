/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAid.entities;

import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.NewsfeedForm;
import com.codename1.uikit.cleanmodern.SignInForm;
import static com.codename1.uikit.cleanmodern.SignInForm.connectedUser;
import com.codename1.uikit.cleanmodern.SignUpForm;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Ahri
 */
public class User {

    int id_user;
    String nom;
    String prenom;
    String classe;
    String email;
    String pwd;
    String tel;
    String image;
    String lien_fb;
    String lien_linkedin;
    int role;
    int code;

    public User(int id_user, String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    public User(int id_user, String nom, String email, String tel, String image, String lien_fb) {
        this.id_user = id_user;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    public User(int id_user, String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, String lien_linkedin, int role, int code) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
        this.code = code;
    }

    public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, int role, int code) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    }

    public User(String nom, String email, String mdp, String tel, String image, String lien_fb, int role, int code) {
        this.nom = nom;
        this.email = email;
        this.pwd = mdp;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String get;

    public User() {
    }

    public User(int id_user, String nom, String prenom, String classe, String email, String tel, String lien_fb) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.tel = tel;
        this.lien_fb = lien_fb;
    }

    public User(String nom, String prenom, String email, String classe, String pwd, String tel, String lien_fb) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.lien_fb = lien_fb;
    }

    public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, int role) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
    }

    public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, String lien_linkedin, int role) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
    }

    public User(String nom, String email, String pwd, String tel, String lien_fb, int role, int code) {
        this.nom = nom;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    }

    public User(String nom, String email, String pwd, String tel, String image, String lien_fb, int role) {
        this.nom = nom;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
    }

    public User(int id_user, String nom, String prenom, String classe, String email, String tel, String lien_fb, String lien_linkedin) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.tel = tel;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
    }

    public User(int id_user, String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, String lien_linkedin, int role) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom=" + nom + ", email=" + email + ", tel=" + tel + ", lien_fb=" + lien_fb + '}';
    }

    public User(int id_user, String nom, String email, String tel, String lien_fb) {
        this.id_user = id_user;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.lien_fb = lien_fb;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLien_fb() {
        return lien_fb;
    }

    public void setLien_fb(String lien_fb) {
        this.lien_fb = lien_fb;
    }

    public String getLien_linkedin() {
        return lien_linkedin;
    }

    public void setLien_linkedin(String linkedin) {
        this.lien_linkedin = linkedin;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User(String nom, String prenom, String email, String pwd, String tel, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.pwd = pwd;
        this.tel = tel;
    }

}
