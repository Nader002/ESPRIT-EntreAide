/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.esprit.EspritEntreAid.entities.Robjet;
import com.esprit.EspritEntreAid.entities.StatOb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author USER
 */
public class ServiceRObjet {

      int a = SignInForm.connectedUser.getId_user();
  //  int a = 1;


     public ArrayList<Robjet> getListObjets(String json) {

        ArrayList<Robjet> listEtudiants = new ArrayList<>();

        try {
        //    System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
          System.out.println(etudiants);
         
         //   List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
                        List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            System.out.println(list);
            for (Map<String, Object> obj : list) {
                Robjet e = new Robjet();
       
Map<String, Object> obj1 = (Map<String, Object>) obj.get("idUser");
Map<String, Object> obj2 = (Map<String, Object>) obj.get("idObjet");

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("idRes").toString());
                 float id1 = Float.parseFloat(obj1.get("idUser").toString());
                 float id2 = Float.parseFloat(obj2.get("idObjet").toString());

                  e.setId_res((int) id);


e.setId_user(   (int) id1);
e.setNonsender(obj1.get("email").toString());
                System.out.println(obj2.get("nomObjet").toString());
e.setId_objet(  (int) id2);
e.setNonobjets(obj2.get("nomObjet").toString());
              // e.setNom(obj.get("name").toString());
                listEtudiants.add(e);

            }
          
        } catch (IOException ex) {
        }
   //     System.out.println(listEtudiants);
        return listEtudiants;

    }
    
    
    ArrayList<Robjet> listObjets = new ArrayList<>();
    
    public ArrayList<Robjet> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasksres/all?id="+a);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceRObjet ser = new ServiceRObjet();
                listObjets = ser.getListObjets(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObjets;
    }
    
    
           public void DeleteObjet(Robjet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/tasks/deleteres/"+ta.getId_res();

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
   
        public void DeleteObjet1(Robjet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/tasks/deleteres1/"+ta.getId_res();

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
        
            ArrayList<StatOb> listObjets1= new ArrayList<>();
    
    public ArrayList<StatOb> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasksob/chart");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceRObjet ser = new ServiceRObjet();
                try {
                    listObjets1 = ser.getListObjets1(new String(con.getResponseData()));
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObjets1;
    }
    
         public ArrayList<StatOb> getListObjets1(String json) throws IOException {

        ArrayList<StatOb> listEtudiants = new ArrayList<>();
                StatOb e = new StatOb();

        //    System.out.println(json);
            JSONParser j = new JSONParser();

           Map<String, Object> etudiants =  j.parseJSON(new CharArrayReader(json.toCharArray()));
          System.out.println(etudiants);
         
         
    float p = Float.parseFloat(etudiants.get("p").toString());
    float t = Float.parseFloat(etudiants.get("t").toString());
    e.setP((int) p);
    e.setT((int) t);
                    listEtudiants.add(e);


            
          
       
        return listEtudiants;

    }
         
         
         
             int listObjets2 ;
    
    public int getList4(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasks/notob/"+a);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceRObjet ser = new ServiceRObjet();
                try {
                    listObjets2 = ser.getListObjets2(new String(con.getResponseData()));
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObjets2;
    }
    
         public int getListObjets2(String json) throws IOException {

       

        //    System.out.println(json);
            JSONParser j = new JSONParser();

           Map<String, Object> etudiants =  j.parseJSON(new CharArrayReader(json.toCharArray()));
          System.out.println(etudiants);
         
         
    float p = Float.parseFloat(etudiants.get("o").toString());
    int a = (int) p;

             System.out.println(a);
            
          
       
        return a;

    }
         
}
