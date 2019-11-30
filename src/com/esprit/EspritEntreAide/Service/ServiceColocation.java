package com.esprit.EspritEntreAide.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.esprit.EspritEntreAid.entities.Colocation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ryhab
 */
public class ServiceColocation {
    public void test(){
        System.out.println("hello word");
    }
            public void ajoutTask() {
        ConnectionRequest con = new ConnectionRequest(); 
        String Url = "http://localhost/PiE404/web/app_dev.php/colocation/newm?prix=1&nbrChdispo=1&description=zzz&adress=zz&img1=zzz&idUser=10" ;
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      public ArrayList<Colocation> getListTask(String json) {
System.out.println("bnjour");
        ArrayList<Colocation> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Colocation e = new Colocation();
                Map<String, Object> obj1 = (Map<String, Object>) obj.get("idUser");
                System.out.println(obj1.get("idUser"));

                // System.out.println(obj.get("id"));
              //  int id = Float.parseFloat(obj.get("idCol").toString());
                e.setId_col((int)Double.parseDouble(obj.get("idCol").toString()));
                e.setPrix(Float.parseFloat(obj.get("prix").toString()));
                e.setDescription(obj.get("description").toString());
               e.setAdress(obj.get("adress").toString());
               e.setNbr_chdispo((int)Double.parseDouble(obj.get("nbrChdispo").toString()));
//                e.setId((int) id);
//                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
//                e.setEtat(obj.get("state").toString());
//                e.setNom(obj.get("name").toString());
//                System.out.println(e);
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;

    }
    
    
    ArrayList<Colocation> listTasks = new ArrayList<>();
    
    public ArrayList<Colocation> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("rihab");
        con.setUrl("http://localhost/PiE404/web/app_dev.php/colocation/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceColocation ser = new ServiceColocation();
                listTasks = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    
    ArrayList<Colocation> listTasks3 = new ArrayList<>();
    
    public ArrayList<Colocation> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("rihab");
        con.setUrl("http://localhost/PiE404/web/app_dev.php/colocation/mes");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceColocation ser = new ServiceColocation();
                listTasks3 = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks3;
    }
    ArrayList<Colocation> listTasks4 = new ArrayList<>();
    
    public ArrayList<Colocation> getList4(String adress){       
        ConnectionRequest con = new ConnectionRequest();
        System.out.println("rihab");
        con.setUrl("http://localhost/PiE404/web/app_dev.php/colocation/cher/"+adress);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceColocation ser = new ServiceColocation();
                listTasks3 = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks4;
    }
     public void suppTask(int idCol) {
        ConnectionRequest con = new ConnectionRequest(); 
        String Url = "http:/localhost/PiE404/web/app_dev.php/colocation/sup/"+idCol;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    
    
}
