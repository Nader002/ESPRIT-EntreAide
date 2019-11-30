/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAid.entities.User;

/**
 *
 * @author Ahri
 */
public class UserService {
    
    public void ajoutUser(User user) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pie404/web/app_dev.php/Mobile/newUser?nom=" + user.getNom()
                + "&prenom=" + user.getPrenom()
                + "&email=" + user.getEmail()
                + "&pwd=" + user.getPwd()
                + "&tel=" + user.getTel()
                + "&classe=" + user.getClasse();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
}
