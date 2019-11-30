/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import com.esprit.EspritEntreAide.Service.ServiceCov;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Affiche_cov_inforeservation extends BaseForm{

    
    
     Form f = new Form("Information de offre",BoxLayout.y());
    SpanLabel lb;
    private Button offres;
    private Button demandes;
   
    private ImageViewer img;
 
    public Container addItem(Covoiturage e)
    {     
         Resources theme = UIManager.initFirstTheme("/theme");
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        Container cnt3 = new Container(BoxLayout.y());
        img = new ImageViewer();
        img.setImage(theme.getImage("images.png"));
        add(img);
        Label lbhd = new Label(String.valueOf(e.getHeure_depart()));
        Label lbmd = new Label(String.valueOf(e.getMinute_depart()));
        Label lbva = new Label(e.getVille_arrive());
        Label lbaa = new Label(e.getAdr_arrive());
        Label lbvd = new Label(e.getVille_depart());
        Label lbad = new Label(e.getAdr_depart());
        Label nbplaces = new Label(String.valueOf(e.getNbr_places()));
        Label cotisation = new Label(String.valueOf(e.getCotisation()));
        Label lbdesiption = new Label(e.getDescription());
          Button btreserve = new Button("Confirmer");
          btreserve.addActionListener((l)->{
            Affiche_cov_Etas_Reservation c = new Affiche_cov_Etas_Reservation(e.getId_cov(),theme);
            c.show();
           });
 
      
        cnt3.add(btreserve);
        
        lbhd.setUIID("TextFieldBlack");
        addStringValue("Heur de depart", lbhd);
        
        lbmd.setUIID("TextFieldBlack");
        addStringValue("Minute de depart", lbmd);
        
        lbvd.setUIID("TextFieldBlack");
        addStringValue("Ville de depart", lbvd);
        
        
        lbad.setUIID("TextFieldBlack");
        addStringValue("Address de depart", lbad);
       
        lbva.setUIID("TextFieldBlack");
        addStringValue("Ville d'arrivé", lbva);
        
        
        lbaa.setUIID("TextFieldBlack");
        addStringValue("Address d'arrvié", lbaa);
        
        
        cotisation.setUIID("TextFieldBlack");
        addStringValue("cotisation", cotisation);
        
        nbplaces.setUIID("TextFieldBlack");
        addStringValue("Nombre des places", nbplaces);
        
        
        lbdesiption.setUIID("TextFieldBlack");
        addStringValue("Description", lbdesiption);
        cnt2.add(cnt1);
        cnt3.add(cnt2);
        return cnt3;
        
        
        
        
    }
    
    public Affiche_cov_inforeservation(int id_cov,Resources res) {
       
        super("Information D'offre", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Information D'offre");
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
        Button n = new Button();
        add(LayeredLayout.encloseIn(sl));
      
        
          ServiceCov servicecov=new ServiceCov();
          
                   
          List<Covoiturage> listcovs=new ArrayList<>();
            System.out.println("-----------------------------");
           listcovs=servicecov.getListinforeservationcov(id_cov);
        
            for(Covoiturage c: listcovs){
               add(addItem(c));
          }
           //f.show();   
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }

    
    
}
