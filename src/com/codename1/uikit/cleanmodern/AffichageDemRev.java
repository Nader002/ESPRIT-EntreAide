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
import static com.codename1.uikit.cleanmodern.Affichage.titrecherche;
import com.esprit.EspritEntreAid.entities.DemandeRevision;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.esprit.EspritEntreAide.Service.DemRevService;
import com.esprit.EspritEntreAide.Service.OffreRevService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.net.URISyntaxException;
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
public class AffichageDemRev extends BaseForm {

    private final static String ACCOUNT_SID = "AC24b35864b1965dc69264083ffdce6d9c";
    private final static String AUTH_TOKEN = "5a759d54e1925d7dee1d1b8b4950ab25";

    public static Form f, form;
    public static SpanLabel lb;
    public static String url = "https://t3.ftcdn.net/jpg/00/58/08/04/240_F_58080418_DLFVsRoE7VWk5SIf6QsYQipnEQYmkL2o.jpg";
    public static Button btnAnnuler, suppbtn, modifbtn, btnchercher, partagerbtn, archivebtn, participerbtn;
    public static TextField titrecherche;

    public AffichageDemRev(Resources res) {
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

        titrecherche = new TextField();
        titrecherche.setUIID("TextFieldBlack");
        titrecherche.setHint("titre");
        btnchercher = new Button("chercher");
        add(titrecherche);
        add(btnchercher);
        DemRevService SP = new DemRevService();
                    btnAnnuler = new Button("Annuler");

        btnchercher.addActionListener((e) -> {
            Form F2 = new Form(BoxLayout.y());
            String d = titrecherche.getText();
            ArrayList<DemandeRevision> liche = SP.ChercherDemande(d);
            for (DemandeRevision lis : liche) {
                ImageViewer imgV = new ImageViewer();
                Image placeholder = Image.createImage(180, 150);
                EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
                URLImage urlim = URLImage.createToStorage(enc, url, url);
                imgV.setImage(urlim);
                System.out.println();
                System.out.println(url);
                Label aa = new Label("Matiere   :   " + lis.getMatiere());
                Label nbpl = new Label("Niveau   :   " + lis.getNiveau());
                F2.add(aa);
                //F2.add(datee);
                //F2.add(prixx);
                F2.add(nbpl);
                F2.add(imgV);
//                F2.getToolbar().addCommandToLeftBar("back", null, (j) -> {
////                    Affichage h = new Affichage(res);
////                    h.getF().show();
//
//                });
partagerbtn.addActionListener((f) -> {
                        try {
                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            
                            String from = "+13176890809";
                            String to = "+21692113848";
                            
                            Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                                    new URI("http://demo.twilio.com/docs/voice.xml")).create();
                            
                            System.out.println(call.getSid());
//                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//                            Message message = Message.creator(
//                                    new PhoneNumber("+21692113848"), // To number
//                                    new PhoneNumber("+13176890809"), // From number
//                                    nom + " " + prenom + " a reserve votre offre de revision. Vous pouvez lui contacter:\ntel: "
//                                            + "58 938 246" + "\nmail: " + mail // SMS body
//                            ).create();
//                            System.out.println(message.getSid());
                        } catch (URISyntaxException ex) {
                        }

                    });
                                    F2.add(btnAnnuler);
                btnAnnuler.addActionListener((f) -> {
            AffichageDemRev a = new AffichageDemRev(res);
            a.show();
        });
                F2.show();

            }

        });

        // f.add(lb);
        ArrayList<DemandeRevision> lis = SP.getList2();
        f = new Form(BoxLayout.y());
        for (DemandeRevision li : lis) {

            System.out.println("owel el for");
            Label aa = new Label("Matiere  : " + li.getMatiere());
            Label desc = new Label("Niveau : " + li.getNiveau());

            Container cc = new Container(BoxLayout.x());
            Container c = new Container(BoxLayout.y());
//            suppbtn = new Button("Supprimer");
//            modifbtn = new Button("Modifier");
            partagerbtn = new Button("Appeler");
            btnAnnuler = new Button("Annuler");

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
//            c.add(aa2);
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
                Label Title = new Label("Les details de la demande");

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

                String url = "http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/findDemandeRev/" + li.getId();
                con.setUrl(url);

                con.addResponseListener((le) -> {
//                 form.getToolbar().addCommandToLeftBar("back", null, (ev)-> new HomeForm().HomeForm(res).show());

                    String reponse = new String(con.getResponseData());
                    System.out.println(reponse);
                    lbser.setText("Matiere   :   " + li.getMatiere());
                    lbser0.setText("Niveau   :   " + li.getNiveau());
                    lbser1.setText("Description  :  " + li.getDescription());
//                    participerbtn.addActionListener((e) -> {
//                        OffreRevService ser = new OffreRevService();
//                        ser.reserverRevOffre(li.getId());
//                        MesOffresRev a = new MesOffresRev(res);
//                        a.show();
//                        Dialog.show("Succés", "Offre reservée", "ok", null);
//                    });
//                    modifbtn.addActionListener((e) -> {
//                        ModifForm h = new ModifForm(li, res);
//                        h.getF().show();
//
//                    });

                    partagerbtn.addActionListener((e) -> {
                        try {
                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            
                            String from = "+13176890809";
                            String to = "+21692113848";
                            
                            Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                                    new URI("http://demo.twilio.com/docs/voice.xml")).create();
                            
                            System.out.println(call.getSid());
//                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//                            Message message = Message.creator(
//                                    new PhoneNumber("+21692113848"), // To number
//                                    new PhoneNumber("+13176890809"), // From number
//                                    nom + " " + prenom + " a reserve votre offre de revision. Vous pouvez lui contacter:\ntel: "
//                                            + "58 938 246" + "\nmail: " + mail // SMS body
//                            ).create();
//                            System.out.println(message.getSid());
                        } catch (URISyntaxException ex) {
                        }

                    });
                    
//                    F3.add(suppbtn);
//                    F3.add(modifbtn);
                    F3.add(partagerbtn);
                                    F3.add(btnAnnuler);
                btnAnnuler.addActionListener((f) -> {
            AffichageDemRev a = new AffichageDemRev(res);
            a.show();
        });
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
