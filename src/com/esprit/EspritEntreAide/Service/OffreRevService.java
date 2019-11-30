/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.Service;

import com.esprit.EspritEntreAid.entities.OffreRevision;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.Format;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.Affichage;
import com.codename1.uikit.cleanmodern.MesOffresRev;
import com.codename1.uikit.cleanmodern.MesReservationRev;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahri
 */
public class OffreRevService {

    //test StackoverFlow
    public static String convertDateFormat(String fromDate) {

        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        Date d = null;
        try {
            d = df.parse(fromDate);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(d));

        return df.format(d);
    }

//    public ArrayList<OffreRevision> getListRevoffre(String json) {
//
//        ArrayList<OffreRevision> listrev = new ArrayList<>();
//
//        try {
//            System.out.println(json);
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> revs = j.parseJSON(new CharArrayReader(json.toCharArray()));
//            System.out.println(revs);
//
//            List<Map<String, Object>> list = (List<Map<String, Object>>) revs.get("root");
//
//            for (Map<String, Object> obj : list) {
//                OffreRevision e = new OffreRevision();
//
//                // System.out.println(obj.get("id"));
//                float id = Float.parseFloat(obj.get("id").toString());
//                int idUser = Integer.parseInt(obj.get("idUser").toString());
//                int heure = Integer.parseInt(obj.get("heure").toString());
//                int nbreEtudiant = Integer.parseInt(obj.get("nbreEtudiant").toString());
//
//                //////
//                String date_temp = obj.get("date").toString();
//                String z = date_temp.substring(112, 123);
////                 
////                String DATE_FORMAT = "yyyy/MM/dd";
////                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
////                String s = sdf.format(z);  
////                System.out.println(s);
//
//                String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date((long) (1.5282432E9 * 1000L)));
//
//                ///////
//                e.setId((int) id);
//                e.setIdUser((int) idUser);
//                e.setNiveau(obj.get("niveau").toString());
//                e.setImage(obj.get("image").toString());
//                e.setMatiere(obj.get("matiere").toString());
//                e.setDescription(obj.get("description").toString());
//                e.setDate(date);
//                e.setHeure((int) heure);
//                e.setLieu(obj.get("lieu").toString());
//                e.setNbreEtudiant((int) nbreEtudiant);
//
//                listrev.add(e);
//
//            }
//
//        } catch (IOException ex) {
//        }
//        System.out.println(listrev);
//        return listrev;
//
//    }
    ArrayList<OffreRevision> listrev = new ArrayList<>();

//    public ArrayList<OffreRevision> getListoffreRev() {
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/buckupAhlem%2006-04/pie404/web/app_dev.php/offrerevision/Mobile/allOffreRev");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                OffreRevService ser = new OffreRevService();
//                listrev = ser.getListRevoffre(new String(con.getResponseData()));
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listrev;
//    }
    public ArrayList<OffreRevision> getList2() {
        ArrayList<OffreRevision> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/allOffreRev/" + SignInForm.connectedUser.getId_user());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        OffreRevision task = new OffreRevision();
                        task.setId((int) Float.parseFloat(obj.get("id").toString()));
//                        System.out.println("test idUser"+Integer.parseInt(obj.get("idUser").toString()));
                        task.setMatiere(obj.get("matiere").toString());
                        task.setNiveau(obj.get("niveau").toString());
//
//                        String DateS = obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10, obj.get("date").toString().indexOf("timestamp") + 21);
//                        Date currentTime = new Date(Double.valueOf(DateS).longValue() * 1000);
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        dateString = formatter.format(currentTime);
////                        System.out.println(dateString);
////////////DateNader
//
//                String date_temp =  obj.get("date").toString();
//                String z= date_temp.substring(135, 142);
//                System.out.println("zzzzz="+z);
//                Long n = Long.parseLong(z);
//                n=n*100+1000000000;
//                System.out.println(n+"hope");
//                String date_final = new SimpleDateFormat("dd/MM/yyyy").format(new Date((long) (n * 1000L)));
                task.setDate(obj.get("date").toString());
                        System.out.println(obj.get("date")+"aaaaa tostring");

//////////////////////////////////////////
/////////////////myDate
//                        System.out.println("test date avant conv" + obj.get("date").toString());
//                        String d = convertDateFormat(obj.get("date").toString());
//                        task.setDate(d);
//////////////////
//Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//String s = formatter.format(d);

//                        task.setDate(dateString);
                        //task.setLieu(obj.get("lieu").toString());
//                        task.setDate(s);
//                        System.out.println("test date string" + dateString);
                        task.setNbreEtudiant((int) Float.parseFloat(obj.get("nbreEtudiant").toString()));

                        task.setLieu(obj.get("lieu").toString());
                        task.setDescription(obj.get("description").toString());
                        task.setImage(obj.get("image").toString());
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    public static String dateString;

    public String getDateS() {
        return dateString;
    }

    public void ajoutRevOffre(OffreRevision rev) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/newOffreRev?"
                + "id=" + SignInForm.connectedUser.getId_user()
                + "&niveau=" + rev.getNiveau()
                + "&image=" + rev.getImage()
                + "&matiere=" + rev.getMatiere()
                + "&date="+rev.getDate()
                + "&lieu=" + rev.getLieu()
                + "&nbreEtudiant=" + rev.getNbreEtudiant()
                + "&description=" + rev.getDescription();
//                + "&heure="+rev.getHeure();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<OffreRevision> getListmesoffrerev() {
        ArrayList<OffreRevision> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/mesOffreRev/" + SignInForm.connectedUser.getId_user());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        OffreRevision task = new OffreRevision();
                        task.setId((int) Float.parseFloat(obj.get("id").toString()));
                        task.setMatiere(obj.get("matiere").toString());
                        task.setNiveau(obj.get("niveau").toString());
//
//                        String DateS = obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10, obj.get("date").toString().indexOf("timestamp") + 21);
//                        Date currentTime = new Date(Double.valueOf(DateS).longValue() * 1000);
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        dateString = formatter.format(currentTime);
////                        System.out.println(dateString);
////
//                        System.out.println("test date avant conv" + obj.get("date").toString());
//                        String d = convertDateFormat(obj.get("date").toString());
//Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//String s = formatter.format(d);
                        task.setDate(obj.get("date").toString());

//                        task.setDate(dateString);
                        //task.setLieu(obj.get("lieu").toString());
//                        task.setDate(s);
//                        System.out.println("test date string" + dateString);
                        task.setNbreEtudiant((int) Float.parseFloat(obj.get("nbreEtudiant").toString()));

                        task.setLieu(obj.get("lieu").toString());
                        task.setDescription(obj.get("description").toString());
                        task.setImage(obj.get("image").toString());
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    public void SuppRevOffre(int id, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/DelOffreRev/" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            Dialog.show("Succés", "offre supprimée", "ok", null);

            MesOffresRev c = new MesOffresRev(res);
            c.show();
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void modifierOffreRev(OffreRevision rev, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/updateOffreRev?"
                + "id=" + rev.getId()
                + "&niveau=" + rev.getNiveau()
                //                + "&image=" + rev.getImage()
                + "&matiere=" + rev.getMatiere()
                + "&lieu=" + rev.getLieu()
                + "&nbreEtudiant=" + rev.getNbreEtudiant()
                + "&description=" + rev.getDescription();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "offre modifiée", "ok", null);

            MesOffresRev a = new MesOffresRev(res);
            a.show();

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<OffreRevision> ChercherOffre(String s) {
        ArrayList<OffreRevision> listOffreRevision = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/chercherOffreRev/" + s);
        con.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    OffreRevision task = new OffreRevision();

                    task.setId((int) Float.parseFloat(obj.get("id").toString()));
                    task.setMatiere(obj.get("matiere").toString());
                    task.setNiveau(obj.get("niveau").toString());

                    System.out.println("test date avant conv" + obj.get("date").toString());
                    String d = convertDateFormat(obj.get("date").toString());

                    task.setDate(d);
                    task.setNbreEtudiant((int) Float.parseFloat(obj.get("nbreEtudiant").toString()));

                    task.setLieu(obj.get("lieu").toString());
                    task.setDescription(obj.get("description").toString());
                    task.setImage(obj.get("image").toString());
                    listOffreRevision.add(task);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffreRevision;
    }

    public void reserverRevOffre(int idOffre) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/reserverOffreRev?"
                + "id=" + SignInForm.connectedUser.getId_user()
                + "&idOffre=" +idOffre;
//                + "&heure="+rev.getHeure();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    public ArrayList<OffreRevision> getListmesReservationsrev() {
        ArrayList<OffreRevision> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/mesReservationsRev/" + SignInForm.connectedUser.getId_user());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        OffreRevision task = new OffreRevision();
                        task.setId((int) Float.parseFloat(obj.get("id").toString()));
                        task.setMatiere(obj.get("matiere").toString());
                        task.setNiveau(obj.get("niveau").toString());
//
//                        String DateS = obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10, obj.get("date").toString().indexOf("timestamp") + 21);
//                        Date currentTime = new Date(Double.valueOf(DateS).longValue() * 1000);
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        dateString = formatter.format(currentTime);
////                        System.out.println(dateString);
//
                        System.out.println("test date avant conv" + obj.get("date").toString());
                        String d = convertDateFormat(obj.get("date").toString());
//Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//String s = formatter.format(d);
                        task.setDate(d);

//                        task.setDate(dateString);
                        //task.setLieu(obj.get("lieu").toString());
//                        task.setDate(s);
//                        System.out.println("test date string" + dateString);
                        task.setNbreEtudiant((int) Float.parseFloat(obj.get("nbreEtudiant").toString()));

                        task.setLieu(obj.get("lieu").toString());
                        task.setDescription(obj.get("description").toString());
                        task.setImage(obj.get("image").toString());
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
        public void SuppResRev(int id, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/offrerevision/Mobile/DelResRev/" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            Dialog.show("Succés", "reservation annulée", "ok", null);

            MesReservationRev c = new MesReservationRev(res);
            c.show();
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
