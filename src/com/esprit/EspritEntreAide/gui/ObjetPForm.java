/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.esprit.EspritEntreAide.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.EspritEntreAid.entities.Objet;
import com.esprit.EspritEntreAide.Service.ServiceObjet;
import java.io.IOException;


/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ObjetPForm extends BaseForm {

    public ObjetPForm(Resources res , Objet c) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle(c.getNom_objet());
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
       
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 6) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 6);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
    
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            FlowLayout.encloseCenter(
                                new Label(res.getImage(""), "PictureWhiteBackgrond"))
                    )
                )
        ));

        TextField Nom = new TextField(c.getNom_objet());
        Nom.setUIID("TextFieldBlack");
        addStringValue("Nom", Nom);
                ComboBox categorie =new ComboBox(c.getCategorie());
categorie.addItem("Pc");
categorie.addItem("Portable");
categorie.addItem("Autre");

 addStringValue("' Categorie  ",  categorie );
 
 ComboBox Lieu1234 =new ComboBox(c.getLieu());
Lieu1234.addItem("BlockA");
Lieu1234.addItem("BlockB");
Lieu1234.addItem("Autre");
 addStringValue("Choisir Lieu",  Lieu1234 );


 TextArea Description = new  TextArea(c.getDescription());
  addStringValue("Description",  Description );
  
    Button modifier = new Button("Modifier");
        addStringValue("",  modifier  );
        
         Button delete = new Button("Supprimer");
        addStringValue("",  delete );
        ServiceObjet av = new ServiceObjet();
  
        delete.addActionListener((e)->{
            try {
                av.DeleteObjet(c);
                new MesOP(res).show();
            } catch (IOException ex) {
            }
});

               modifier.addActionListener((e) -> {
                           System.out.println("a"+Nom.getText());
                   
                      if(Nom.getText().equals("")) {
             Dialog.show("", "Nom est un champs  obligatoire", "Ok", null); }
            
            else {
                    
            ServiceObjet ser = new ServiceObjet();
        
             c.setId_objet(c.getId_objet());
           c.setNom_objet(Nom.getText());
           c.setCategorie(categorie.getSelectedItem().toString());
           c.setLieu(Lieu1234.getSelectedItem().toString());
           c.setDescription(Description.getText());
           ser.modifierObjet(c);
           
                       try {
                new MesOP(res).show();
            } catch (IOException ex) {
            }
            
            
             }
                  
            });

     
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
    }
    

}
