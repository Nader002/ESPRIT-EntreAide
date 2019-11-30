/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.EspritEntreAide.Service;

import com.esprit.EspritEntreAid.entities.DemandeRevision;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.MesDemandesRev;
import com.codename1.uikit.cleanmodern.MesOffresRev;
import com.codename1.uikit.cleanmodern.MesReservationRev;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.esprit.EspritEntreAid.entities.OffreRevision;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahri
 */
public class DemRevService {

    ArrayList<DemandeRevision> listrev = new ArrayList<>();

    public ArrayList<DemandeRevision> getList2() {
        ArrayList<DemandeRevision> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/allDemRev/" + SignInForm.connectedUser.getId_user());

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
                        DemandeRevision task = new DemandeRevision();
                        task.setId((int) Float.parseFloat(obj.get("id").toString()));
                        task.setMatiere(obj.get("matiere").toString());
                        task.setNiveau(obj.get("niveau").toString());
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

    public void ajoutDemRev(DemandeRevision rev) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/newDemandeRev?"
                + "id=" + SignInForm.connectedUser.getId_user()
                + "&niveau=" + rev.getNiveau()
                + "&image=" + rev.getImage()
                + "&matiere=" + rev.getMatiere()
                + "&description=" + rev.getDescription();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<DemandeRevision> getListmesdemanderev() {
        ArrayList<DemandeRevision> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/mesDemandeRev/" + SignInForm.connectedUser.getId_user());

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
                        DemandeRevision task = new DemandeRevision();
                        task.setId((int) Float.parseFloat(obj.get("id").toString()));
                        task.setMatiere(obj.get("matiere").toString());
                        task.setNiveau(obj.get("niveau").toString());
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

    public void SuppDemRev(int id, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/DelDemandeRev/" + id;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            Dialog.show("Succés", "demande supprimée", "ok", null);

            MesDemandesRev c = new MesDemandesRev(res);
            c.show();
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void modifierDemandeRev(DemandeRevision rev, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/updateDemandeRev?"
                + "id=" + rev.getId()
                + "&niveau=" + rev.getNiveau()
                + "&matiere=" + rev.getMatiere()
                + "&description=" + rev.getDescription();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            Dialog.show("Succés", "demande modifiée", "ok", null);

            MesDemandesRev a = new MesDemandesRev(res);
            a.show();

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<DemandeRevision> ChercherDemande(String s) {
        ArrayList<DemandeRevision> listDemandeRevision = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIE404/web/app_dev.php/demanderevision/Mobile/chercherDemandeRev/" + s);
        con.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    DemandeRevision task = new DemandeRevision();

                    task.setId((int) Float.parseFloat(obj.get("id").toString()));
                    task.setMatiere(obj.get("matiere").toString());
                    task.setNiveau(obj.get("niveau").toString());
                    task.setDescription(obj.get("description").toString());
                    task.setImage(obj.get("image").toString());
                    listDemandeRevision.add(task);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listDemandeRevision;
    }
}
