/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.esprit.EspritEntreAide.gui.*;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import com.esprit.EspritEntreAid.entities.DemandeRevision;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.DemRevService;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import com.esprit.EspritEntreAide.Service.ServiceCov;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Menu_Revision extends BaseForm {

    Form f = new Form("List des Offres", BoxLayout.y());
    SpanLabel lb;

    private Button offres;
    private Button demandes;
    private Button mesoffres;
    private Button mesdemandes;
    private Button mesreservations;
    private Button ajouter_offre;
    private Button ajouter_demande;

    public Menu_Revision(Resources res) {

        super("MENU", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);
        tb.addSearchCommand(e -> {
        });
        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Button n = new Button();
        add(LayeredLayout.encloseIn(sl));

        OffreRevService serviceRev = new OffreRevService();
        // la button des offres
        Button b = new Button();
        offres = new Button("Offres");
        offres.addActionListener((av) -> {
            List<OffreRevision> listrevs = new ArrayList<>();
            listrevs = serviceRev.getList2();

            Affichage c = new Affichage(res);
            c.show();
        });
        add(offres);
        // button des demandes
        DemRevService serviceDemRev = new DemRevService();

        demandes = new Button("Demandes");
        demandes.addActionListener((av) -> {
            List<DemandeRevision> listrevs = new ArrayList<>();
            listrevs = serviceDemRev.getList2();

            AffichageDemRev c = new AffichageDemRev(res);
            c.show();
        });
        add(demandes);//
//        // button mes offres
        mesoffres = new Button("Mes Offres de révision");
        mesoffres.addActionListener((av) -> {
            MesOffresRev c = new MesOffresRev(res);
            c.show();
        });
        add(mesoffres);
//
        //button mes demandes
        mesdemandes = new Button("Mes Demandes");
        mesdemandes.addActionListener((av) -> {

            MesDemandesRev c = new MesDemandesRev(res);
            c.show();
        });
        add(mesdemandes);
//        //button mes reservations
        mesreservations = new Button("Mes Reservations");
        mesreservations.addActionListener((av) -> {

            MesReservationRev c = new MesReservationRev(res);
            c.show();
        });
        add(mesreservations);
//       //button ajouter offre
        ajouter_offre = new Button("Ajouter une offre de révision");
        ajouter_offre.addActionListener((av) -> {

            Ajout_rev_offre c = new Ajout_rev_offre(res);
            c.show();
        });
        add(ajouter_offre);
    //button ajouter demande
        ajouter_demande = new Button("Ajouter une demande de révision");
        ajouter_demande.addActionListener((av) -> {

            Ajout_rev_demande c = new Ajout_rev_demande(res);
            c.show();
        });
        add(ajouter_demande);
        
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
