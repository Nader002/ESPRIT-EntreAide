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
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import java.util.Date;

/**
 *
 * @author me
 */
public class Ajout_rev_offre extends BaseForm {

    Form f;
    NumericSpinner heure;
    TextField matiere;
    TextField niveau;
    TextField lieu;
    TextField description;
    NumericSpinner nbre_etudiants;
    Button btnajout;
    Boolean test = false;

    public Ajout_rev_offre(Resources res) {

        super("Ajouter Votre Offre", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Votre Offre");
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
        heure = new NumericSpinner();
        matiere = new TextField();
        niveau = new TextField();
        lieu = new TextField();
        description = new TextField();
        nbre_etudiants = new NumericSpinner();
        heure.setMax(24);
        nbre_etudiants.setMax(10);
        Picker datePicker = new Picker();
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.x());
        Container cnt3 = new Container(BoxLayout.x());
        btnajout = new Button("ajouter");
       // Picker datePicker = new Picker();
datePicker.setType(Display.PICKER_TYPE_DATE);
        Label timeson = new Label("heure");
        Label dateson = new Label("Date");
        Label nbre_etudiants_lab = new Label("nbre_etudiants");
        cnt1.add(dateson);
        cnt1.add(datePicker);
        add(cnt1);
        cnt2.add(timeson);
        cnt2.add(heure);
        cnt3.add(nbre_etudiants_lab);
        cnt3.add(nbre_etudiants);

        matiere.setUIID("TextFieldBlack");
        addStringValue("matiere", matiere);

        niveau.setUIID("TextFieldBlack");
        addStringValue("niveau", niveau);

        lieu.setUIID("TextFieldBlack");
        addStringValue("lieu", lieu);

        description.setUIID("TextFieldBlack");
        addStringValue("description", description);

//        cotisation.setUIID("TextFieldBlack");
//        addStringValue("cotisation", cotisation);
        add(cnt2);
        add(createLineSeparator(0xeeeeee));
        add(cnt3);
        add(btnajout);

        datePicker.setType(Display.PICKER_TYPE_DATE);

        btnajout.addActionListener((e) -> {
            //verfication eli homa mahomch far8in
            if (matiere.getText().length() == 0
                    || niveau.getText().length() == 0 || lieu.getText().length() == 0
                    || description.getText().length() == 0) {
            Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires et nombre de place est aux max 4", "Ok", null);

            } 
//            else{
//                    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//                //get the other date into a string
//                
//                boolean isInThePast = (today.compareTo(datePicker.getText()) > 0);
//                if (isInThePast == true) {
//                    Dialog.show("Date Incorrecte", "Date doit etre supérieur a date d'aujourd'hui ", "Ok", null);
//                    test = true;
//                } else 
            {// jawek mrigle
//            if (test == false) {

                OffreRevService ser = new OffreRevService();
                OffreRevision rev = new OffreRevision(niveau.getText(),matiere.getText(),
                        description.getText(),Integer.valueOf((int) heure.getValue()),
                        lieu.getText(), 
                        Integer.valueOf((int) nbre_etudiants.getValue()),datePicker.getText());
                System.out.println(datePicker.getText()+"aaaaaaa");
                rev.setImage("http://www.ducat-loc.fr/img/bonhomme%20r%C3%A8gle%20seul.png");
                
                
                String DATE_FORMAT = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String s = sdf.format(datePicker.getDate());
                System.out.println(s+"zzzzzzzz");
                ////////
                //String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                //get the other date into a string
                /*
                boolean isInThePast = (today.compareTo(s) > 0);
                if (isInThePast == true) {
                    Dialog.show("Date Incorrecte", "Date doit etre supérieur a date d'aujourd'hui ", "Ok", null);
                    test = false;
                } else {
*/
                    /////////      
                    rev.setDate(s);
                    ser.ajoutRevOffre(rev);
                    Menu_Revision menu= new Menu_Revision(res);
                    menu.show();
                }
            
//            
//        if (test == true) {
//            Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires et nombre de place est aux max 4", "Ok", null);
//            test = false;
//        }

//    }
        }
);
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public NumericSpinner getHeure() {
        return heure;
    }

    public void setHeure(NumericSpinner heure) {
        this.heure = heure;
    }
  

    public TextField getMatiere() {
        return matiere;
    }

    public void setMatiere(TextField matiere) {
        this.matiere = matiere;
    }

    public TextField getLieu() {
        return lieu;
    }

    public void setLieu(TextField lieu) {
        this.lieu = lieu;
    }

    public TextField getNiveau() {
        return niveau;
    }

    public void setNiveau(TextField niveau) {
        this.niveau = niveau;
    }
  
    public NumericSpinner getNbre_etudiantsNbre_etudiants() {
        return nbre_etudiants;
    }

    public void setNbre_etudiants(NumericSpinner nbre_etudiants) {
        this.nbre_etudiants = nbre_etudiants;
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
