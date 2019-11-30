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
public class Ajout_cov_demande extends BaseForm{
    
    Form f;
    NumericSpinner heur_depart;
    NumericSpinner minute_depart;
    TextField ville_depart;
    TextField address_depart;
    TextField ville_arrive;
    TextField address_arrive;
    TextField description;
    Button btnajout;
    Boolean test =false;

    public Ajout_cov_demande(Resources res){
        
        super("Ajouter Votre Demande", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Votre Demande");
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
       
        
        
        f = new Form("Ajouter Demande");
        heur_depart = new NumericSpinner();
        minute_depart = new NumericSpinner();
        ville_depart = new TextField();
        address_depart = new TextField();
        ville_arrive = new TextField();
        address_arrive = new TextField(); 
        description = new TextField();
        heur_depart.setMax(24);
        minute_depart.setMax(60);
        Picker datePicker = new Picker();
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.x());
        btnajout = new Button("ajouter");
        Label timeson = new Label("heur de depart");
        Label dateson = new Label("Date de depart");
        cnt1.add(dateson);
        cnt1.add(datePicker);
        add(cnt1); 
        cnt2.add(timeson);
        cnt2.add(heur_depart);
        cnt2.add(minute_depart);
        
       
        ville_depart.setUIID("TextFieldBlack");
        addStringValue("ville depart", ville_depart);
        
        address_depart.setUIID("TextFieldBlack");
        addStringValue("address_depart", address_depart);
        
        ville_arrive.setUIID("TextFieldBlack");
        addStringValue("ville arrive", ville_arrive);
        
        address_arrive.setUIID("TextFieldBlack");
        addStringValue("address_arrive", address_arrive);
        
        description.setUIID("TextFieldBlack");
        addStringValue("description", description);
//        cotisation.setUIID("TextFieldBlack");
//        addStringValue("cotisation", cotisation);
        
        add(cnt2);
        add(btnajout);
        
        datePicker.setType(Display.PICKER_TYPE_DATE);
        
        btnajout.addActionListener((e) -> {
            //verfication eli homa mahomch far8in
            if( ville_arrive.getText().length()==0 || ville_depart.getText().length()==0
               || address_arrive.getText().length()==0 || address_depart.getText().length()==0){
                test = true;
                 
            }
            
         // jawek mrigle
            if(test==false)
            {
                
            ServiceCov ser = new ServiceCov();
            Covoiturage cov = new Covoiturage(Integer.valueOf((int) heur_depart.getValue())
                                              ,Integer.valueOf((int)minute_depart.getValue())
                                  , ville_depart.getText(),address_depart.getText(),
                                    ville_arrive.getText(), address_arrive.getText()
                                 , description.getText());
           String DATE_FORMAT = "yyyy/MM/dd";
           SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
           String s = sdf.format(datePicker.getDate());  
           ////////
           String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //get the other date into a string
             boolean isInThePast = (today.compareTo(s) > 0);
if(isInThePast==true)
{
    Dialog.show("Date Incorrecte", "Date doit etre supérieur a date d'aujourd'hui ", "Ok", null);
                test=false;
}
else
{
  


     /////////      
           
           cov.setDate_depart(s);
           ser.ajoutCovDemande(cov);
           Menu_Cov menu = new Menu_Cov(res);
           menu.show();
}
            }
            
               if(test == true)
            {
                Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires ", "Ok", null);
                test=false;
            }

        });
       
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public NumericSpinner getHeur_depart() {
        return heur_depart;
    }

    public void setHeur_depart(NumericSpinner heur_depart) {
        this.heur_depart = heur_depart;
    }

    public NumericSpinner getMinute_depart() {
        return minute_depart;
    }

    public void setMinute_depart(NumericSpinner minute_depart) {
        this.minute_depart = minute_depart;
    }

  

    public TextField getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(TextField ville_depart) {
        this.ville_depart = ville_depart;
    }

    public TextField getAddress_depart() {
        return address_depart;
    }

    public void setAddress_depart(TextField address_depart) {
        this.address_depart = address_depart;
    }

    public TextField getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(TextField ville_arrive) {
        this.ville_arrive = ville_arrive;
    }

    public TextField getAddress_arrive() {
        return address_arrive;
    }

    public void setAddress_arrive(TextField address_arrive) {
        this.address_arrive = address_arrive;
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
