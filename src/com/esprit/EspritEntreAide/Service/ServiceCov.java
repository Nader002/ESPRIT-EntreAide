/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.esprit.EspritEntreAid.entities.Covoiturage;
import com.esprit.EspritEntreAid.entities.Reservation;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author me
 */
public class ServiceCov {

    int user_nader = SignInForm.connectedUser.getId_user();
    
//bech traja3lek el list ta3 les offres
    public ArrayList<Covoiturage> getListCovoffre(String json) {

        ArrayList<Covoiturage> listcov = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> covs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(covs);

            List<Map<String, Object>> list = (List<Map<String, Object>>) covs.get("root");

            for (Map<String, Object> obj : list) {
                Covoiturage e = new Covoiturage();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("idCov").toString());
                float heureDepart = Float.parseFloat(obj.get("heureDepart").toString());
                float minuteDepart = Float.parseFloat(obj.get("minuteDepart").toString());
                float nbrPlaces = Float.parseFloat(obj.get("nbrPlaces").toString());
                float cotisation = Float.parseFloat(obj.get("cotisation").toString());
               
                String date_temp =  obj.get("dateDepart").toString();
                String z= date_temp.substring(114, 121);
                System.out.println(z);
                Long n = Long.parseLong(z);
                n=n*100+1000000000;
                System.out.println(n+"hope");
                String date_final = new SimpleDateFormat("MM/dd/yyyy").format(new Date((long) (n * 1000L)));
                e.setDate_depart(date_final);
                 
                e.setId_cov((int) id);
                e.setVille_arrive(obj.get("villeArrive").toString());
                e.setVille_depart(obj.get("villeDepart").toString());
                e.setAdr_depart(obj.get("adrDepart").toString());
                e.setAdr_arrive(obj.get("adrArrive").toString());
                e.setDescription(obj.get("description").toString());
                e.setHeure_depart((int) heureDepart);
                e.setMinute_depart((int) minuteDepart);
                e.setCotisation((int) cotisation);
                e.setNbr_places((int) nbrPlaces);
                System.out.println(e);
                System.out.println(e.getDate_depart());
                 System.out.println(e.getDate_depart());
                  System.out.println(e.getDate_depart());
                   System.out.println(e.getDate_depart());
                   
                listcov.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listcov);
        return listcov;

    }
    
    
    
    //bech traja3lek list feha les etas
    public ArrayList<Reservation> getListEtasReservation(String json) {

        ArrayList<Reservation> listcov = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> covs = j.parseJSON(new CharArrayReader(json.toCharArray()));
          
                
            System.out.println(covs);

          //  List<Map<String, Object>> list = (List<Map<String, Object>>) covs.get("root");

//            for (Map<String, Object> obj : list) {
                Reservation e = new Reservation();
                
                // thabet fi hal etas babi 5ater el respance mhich exact
                
                e.setEtas(covs.get("root").toString());
                System.out.println(e.getEtas());
                if(e.getEtas().equalsIgnoreCase("[fail]")){
                    e.setEtas("une seul reservation est permis");
                }
                else
                {
                    e.setEtas("resvation avec success");
                }
                listcov.add(e);

//            }

        } catch (IOException ex) {
        }
        System.out.println(listcov);
        System.out.println(listcov);
        return listcov;

    }
 
  
//bech traja3lek list ta3 les demande 3amlt 2 methode 5ater demande feha a9al atributs
    public ArrayList<Covoiturage> getListCovdemandes(String json) {

        ArrayList<Covoiturage> listcov = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> covs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(covs);

            List<Map<String, Object>> list = (List<Map<String, Object>>) covs.get("root");

            for (Map<String, Object> obj : list) {
                Covoiturage e = new Covoiturage();
                
                String date_temp =  obj.get("dateDepart").toString();
                String z= date_temp.substring(114, 121);
                System.out.println(z);
                Long n = Long.parseLong(z);
                n=n*100+1000000000;
                System.out.println(n+"hope");
                String date_final = new SimpleDateFormat("MM/dd/yyyy").format(new Date((long) (n * 1000L)));
                e.setDate_depart(date_final);
               

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("idCov").toString());
                float heureDepart = Float.parseFloat(obj.get("heureDepart").toString());
                float minuteDepart = Float.parseFloat(obj.get("minuteDepart").toString());
                e.setId_cov((int) id);
                e.setVille_arrive(obj.get("villeArrive").toString());
                e.setVille_depart(obj.get("villeDepart").toString());
                e.setAdr_depart(obj.get("adrDepart").toString());
                e.setAdr_arrive(obj.get("adrArrive").toString());
                e.setDescription(obj.get("description").toString());
                e.setHeure_depart((int) heureDepart);
                e.setMinute_depart((int) minuteDepart);
                System.out.println(e);
                listcov.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listcov);
        return listcov;

    }

    ArrayList<Covoiturage> listcov = new ArrayList<>();

    public ArrayList<Covoiturage> getListoffrecov() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/affichecovoffre?id_user=" + user_nader);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }

    public ArrayList<Covoiturage> getListdemandecov() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/affichecovdemande?id_user=" + user_nader);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovdemandes(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }

    public ArrayList<Covoiturage> getListmesoffrecov() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/affichemescovoffre?id_user=" + user_nader);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }

    public ArrayList<Covoiturage> getListmesdemandecov() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/affichemescovdemande?id_user="+user_nader);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovdemandes(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }

    public ArrayList<Covoiturage> getListreservationcov() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/affichemescovmesreservation?id_user=" + user_nader);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }
    
    public ArrayList<Covoiturage> getListinforeservationcov(int id_cov) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/inforeservationcovoffre?id_cov="+id_cov);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    }
    
    
     ArrayList<Reservation> listEtas = new ArrayList<>();
    
   public ArrayList<Reservation> getListEtas(int id_cov){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/reservationcovoffre?id_cov="+id_cov+"&id_user="+user_nader);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listEtas = ser.getListEtasReservation(new String(con.getResponseData()));
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEtas;
    }    
    
     public void ajoutCovOffre(Covoiturage cov) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiE404/web/app_dev.php/api/ajoutcovoffre?"
                + "id_user="+user_nader
                + "&heurdepart="+cov.getHeure_depart()
                + "&minitedepart="+cov.getMinute_depart()
                + "&villedepart="+cov.getVille_depart()
                + "&adrdepart="+cov.getAdr_depart()
                + "&villearive="+cov.getVille_arrive()
                + "&adrarrive="+cov.getAdr_arrive()
                + "&nbrplaces="+cov.getNbr_places()
                + "&cotisation="+cov.getCotisation()
                + "&description="+cov.getDescription()
                + "&datedepart="+cov.getDate_depart();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

        public void ajoutCovDemande(Covoiturage cov) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiE404/web/app_dev.php/api/ajoutcovdemande?"
                + "id_user="+user_nader
                + "&heurdepart="+cov.getHeure_depart()
                + "&minitedepart="+cov.getMinute_depart()
                + "&villedepart="+cov.getVille_depart()
                + "&adrdepart="+cov.getAdr_depart()
                + "&villearive="+cov.getVille_arrive()
                + "&adrarrive="+cov.getAdr_arrive()
                + "&description="+cov.getDescription()
                + "&datedepart="+cov.getDate_depart();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

        
        public void SuppCovOffre(Covoiturage cov) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiE404/web/app_dev.php/api/deleteoffrecov?id_cov="+cov.getId_cov();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

        
         public void SuppCovDemande(Covoiturage cov) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiE404/web/app_dev.php/api/deletedemandecov?id_cov="+cov.getId_cov();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
         
          public void PDF_Send(int id_cov) {
       // String lien =  "http://localhost/PiE404/web/app_dev.php/api/pdfcov?id_cov="+id_cov+"&id_user=2";   
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/pdfmail?id_user="+user_nader+"&id_cov="+id_cov);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                //listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        //return listcov;
    }

          
           public void Contacter_demande(int id_cov,String message) {
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/contactmail?id_cov="+id_cov
                + "&id_contact="+user_nader
                + "&message="+message);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();  
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }
           
    //recherche cov par ville d arrive
      

    public ArrayList<Covoiturage> getListRechercheoffrecov(String ville_arrive) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/api/covrechercheoffre?id_user="+user_nader+
                "&villearrive="+ville_arrive);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCov ser = new ServiceCov();
                listcov = ser.getListCovoffre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcov;
    } 
           
           
}
