package com.codename1.uikit.cleanmodern;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import static com.codename1.uikit.cleanmodern.Affichage.btnAnnuler;
import static com.codename1.uikit.cleanmodern.Affichage.titrecherche;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.FacebookShare;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahri
 */
public class MesOffresRev extends BaseForm {

    public static Form f, form;
    public static SpanLabel lb;
    public static String url = "http://www.ducat-loc.fr/img/bonhomme%20r%C3%A8gle%20seul.png";
    public static Button annuler, suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn;
    public static TextField titrecherche;

    public MesOffresRev(Resources res) {
        // theme = UIManager.initFirstTheme("/theme_1");
//       
        super("Newsfeed", BoxLayout.y());
//        UIBuilder ui = new UIBuilder(); 
//        Container ct1 = ui.createContainer(res, "Filtrage");
//         Form f= (Form)ct1;
        //f = new Form(BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Mes Offres de Revision");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        tb.addSearchCommand(e -> {
        });

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
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
                                facebook,
                                FlowLayout.encloseCenter(
                                        new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                                twitter
                        )
                )
        ));

        lb = new SpanLabel("");
//        archivebtn = new Button("Archive des Evenements");

//        archivebtn.addActionListener((e) -> {
//            Archive a = new Archive(res);
//            a.getF().show();
//        });
//        add(archivebtn);
        titrecherche = new TextField();
        titrecherche.setUIID("TextFieldBlack");
        titrecherche.setHint("titre");
        btnchercher = new Button("chercher");
//        add(titrecherche);
//        add(btnchercher);
        OffreRevService SP = new OffreRevService();
        btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.y());
            String d = titrecherche.getText();
//            
        });

        // f.add(lb);
        ArrayList<OffreRevision> lis = SP.getListmesoffrerev();
        f = new Form(BoxLayout.y());
        for (OffreRevision li : lis) {

            System.out.println("owel el for");
            Label aa = new Label("Matiere  : " + li.getMatiere());
            Label date = new Label("Date   :  " + li.getDate());
            Label aa2 = new Label("Lieu  : " + li.getLieu());
            Label desc = new Label("Niveau : " + li.getNiveau());

            Container cc = new Container(BoxLayout.x());
            Container c = new Container(BoxLayout.y());
            suppbtn = new Button("Supprimer");
            modifbtn = new Button("Modifier");
            partagerbtn = new Button("Partager");
            annuler=new Button("Retour");

//            participerbtn = new Button("Réserver");

            Image placeholder = Image.createImage(300, 200);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, li.getImage(), url);
            System.out.println(url + "/" + li.getImage());
            System.out.println(urlim);
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
//            // TextField a = new TextField(li.getId());

            //Label d = new Label(li.getDate().toString());
            //c.add(a);
            c.add(aa);
            //c.add(date);
            c.add(aa2);
            c.add(desc);
            //c.add(d);
            //cc.add(imgV);
            //cc.add(c);
            c.add(imgV);
            //f.add(c);
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            add(c);
            //f.show();
            aa.addPointerPressedListener((l) -> {

                form = new Form(BoxLayout.y());
                Label lbser = new Label();
                Label lbser0 = new Label();
                Label lbser1 = new Label();
                Label lbser2 = new Label();
                Label lbser3 = new Label();
                Label lbser4 = new Label();
                Label Title = new Label("Les details de l'offre");

                Container F3 = new Container(BoxLayout.y());
                F3.add(Title);

                F3.add(lbser);
                F3.add(lbser0);
                F3.add(lbser1);
                F3.add(lbser2);
                F3.add(lbser3);
                F3.add(lbser4);

                System.out.println("imaage");

                EncodedImage en = EncodedImage.createFromImage(placeholder, false);
                URLImage urli = URLImage.createToStorage(en, url, url);
                ImageViewer img1 = new ImageViewer();
                img1.setImage(urli);

                F3.add(img1);

                ConnectionRequest con = new ConnectionRequest();
                ConnectionRequest con2 = new ConnectionRequest();

                String url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/findOffreRev/" + li.getId();
                con.setUrl(url);
                System.out.println("test supp" + li.getId());
                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                    lbser.setText("Matiere   :   " + li.getMatiere());
                    lbser0.setText("Niveau   :   " + li.getNiveau());
                    lbser1.setText("Description  :  " + li.getDescription());
                    lbser2.setText("Lieu  :   " + li.getLieu());
                    lbser3.setText("Date  :   " + li.getDate());
                    lbser4.setText("Nombre des étudiants  :   " + li.getNbreEtudiant());
                    suppbtn.addActionListener((e) -> {
                        OffreRevService ser = new OffreRevService();
                        ser.SuppRevOffre(li.getId(), res);
                    });
                    modifbtn.addActionListener((e) -> {
                        ModifOffreRevForm h = new ModifOffreRevForm(li, res);
                        h.show();

                    });
                    partagerbtn.addActionListener((e) -> {
                        System.out.println("9bal l partage");
                        try {
                            FacebookShare fb = new FacebookShare("EAACEdEose0cBABzR5DfB5Ex3GtBvE6PBmd0CczYjOXsqoeabvQZBTbJsdtn3rbwAMZBXPBCZBcCR4JgzB1JYWjHy3sdgQp2zsrMWmH137WNzMtOnjpAp87XdZCdFBHEKQhArpV8TuoFk12ImSRFCHO8SHVw3BiUSvMYEEfbdx940eP1EiebPSiFGL09q2UgZD");
                            fb.share("API partage temchiiiiii :D "+li.getDescription());
                            System.out.println("ba3d l partage");
//                        OffreRevService ser = new OffreRevService();
//                      String filePath = (String) li.getImage();
//                       int fileNameIndex = filePath.lastIndexOf("/") + 1;
//                     String fileName = filePath.substring(fileNameIndex);
//                     try {
//                         ser.shareImageOnFacebook(filePath,li.getTitre(),li.getDescription());
//                     } catch (IOException ex) {
//                     }
                        } catch (IOException ex) {
                        }

                    });
                    annuler.addActionListener((f) -> {
                        MesOffresRev a = new MesOffresRev(res);
                        a.show();
                    });
                    F3.add(suppbtn);
                    F3.add(modifbtn);
                    F3.add(partagerbtn);
                    F3.add(annuler);
//                    F3.add(participerbtn);
//                     Menu_Revision ft = new Menu_Revision();
//                     ft.getF().show();
//
                });

                NetworkManager.getInstance().addToQueueAndWait(con);

                System.out.println("test el F3");
//                add(F3);
                // f.add(F3);
                form.add(F3);
                form.show();
                //  f.add(lbser);
            });
            c.setLeadComponent(aa);

            //           
            System.out.println("test ba3d a");
//             F3.show();

        }
        lb.setText(lis.toString());
        /**
         * **********************************************
         *//*          f.getToolbar().addCommandToLeftBar("back", null, (ev)->{HomeForm h=new HomeForm(res);
          h.getF().show(); ********************************* });********************/

        //f.show();
//        return f;

        //f.show();
    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
