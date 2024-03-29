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
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
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
import com.esprit.EspritEntreAide.Service.ServiceRObjet;
import java.io.IOException;




/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ObjetsForm1 extends BaseForm {

    public ObjetsForm1 (Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Objets Perdus");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
          ServiceRObjet v
                            = new ServiceRObjet();
        
      if (v.getList4()==0) {
         
        
                                    Dialog.show("", "Mail Vous avez des Messages non lu", "Ok", null);}
 
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 5) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 5);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label();
        facebook.setTextPosition(BOTTOM);

        add(LayeredLayout.encloseIn(
                sl,

                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            
                            FlowLayout.encloseCenter(
                                new Label())
                    )
                )
        ));

        Button ajouter = new Button("Ajouter un objet perdu");
        addStringValue("", ajouter);
        ajouter.addActionListener(e->  {new AjouterOP(res).show();});

          Button MesOP = new Button("Mes Objets Perdus");
        addStringValue("", MesOP);
                        MesOP.addActionListener(e -> {
            try {
                new MesOP(res).show();
            } catch (IOException ex) {
            }
        });

        
           Button LesOP = new Button("Les Objets Perdus");
        addStringValue("", LesOP);
            LesOP.addActionListener(e -> {
            try {
                new LesOP(res).show();
            } catch (IOException ex) {
            }
        });
      
        Button LesOPM = new Button("Messages");
        addStringValue("", LesOPM);
                LesOPM.addActionListener(e ->{ try {
                    ServiceRObjet a
                            = new ServiceRObjet();
                    new MesMesOP (res).show();
            } catch (IOException ex) {
                
            }
                });

      
      

    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
