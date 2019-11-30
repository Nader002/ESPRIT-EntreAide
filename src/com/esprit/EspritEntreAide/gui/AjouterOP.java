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

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.codename1.util.Base64;
import com.esprit.EspritEntreAid.entities.Objet;
import com.esprit.EspritEntreAide.Service.ServiceObjet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import rest.file.uploader.tn.FileUploader;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class AjouterOP extends BaseForm {

String Imagecode = null ;
String path ;

    public AjouterOP(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Objet Perdu");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        TextField image =  new TextField("a");
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() /7 ) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 7);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            
                            FlowLayout.encloseCenter(
                                new Label())
                    )
                )
        ));

        TextField Nom = new TextField();
       Nom.setUIID("Nom");
        addStringValue("Nom", Nom);

        ComboBox categorie =new ComboBox();
categorie.addItem("Pc");
categorie.addItem("Potable");
categorie.addItem("Autre");

 addStringValue("' Categorie  ",  categorie );
 
        ComboBox Lieu1234 =new ComboBox();
Lieu1234.addItem("BlockA");
Lieu1234.addItem("BlockB");
Lieu1234.addItem("Autre");
                ImageViewer l = new ImageViewer();

 addStringValue("Choisir Lieu",  Lieu1234 );
 
 TextArea Description = new  TextArea();
  addStringValue("Description",  Description );
        Button getStarted = new Button();

            FontImage.setMaterialIcon(getStarted,  FontImage.MATERIAL_CAMERA_ALT,3);
        addStringValue("Choisir une Image :",  getStarted );

        
               getStarted.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        path = (String) ev.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        image.setText(path.substring(7));
//image heya just label nsob feha fel path
System.out.println(image);
                        try {
                            Util.copy(FileSystemStorage.getInstance().openInputStream(path), Storage.getInstance().createOutputStream("myImageFileName.png"));

                            Image img1 = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img1);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });
        
        
        
        
         Button AJOUTER = new Button("ajouter");
        addStringValue("",  AJOUTER );
        
        
        
        AJOUTER.addActionListener((e) -> {
            int a = 2;
            if(Nom.getText()=="") {
             Dialog.show("", "Nom est un champs ", "Ok", null); 
            
            }
            else if (image.getText()!= "a") {
                            try {
                                ServiceObjet ser = new ServiceObjet();
                                Objet t = new Objet();
                                System.out.println("owel el add");
                                FileUploader fc = new FileUploader("localhost/PiE404vf/web/images/");
                                System.out.println("owel el try");
                                String f = fc.upload(image.getText());
                                System.out.println(image.getText());;
                                
                                
                                
                                System.out.println("ba3d el upload");
                                t.setNom_objet(Nom.getText());
                                t.setCategorie(categorie.getSelectedItem().toString());
                                t.setLieu(Lieu1234.getSelectedItem().toString());
                                t.setDescription(Description.getText());
                                t.setImg(f);
                                ser.ajoutObjet(t);
                                
                                
                                try {
                                    new MesOP(res).show();
                                } catch (IOException ex) {
                                }
                                
                            } catch (Exception ex) {
            }

            } 
        
            else{     
                                ServiceObjet ser = new ServiceObjet();
                                Objet t = new Objet();
                          
                                t.setNom_objet(Nom.getText());
                                t.setCategorie(categorie.getSelectedItem().toString());
                                t.setLieu(Lieu1234.getSelectedItem().toString());
                                t.setDescription(Description.getText());
                                t.setImg("pasim.png");
                                ser.ajoutObjet(t);
                                
                                
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
