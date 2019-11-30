/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.esprit.EspritEntreAide.gui.*;
import com.codename1.components.ScaleImageLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.DateFormatPatterns;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import com.esprit.EspritEntreAid.entities.DemandeRevision;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.DemRevService;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import com.esprit.EspritEntreAide.Service.ServiceCov;
import java.util.Date;

/**
 *
 * @author me
 */
public class Ajout_rev_demande extends BaseForm {

    Form f;
    TextField matiere;
    TextField niveau;
    TextField description;
    Button btnajout;
    Boolean test = false;

    public Ajout_rev_demande(Resources res) {

        super("Ajouter Votre Demande", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Votre Demande");
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
        add(LayeredLayout.encloseIn(sl));

        f = new Form("Ajouter Offre");
        matiere = new TextField();
        niveau = new TextField();
        description = new TextField();
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.x());
        Container cnt3 = new Container(BoxLayout.x());
        btnajout = new Button("ajouter");
        add(cnt1);

        matiere.setUIID("TextFieldBlack");
        addStringValue("matiere", matiere);

        niveau.setUIID("TextFieldBlack");
        addStringValue("niveau", niveau);

        description.setUIID("TextFieldBlack");
        addStringValue("description", description);

//        cotisation.setUIID("TextFieldBlack");
//        addStringValue("cotisation", cotisation);
        add(cnt2);
        add(createLineSeparator(0xeeeeee));
        add(cnt3);
        add(btnajout);


        btnajout.addActionListener((e) -> {
            //verfication eli homa mahomch far8in
            if (matiere.getText().length() == 0
                    || niveau.getText().length() == 0
                    || description.getText().length() == 0) {
                test = true;

            } else
            {// jawek mrigle
            if (test == false) {

                DemRevService ser = new DemRevService();
                DemandeRevision rev = new DemandeRevision(niveau.getText(),matiere.getText(),description.getText());
                rev.setImage("demande.jpg");

                    /////////      
                    ser.ajoutDemRev(rev);
                    Menu_Revision menu= new Menu_Revision(res);
                    menu.show();
                }
            
        }
        if (test == true) {
            Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires et nombre de place est aux max 4", "Ok", null);
            test = false;
        }

    }

);
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getMatiere() {
        return matiere;
    }

    public void setMatiere(TextField matiere) {
        this.matiere = matiere;
    }

    public TextField getNiveau() {
        return niveau;
    }

    public void setNiveau(TextField niveau) {
        this.niveau = niveau;
    }

    public TextField getDescription() {
        return description;
    }

    public void setDescription(TextField description) {
        this.description = description;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }
    
     private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
     
     
    
    
}
