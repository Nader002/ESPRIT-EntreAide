/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import com.esprit.EspritEntreAide.Service.ServiceCov;
import java.util.Date;

/**
 *
 * @author me
 */
public class Affiche_Contact_demande extends BaseForm{
     
    Form f;
  
    
     public Affiche_Contact_demande(Resources res,int id_cov){
        
        super("Ajouter Votre Message", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Votre Message");
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);
        tb.addSearchCommand(e -> {});
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        add(LayeredLayout.encloseIn(sl));
       
        
        
        f = new Form("Ajouter Votre message");
        TextField multi = new TextField();
        multi.setSingleLineTextArea(false);
        multi.setRows(4);
        multi.setColumns(20);
        multi.setUIID("TextFieldBlack");
       
        add(multi); 
        Button btenvoyer = new Button("Envoyer");
        btenvoyer.addActionListener((l)->{
        ServiceCov servicecov=new ServiceCov();
        servicecov.Contacter_demande(id_cov,multi.getText());
        Menu_Cov z = new Menu_Cov(res);
        z.show();
        });
         add(btenvoyer);
    }
   
  
    
    
}
