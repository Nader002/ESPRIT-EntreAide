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
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAid.entities.User;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import com.esprit.EspritEntreAide.Service.UserService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
public class Affichage extends BaseForm {

    private final static String ACCOUNT_SID = "AC24b35864b1965dc69264083ffdce6d9c";
    private final static String AUTH_TOKEN = "5a759d54e1925d7dee1d1b8b4950ab25";

    public static Form f, form;
    public static SpanLabel lb;
    public static String url = "http://www.ducat-loc.fr/img/bonhomme%20r%C3%A8gle%20seul.png";
    public static Button btnAnnuler,suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn;
    public static TextField titrecherche;


    public Affichage(Resources res) {
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
        setTitle("Les Offres de Revision");
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
/*
        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
*/
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(1,
                                
                                FlowLayout.encloseCenter(
                                        new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond"))
                                
                        )
                )
        ));

        lb = new SpanLabel("");

        titrecherche = new TextField();
        titrecherche.setUIID("TextFieldBlack");

        titrecherche.setHint("titre");
        btnchercher = new Button("chercher");
        add(titrecherche);
        add(btnchercher);
        btnAnnuler=new Button("Retour");

        OffreRevService SP = new OffreRevService();
        btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.y());
            
            String d = titrecherche.getText();
            ArrayList<OffreRevision> liche = SP.ChercherOffre(d);
            for (OffreRevision lis : liche) {
                ImageViewer imgV = new ImageViewer();
                Image placeholder = Image.createImage(180, 150);
                EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
                URLImage urlim = URLImage.createToStorage(enc, url, url);
                imgV.setImage(urlim);
                System.out.println();
                System.out.println(url);
                Label aa = new Label("Matiere   :   " + lis.getMatiere());
                Label nbpl = new Label("Niveau   :   " + lis.getNiveau());
                Label date = new Label("Date   :  " + lis.getDate());
                Label lieu = new Label("Lieu  : " + lis.getLieu());
                Label desc = new Label("Description   :   " + lis.getDescription());
                Label nb = new Label("Nombre des étudiants   :   " + lis.getNbreEtudiant());
                // Label prixx = new Label("Prix :" + lis.getPrix());

//                Label datee = new Label("Date :" + lis.getDate());
                F2.add(imgV);
                F2.add(aa);
                //F2.add(datee);
                //F2.add(prixx);
                F2.add(nbpl);
                F2.add(date);
                F2.add(lieu);
                F2.add(desc);
                F2.add(nb);
                F2.add(btnAnnuler);
                btnAnnuler.addActionListener((f) -> {
            Affichage a = new Affichage(res);
            a.show();
        });
//                F2.getToolbar().addCommandToLeftBar("back", null, (j) -> {
////                    Affichage h = new Affichage(res);
////                    h.getF().show();
//
//                });
                F2.show();

            }

        });

        // f.add(lb);
        ArrayList<OffreRevision> lis = SP.getList2();
        f = new Form(BoxLayout.y());
        for (OffreRevision li : lis) {

            System.out.println("owel el for");
            Label aa = new Label("Matiere  : " + li.getMatiere());
            Label date = new Label("Date   :  " + li.getDate());
            Label aa2 = new Label("Lieu  : " + li.getLieu());
            Label desc = new Label("Niveau : " + li.getNiveau());

            Container cc = new Container(BoxLayout.x());
            Container c = new Container(BoxLayout.y());
//            suppbtn = new Button("Supprimer");
//            modifbtn = new Button("Modifier");
            partagerbtn = new Button("Partager");
            participerbtn = new Button("Réserver");

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

                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
//                    System.out.println("idUser: " + li.getIdUser());
                    lbser.setText("Matiere   :   " + li.getMatiere());
                    lbser0.setText("Niveau   :   " + li.getNiveau());
                    lbser1.setText("Description  :  " + li.getDescription());
                    lbser2.setText("Lieu  :   " + li.getLieu());
                    lbser3.setText("Date  :   " + li.getDate());
                    lbser4.setText("Nombre des étudiants  :   " + li.getNbreEtudiant());

                    String nom = SignInForm.connectedUser.getNom();
                    System.out.println("test nom " + nom);
                    String prenom = SignInForm.connectedUser.getPrenom();
                    System.out.println("test prenom " + prenom);
                    String mail = SignInForm.connectedUser.getEmail();
                    System.out.println("test mail " + mail);
                    String tel = SignInForm.connectedUser.getTel();
                    System.out.println("test tel: " + tel);
                    participerbtn.addActionListener((e) -> {
                        OffreRevService ser = new OffreRevService();
                        ser.reserverRevOffre(li.getId());
//                        int numTel = (long) Integer.parseInt(SignInForm.getUserById(1).getTel());
//                        System.out.println("test numTel: " + numTel);
                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                        Message message = Message.creator(
                                new PhoneNumber("+21692113848" ), // To number
                                new PhoneNumber("+13176890809"), // From number
                                nom + " " + prenom + " a reserve votre offre de revision. Vous pouvez lui contacter:\ntel: "
                                + "58 938 246" + "\nmail: " + mail // SMS body
                        ).create();
                        System.out.println(message.getSid());
                        MesOffresRev a = new MesOffresRev(res);
                        a.show();
                        Dialog.show("Succés", "Offre reservée et msg envoyé", "ok", null);
                    });
                btnAnnuler.addActionListener((f) -> {
            Affichage a = new Affichage(res);
            a.show();
        });
//                    modifbtn.addActionListener((e) -> {
//                        ModifForm h = new ModifForm(li, res);
//                        h.getF().show();
//
//                    });

//                    F3.add(suppbtn);
//                    F3.add(modifbtn);
//                    F3.add(partagerbtn);
                    F3.add(participerbtn);
                    F3.add(btnAnnuler);
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
