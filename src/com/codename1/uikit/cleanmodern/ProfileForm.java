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

package com.codename1.uikit.cleanmodern;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
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
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import com.esprit.EspritEntreAide.Service.ServiceCov;
import com.esprit.EspritEntreAide.gui.Affiche_cov_offre;
import java.util.ArrayList;
import java.util.List;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProfileForm extends BaseForm {

    
    
    Form f = new Form("List des demandes",BoxLayout.y());
    SpanLabel lb;
    private Button offres;
   
    private ImageViewer img;

  
    
    public Container addItem(Covoiturage e)
    {     
          Resources theme = UIManager.initFirstTheme("/theme");
          Container cnt1=new Container(BoxLayout.y());
          Container cnt2=new Container(BoxLayout.x());
          img=new ImageViewer();
          img.setImage(theme.getImage("images.png"));
          cnt2.add(img);
          Label lbhd=new Label(String.valueOf(e.getHeure_depart()));
          Label lbmd=new Label(String.valueOf(e.getMinute_depart()));
          Label lbva=new Label(e.getVille_arrive());
          Label lbaa=new Label(e.getAdr_arrive());
          Label lbvd=new Label(e.getVille_depart());
          Label lbad=new Label(e.getAdr_depart());
          Label lbdesiption=new Label(e.getDescription());
          cnt1.add(lbhd);
          cnt1.add(lbmd);
          cnt1.add(lbvd);
          cnt1.add(lbad);
          cnt1.add(lbva);
          cnt1.add(lbaa);
          cnt1.add(lbdesiption);
          cnt1.add("-------");
          cnt2.add(cnt1);
          return cnt2;
    }
    
    
    
    
//
//    public Affiche_cov_demande() {
//        
//          ServiceCov servicecov=new ServiceCov();
//          f.getToolbar().addCommandToRightBar("Retour", null, (ev)->{Affiche_cov_offre h=new Affiche_cov_offre();
//          h.getF().show();
//          });
//          List<Covoiturage> listcovs=new ArrayList<>();
//          listcovs=servicecov.getListdemandecov();
//           for(Covoiturage c: listcovs){
//               f.add(addItem(c));
//          }
//          f.show();
//        
//        
//        
//        
//    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
    public ProfileForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
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
        Button n = new Button();
        add(LayeredLayout.encloseIn(sl));
        
         ServiceCov servicecov=new ServiceCov();
//          f.getToolbar().addCommandToRightBar("Retour", null, (ev)->{Affiche_cov_offre h=new Affiche_cov_offre();
//          h.getF().show();
//          });
          List<Covoiturage> listcovs=new ArrayList<>();
          listcovs=servicecov.getListdemandecov();
           for(Covoiturage c: listcovs){
               add(addItem(c));
          }
          
        

    }
    
 
}
