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
import com.esprit.EspritEntreAid.entities.Objet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ServiceObjet {
    
//  int  a = ObjetsForm1.idUserwiem ; ;
    int a = SignInForm.connectedUser.getId_user();
  //  int a = 1 ;
    
    public void ajoutObjet(Objet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/tasksob/new?nomObjet="+ta.getNom_objet()+"&categorie="+ta.getCategorie()+"&img="+ta.getImg()+"&lieu="+ta.getLieu()+"&description="+ta.getDescription()+"&type=p&etat=0&lu=non&idUser="+a;

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void ajoutObjetT(Objet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/tasksob/new?nomObjet="+ta.getNom_objet()+"&categorie="+ta.getCategorie()+"&img="+ta.getImg()+"&lieu="+ta.getLieu()+"&description="+ta.getDescription()+"&type=t&etat=0&lu=non&idUser="+a;

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    // http://localhost/PiE404/web/app_dev.php/tasksob/all
    
    
    
    public ArrayList<Objet> getListObjets(String json) {

        ArrayList<Objet> listEtudiants = new ArrayList<>();

        try {
        //    System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
          System.out.println(etudiants);
           
         //   List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
                        List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            System.out.println(list);
            for (Map<String, Object> obj : list) {
                Objet e = new Objet();
       
Map<String, Object> obj1 = (Map<String, Object>) obj.get("idUser");

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj1.get("idUser").toString());
                 float id1 = Float.parseFloat(obj.get("idObjet").toString());
                  e.setId_objet((int) id1);


              //  System.out.println(id);
               // e.setId_objet((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
           // String a = obj.get("idUser").toString();
               e.setCategorie(obj.get("categorie").toString());
               e.setLieu(obj.get("lieu").toString());
               e.setNom_objet(obj.get("nomObjet").toString());
               e.setImg(obj.get("img").toString());
               e.setDescription(obj.get("description").toString());

              e.setId_user((int) id);
e.setEmail(obj1.get("email").toString());
              // e.setNom(obj.get("name").toString());
                System.out.println(obj1.get("idUser"));
                listEtudiants.add(e);

            }
        } catch (IOException ex) {
        }
   //     System.out.println(listEtudiants);
        return listEtudiants;

    }
    
    
    ArrayList<Objet> listObjets = new ArrayList<>();
    
    public ArrayList<Objet> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasksob/all?id="+a);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceObjet ser = new ServiceObjet();
                listObjets = ser.getListObjets(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObjets;
    }
    
        ArrayList<Objet> listObjets5 = new ArrayList<>();
    
    public ArrayList<Objet> getList5(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasksobT/all?id="+a);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceObjet ser = new ServiceObjet();
                listObjets5 = ser.getListObjets(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObjets5;
    }
    
    
    
    
    ArrayList<Objet> listObj = new ArrayList<>();
    
    public ArrayList<Objet> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/tasksob/allpub?id="+a);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceObjet ser = new ServiceObjet();
                listObj = ser.getListObjets(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listObj;
    }
    
    
    
    
    
    
    
        public void DeleteObjet(Objet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/tasks/delete/"+ta.getId_objet();

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
        
        
        
    public void modifierObjet(Objet ta) {
        ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/PIE404/web/app_dev.php/modob/new?idObjet="+ta.getId_objet()+"&nomObjet="+ta.getNom_objet()+"&categorie="+ta.getCategorie()+"&img="+ta.getImg()+"&lieu="+ta.getLieu()+"&description="+ta.getDescription()+"&type=p&etat=0&lu=non&idUser="+a;

        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
    
     public void envoyermailObjet(Objet ta) {
        ConnectionRequest con = new ConnectionRequest();
         System.out.println(ta.getContenu());
            String Url = "http://localhost/PIE404/web/app_dev.php/tasksob/allmail?email="+ta.getEmail()+"&contenu="+ta.getContenu()+"&id="+ta.getId_objet()+"&connect="+a;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
        ArrayList<Objet> list2 = new ArrayList<>();

         public ArrayList<Objet> getrechnom(String k){       
        list2 = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/tasks/cherchernom/"+k+"/"+a);
        con.addResponseListener((NetworkEvent evt) -> {
            ServiceObjet ser = new ServiceObjet();
                        list2 = ser.getListObjets(new String(con.getResponseData()));

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list2;
    }
   //http://localhost/PiE404/web/app_dev.php/tasksob/allmail?email=wiem.turki@esprit.tn&contenu=5 
         
           ArrayList<Objet> list3 = new ArrayList<>();

         public ArrayList<Objet> getrechcateg(String k){       
        list2 = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiE404/web/app_dev.php/tasks/cherchercategob/"+k+"/"+a);
        con.addResponseListener((NetworkEvent evt) -> {
            ServiceObjet ser = new ServiceObjet();
                        list3 = ser.getListObjets(new String(con.getResponseData()));

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list3;
    }
    
    
    
    

    
}
