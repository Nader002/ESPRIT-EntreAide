/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

/**
 *
 * @author sana
 */
public class ModifOffreRevForm extends BaseForm {

    Form f;
    TextField matiere;
    TextField niveau;
    TextField lieu;
    TextField description;
    TextField nbreEtudiants;
    Button btnMod, btnAnnuler;

//    ModifForm(Event li, Resources res) {
//    }
    public ModifOffreRevForm(OffreRevision ta, Resources res) {
        f = new Form("Modification");
        
        matiere = new TextField(ta.getMatiere());
        matiere.getAllStyles().setFgColor(CYAN);
        description = new TextField(ta.getDescription());
        description.getAllStyles().setFgColor(CYAN);
        lieu = new TextField(ta.getLieu());
        lieu.getAllStyles().setFgColor(CYAN);
        niveau = new TextField(ta.getNiveau());
        niveau.getAllStyles().setFgColor(CYAN);
        nbreEtudiants = new TextField("nbreEtudiants: " +ta.getNbreEtudiant());
        nbreEtudiants.getAllStyles().setFgColor(CYAN);

        btnMod = new Button("Modifier");
        btnAnnuler = new Button("Annuler");
        f.add(matiere);
        f.add(niveau);
        f.add(lieu);

        f.add(description);
        f.add(nbreEtudiants);

        f.add(btnMod);
        f.add(btnAnnuler);
        btnMod.addActionListener((e) -> {
            OffreRevService ser = new OffreRevService();
            ta.setMatiere(matiere.getText());

            ta.setDescription(description.getText());
            ta.setNiveau(niveau.getText());
            ta.setLieu(lieu.getText());
            ta.setNbreEtudiant(Integer.parseInt(nbreEtudiants.getText()));
//            Event t = new Event( ttitre.getText(),
//                    tlieu.getText() ,
//                    Double.valueOf(tprix.getText()), 
//                   // Double.parseDouble(tprix.getText()),
//                    tdescription.getText(),     
//                    Integer.parseInt(tnbreticket.getText()));
//            //Event t = new Event( ttitre.getText(), tdescription.getText(), Double.parseDouble(tprix.getText()), tlieu.getText() ,Integer.parseInt(tnbreticket.getText()));

            System.out.println("9bal modif");

            ser.modifierOffreRev(ta, res);

            System.out.println("baad l modif");
//                        Dialog.show("Succés", "Evenement modifié", "ok", null);

        });

        btnAnnuler.addActionListener((e) -> {
            MesOffresRev a = new MesOffresRev(res);
            a.show();
        });
        f.show();

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return matiere;
    }

    public void setTnom(TextField matiere) {
        this.matiere = matiere;
    }
     private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
