package com.esprit.EspritEntreAide.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codename1.io.FileSystemStorage;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.esprit.EspritEntreAid.entities.Colocation;
import com.esprit.EspritEntreAide.Service.ServiceColocation;

import java.io.IOException;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author ryhab
 */
public class AjoutColOffre {

    String Imagecode = null;
    String path;
//     Form f;
//    TextField tprix;
//    TextField tnbdispo;
//    TextField desc;
//    Button btnajout,btnaff;
//
//    
//        public AjoutColOffre() {
//        f = new Form("Ajout");
//        f.add(tprix);
//        f.add(tnbdispo);
//        f.add(desc);
//        f.add(btnajout);
//        f.add(btnaff);
//        btnajout.addActionListener((e) -> {
//            ServiceColocation ser = new ServiceColocation();
//           // Task t = new Task(0, tnom.getText(), tetat.getText());
//           Colocation c = new Colocation(2, Integer.parseInt(tprix.getText()),desc.getText(), Integer.parseInt(tnbdispo.getText()) , "hh");
//            ser.ajoutTask(c);
//            
//
//        });
////        btnaff.addActionListener((e)->{
////        Affichage a=new Affichage();
////        a.getF().show();
////        });
//    }
//
//    public Form getF() {
//        return f;
//    }
//
//    public void setF(Form f) {
//        this.f = f;
//    }
//
//    public TextField getTprix() {
//        return tprix;
//    }
//
//    public void setTprix(TextField tprix) {
//        this.tprix = tprix;
//    }
//
//    public TextField getTnbdispo() {
//        return tnbdispo;
//    }
//
//    public void setTnbdispo(TextField tnbdispo) {
//        this.tnbdispo = tnbdispo;
//    }
//
//    public TextField getDesc() {
//        return desc;
//    }
//
//    public void setDesc(TextField desc) {
//        this.desc = desc;
//    }
//
//    public Button getBtnajout() {
//        return btnajout;
//    }
//
//    public void setBtnajout(Button btnajout) {
//        this.btnajout = btnajout;
//    }
//
//    public Button getBtnaff() {
//        return btnaff;
//    }
//
//    public void setBtnaff(Button btnaff) {
//        this.btnaff = btnaff;
//    }
    Form f;
    // TextField tnom;
    // TextField tetat;
    TextField tprix;
    TextField adress;
    TextField nb;
    TextField desc;
    Button btnajout, btnaff;

    public AjoutColOffre() {
        TextField image = new TextField("a");
        f = new Form("home");
        Label prix = new Label("Ajouter prix");
        tprix = new TextField();
        Label desc1 = new Label("Ajouter description");
        desc = new TextField();
        Label nbd = new Label("Nombres de chambre disponible");
        nb = new TextField();
        Label ad = new Label("Ajouter votre adresse");
        adress = new TextField();
        btnajout = new Button("ajouter");
        Button getStarted = new Button("Choisir une Image");
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

        f.add(prix);
        f.add(tprix);
        f.add(nbd);
        f.add(nb);
        f.add(ad);
        f.add(adress);
        f.add(desc1);
        f.add(desc);
        f.add(getStarted);

        f.add(btnajout);

        btnajout.addActionListener((e) -> {
             if(desc.getText()=="" ||adress.getText()=="" || tprix.getText()==""|| nb.getText()=="") {
             Dialog.show("", " champs Obligatoire", "Ok", null); 
             
            }
             else if(Integer.parseInt(tprix.getText())<=0||Integer.parseInt(nb.getText())<=0){
                 Dialog.show("", " Saisir un chiffre positif", "Ok", null); 
             }
            else if (image.getText()!= "a") {
            try {
                ServiceColocation ser = new ServiceColocation();
                FileUploader fc = new FileUploader("localhost/PiE404/web/images/");
                System.out.println("owel el try");
                String f = fc.upload(image.getText());
                System.out.println(image.getText());
                Colocation c = new Colocation(adress.getText(), Integer.parseInt(tprix.getText()), desc.getText(), Integer.parseInt(nb.getText()), f);
                ser.ajoutTask();
               
                    new AfficheMesCol().start();
                
            } catch (Exception ex) {
            }
            }else{
                Dialog.show("", " Veillez insérer une image", "Ok", null); 
            }
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

//    public TextField getTnom() {
//        return tnom;
//    }
//
//    public void setTnom(TextField tnom) {
//        this.tnom = tnom;
//    }
}
