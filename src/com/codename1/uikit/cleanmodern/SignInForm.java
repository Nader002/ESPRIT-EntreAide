/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.FloatingHint;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.EspritEntreAid.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Sign in UI
 *
 * @author Shai Almog
 */
public class SignInForm extends BaseForm {

    public static User connectedUser = new User();
    boolean connected = false;
    boolean blocke = false;
    Form f;
    static String tfLogin;

    public SignInForm(Resources res) {
        super(new BorderLayout());

        if (!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout) getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
        getTitleArea().setUIID("Container");
        setUIID("SignIn");

        add(BorderLayout.NORTH, new Label(res.getImage("Logo.png"), "LogoLabel"));

        TextField username = new TextField("", "Email", 20, TextField.ANY);
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("connecter");
        Button signUp = new Button("Inscription");
        signUp.addActionListener(e -> new SignUpForm(res).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("pas de compte ? ");

        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                signIn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        signIn.requestFocus();
        signIn.addActionListener(l -> {
            if (username.getText().equals("")) {
                Dialog.show("Veuillez réessayer", "Nom d'utilisateur ou Mot de passe incorrecte", "Ok", null);
            } else if (password.getText().equals("")) {
                Dialog.show("Veuillez réessayer", "Nom d'utilisateur ou Mot de passe incorrecte", "Ok", null);
            } else {
                System.out.println("test");
                connectedUser = getUser(username.getText(), password.getText());
                System.out.println(connectedUser);
                if (connectedUser.getNom() == null) {
                    Dialog.show("Veuillez réessayer", "Nom d'utilisateur ou Mot de passe incorrecte", "Ok", null);
                } else {
                    Dialog.show("Bienvenue", connectedUser.getNom(), "Ok", null);
                    NewsfeedForm Home = new NewsfeedForm(res);
                    Home.show();
                }

            }
             
        });
    }

    public User getUser(String email, String pwd) {
        User user = new User();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pie404/web/app_dev.php/Mobile/finduser/" + email + "/" + pwd);

        con.addResponseListener(e -> {
            try {
                JSONParser j = new JSONParser();
                Map<String, Object> users = j.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(users);
                if (users.isEmpty()) {
                    System.out.println("map empty");
                } else {

                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
                    System.out.println("hhahahhahahaha");

                    user.setId_user((int) Float.parseFloat(users.get("idUser").toString()));
                    user.setNom(users.get("nom").toString());
                    user.setPrenom(users.get("prenom").toString());
                    user.setClasse(users.get("classe").toString());
                    user.setEmail(users.get("email").toString());
                    user.setPwd(users.get("pwd").toString());
                    user.setTel(users.get("tel").toString());
                    //user.setLien_fb(users.get("lien_fb").toString());
                }
            } catch (IOException ex) {

            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }
}
