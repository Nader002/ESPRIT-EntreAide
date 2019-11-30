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
import com.esprit.EspritEntreAid.entities.DemandeRevision;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.DemRevService;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

/**
 *
 * @author sana
 */
public class ModifDemandeRevForm extends BaseForm {

    Form f;
    TextField matiere;
    TextField niveau;
    TextField description;
    Button btnMod, btnAnnuler;

//    ModifForm(Event li, Resources res) {
//    }
    public ModifDemandeRevForm(DemandeRevision ta, Resources res) {
        f = new Form("Modification");
        
        matiere = new TextField(ta.getMatiere());
        matiere.getAllStyles().setFgColor(CYAN);
        description = new TextField(ta.getDescription());
        description.getAllStyles().setFgColor(CYAN);
        niveau = new TextField(ta.getNiveau());
        niveau.getAllStyles().setFgColor(CYAN);

        btnMod = new Button("Modifier");
        btnAnnuler = new Button("Annuler");
        f.add(matiere);
        f.add(niveau);

        f.add(description);

        f.add(btnMod);
        f.add(btnAnnuler);
        btnMod.addActionListener((e) -> {
            DemRevService ser = new DemRevService();
            ta.setMatiere(matiere.getText());

            ta.setDescription(description.getText());
            ta.setNiveau(niveau.getText());
//            Event t = new Event( ttitre.getText(),
//                    tlieu.getText() ,
//                    Double.valueOf(tprix.getText()), 
//                   // Double.parseDouble(tprix.getText()),
//                    tdescription.getText(),     
//                    Integer.parseInt(tnbreticket.getText()));
//            //Event t = new Event( ttitre.getText(), tdescription.getText(), Double.parseDouble(tprix.getText()), tlieu.getText() ,Integer.parseInt(tnbreticket.getText()));

            System.out.println("9bal modif");

            ser.modifierDemandeRev(ta, res);

            System.out.println("baad l modif");
//                        Dialog.show("Succés", "Evenement modifié", "ok", null);

        });

        btnAnnuler.addActionListener((e) -> {
            MesDemandesRev a = new MesDemandesRev(res);
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
