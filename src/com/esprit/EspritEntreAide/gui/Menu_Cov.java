/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
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
public class Menu_Cov extends BaseForm{
    Form f = new Form("List des Offres", BoxLayout.y());
    SpanLabel lb;

    private Button offres;
    private Button demandes;
    private Button mesoffres;
    private Button mesdemandes;
    private Button mesreservations;
    private Button ajouter_offre;
    private Button ajouter_demande;
    private Button Recherch_offre;
    TextField ville_arrive;
 
    
     public Menu_Cov(Resources res) {
    
        super("MENU", BoxLayout.y());
        ville_arrive = new TextField("veuillez ecrire votre Destination ici  ");
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Menu Covoiturage");
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
        
         
         
        ServiceCov servicecov = new ServiceCov();
        // la button des offres
        Button b = new Button();
        offres = new Button("Offres");
        offres.addActionListener((av) -> {
           List<Covoiturage> listcovs = new ArrayList<>();
            listcovs = servicecov.getListoffrecov();

            Affiche_cov_offre c = new Affiche_cov_offre(res);
            c.show();
        });
        add(offres);
        // button des demandes
        demandes = new Button("Demandes");
        demandes.addActionListener((av) -> {

            List<Covoiturage> listcovs = new ArrayList<>();
            listcovs = servicecov.getListdemandecov();

            Affiche_cov_demande c = new Affiche_cov_demande(res);
            c.show();
        });
        add(demandes);

        // button mes offres
        mesoffres = new Button("Mes Offres");
        mesoffres.addActionListener((av) -> {
            Affiche_cov_mesoffre c = new Affiche_cov_mesoffre(res);
            c.show();
        });
        add(mesoffres);

        //button mes demandes
        mesdemandes = new Button("Mes Demandes");
        mesdemandes.addActionListener((av) -> {

            Affiche_cov_mesdemande c = new Affiche_cov_mesdemande(res);
            c.show();
        });
        add(mesdemandes);
        //button mes reservations
        mesreservations = new Button("Mes Reservations");
        mesreservations.addActionListener((av) -> {

            Affiche_cov_mesresvations c = new Affiche_cov_mesresvations(res);
            c.show();
        });
        add(mesreservations);
       //button ajouter offre
        ajouter_offre = new Button("Ajouter Offre");
        ajouter_offre.addActionListener((av) -> {

            Ajout_cov_offre c = new Ajout_cov_offre(res);
            c.show();
        });
        add(ajouter_offre);
    //button ajouter demande
        ajouter_demande = new Button("Ajouter Demnade");
        ajouter_demande.addActionListener((av) -> {

            Ajout_cov_demande c = new Ajout_cov_demande(res);
            c.show();
        });
        add(ajouter_demande);
        
   // input recherche
   
      ville_arrive.setUIID("TextFieldBlack");
      add(ville_arrive);
        
        
    //button Recherche offre
        Recherch_offre = new Button("Rechercher offre");
        Recherch_offre.addActionListener((av) -> {

            Affiche_recherche_cov c = new Affiche_recherche_cov(res,ville_arrive.getText());
            c.show();
        });
        add(Recherch_offre);
        
    
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
