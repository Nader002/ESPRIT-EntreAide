/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.EspritEntreAid.entities.Colocation;
import com.esprit.EspritEntreAide.Service.ServiceColocation;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ryhab
 */
public class AfficheMesCol {
    //        f = new Form();
//        lb = new SpanLabel("");
//        f.add(lb);
//        ServiceColocation s=new ServiceColocation();
//        s.test();
//        s.getList2();
//        
//    f.show();

   private Form current;
    private Resources theme;
    private String fileName;
    private String filePath;
    Container ctn2;
    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

       
        Toolbar.setGlobalToolbar(true);
    }
//        public Form getF() {
//        return f;
//    }
//
//    public void setF(Form f) {
//        this.f = f;
///    } 
    
    public void start() throws IOException {
     
        Form f = new Form("Mes Offres de Collocation");
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage ajouterIcon = FontImage.createMaterial(FontImage.MATERIAL_ADD, s);
        FontImage modifierIcon = FontImage.createMaterial(FontImage.MATERIAL_EDIT, s);
        FontImage afficherIcon = FontImage.createMaterial(FontImage.MATERIAL_DASHBOARD, s);
        FontImage exitIcon = FontImage.createMaterial(FontImage.MATERIAL_WARNING, s);
        Command cAjouter = new Command("Ajouter");
        //Command cModifier = new Command("Modifier / Supprimer");
        Command cAfficher = new Command("Afficher mes offres");
        Command cExit = new Command("Consulter les offres");
        f.getToolbar().addCommandToSideMenu(cAjouter);
       // f.getToolbar().addCommandToSideMenu(cModifier);
        f.getToolbar().addCommandToSideMenu(cAfficher);
        f.getToolbar().addCommandToSideMenu(cExit);

        f.addCommandListener(e->{
            if(e.getCommand()==cAjouter){
                new AjoutColOffre().getF().show();
           
            }
//            if(e.getCommand()==cModifier){
//                try {
//                    new editEvents().start();
//                } catch (IOException ex) {
//                }
//            }
            if(e.getCommand()==cAfficher){
                try {
                    new AfficheMesCol().start();
                } catch (IOException ex) {
                }
            }
            if(e.getCommand()==cExit){
                
             try {
                    new AfficheMesCol().start();
                } catch (IOException ex) {
                }
            
        
            }
        });
        ServiceColocation s1=new ServiceColocation();
      ArrayList<Colocation> productsList = s1.getList3();
              int mm = Display.getInstance().convertToPixels(3);
        final EncodedImage placeholder = EncodedImage.createFromImage(
        FontImage.createMaterial(FontImage.MATERIAL_SYNC, new Style()).
                scaled(300, 300), false);

        String[] listdesproduits = new String[productsList.size()];
        com.codename1.ui.List myList = new com.codename1.ui.List();
        for (int i = 0; i < productsList.size(); i++) {
        listdesproduits[i] = productsList.get(i).getImg1();
        }
  
        MyListModelEvent model = new MyListModelEvent(listdesproduits);
        int ii=0;
        
            
            
         ctn2 = new Container();
        for (Colocation p : productsList) {
             ctn2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            Image im = model.getItemAtt(ii, p.getImg1());
            ImageViewer v = new ImageViewer(im);
            ctn2.add(v);
            TextField id = new TextField(Integer.toString(p.getId_col()));
            System.out.println(Integer.toString(p.getId_col()));
            //*******************
//            ctn2.add(new Label("Titre :"+p.getTitre()));
//            ctn2.add(new Label("Description :" + p.getDescription()));
//            ctn2.add(new Label("Lieu :" +p.getLieu()));
//            System.out.println(ctn2.add(new Label("Type :"+p.getType()))) ;
//               ******************************************
            Button moreInfo = new Button("More");
           ctn2.add(moreInfo);
            f.addComponent(ctn2);
            ii++;
            System.out.println(p.getId_col()+"test");
             moreInfo.addActionListener(e -> {
                 Form Fmore=new Form("Details", BoxLayout.y());
                 Container co= new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    
                     co.add(new Label("Adresse :"+p.getAdress()));
                   co.add(new Label("Prix :"+p.getPrix()));
                    co.add(new Label("Chambres disponibles :"+p.getNbr_chdispo()));
                     co.add(new Label("Description :"+p.getDescription()));
         // co.add(new Label("Description :" + p.getDescription()));
        // co.add(new Label("Lieu :" +p.getLieu()));
          
          //new googleMaps().start();
          Button b =new Button("Supprimer");
          b.addActionListener(l->{
              System.out.println(p.getId_col());
              System.out.println(p.getDescription());
              s1.suppTask(p.getId_col());
             try {
                    new AfficheMesCol().start();
                } catch (IOException ex) {
                }
          });
          co.add(b);
          Fmore.add(co);
            Fmore.getToolbar().addCommandToRightBar("back", null, (ev)->{
                AfficheMesCol h=new AfficheMesCol();
                try {
               
          h.start();
           } catch (IOException ex) {
                }
          });
          Fmore.show();
                    //new showEvent(p.getId(),p.getType()).start();
                 
            });
             
             /*ShareButton sb = new ShareButton();
             sb.setTextToShare("lol");
             f.add(BorderLayout.CENTER, sb);*/
        }
        
        
        f.setScrollableX(false);
        
        f.show();
            
        
   
    }
    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

}
