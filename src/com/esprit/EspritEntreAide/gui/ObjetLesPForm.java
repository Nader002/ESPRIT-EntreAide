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
import com.codename1.util.regex.RE;
import com.esprit.EspritEntreAid.entities.Objet;
import com.esprit.EspritEntreAide.Service.ServiceObjet;
import java.io.IOException;



/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ObjetLesPForm extends BaseForm {

    public ObjetLesPForm(Resources res , Objet c) {
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
  Label l = new Label("");
        l.setUIID("TextFieldBlack");
        addStringValue(".", l);
     

    
        
       Label Email = new Label(c.getEmail());
        Email.setUIID("TextFieldBlack");
        addStringValue("Email", Email);
        
        TextField C = new TextField ();
       C.setUIID("TextFieldBlack");
        addStringValue("Ton Email", C);       

 TextArea Description = new  TextArea();
  addStringValue("Contenu",  Description );

    
         Button envoyer = new Button("Envoyer");
        addStringValue("",  envoyer );
        ServiceObjet av = new ServiceObjet();
        System.out.println(Description.getText());
       envoyer.addActionListener((e)->{
           
           
           
           
           RE x = new RE("^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}\\.[a-z]{1,4}$");
                 if( x.match(C.getText())){
           
            try {
                  c.setContenu(Description.getText()+" contacter moi sur "+C.getText());

                av.envoyermailObjet(c);
                new MesOP(res).show();
            } catch (IOException ex) {
            }}
                 else{ Dialog.show("", "Mail est un champs  obligatoire", "Ok", null);};
                 
});

       

     
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
    }
    

}
