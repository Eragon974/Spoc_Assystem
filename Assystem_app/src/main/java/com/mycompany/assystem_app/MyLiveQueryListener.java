package com.mycompany.assystem_app;

import com.orientechnologies.common.exception.OException;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OLiveQueryResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.impl.OVertexDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

import javax.swing.*;
import java.util.List;

public class MyLiveQueryListener implements OLiveQueryResultListener {

    private final DefaultListModel<String> listModel;
    private final String ClassName;
    private final ODatabaseSession db;

    public MyLiveQueryListener(DefaultListModel<String> listModel, String ClassName, ODatabaseSession db) {
        this.listModel = listModel;
        this.ClassName = ClassName;
        this.db = db;
    }

    @Override
    public void onCreate(ODatabaseDocument odd, OResult or) {
        loadData(db);  // Recharger les données après la création
    }

    @Override
    public void onUpdate(ODatabaseDocument odd, OResult or, OResult or1) {
        loadData(db);  // Recharger les données après la mise à jour
    }

    @Override
    public void onDelete(ODatabaseDocument odd, OResult or) {
        loadData(db);  // Recharger les données après la suppression
    }

    @Override
    public void onError(ODatabaseDocument odd, OException oe) {
        System.err.println("Erreur dans le LiveQuery : " + oe.getMessage());
    }

    @Override
    public void onEnd(ODatabaseDocument odd) {
        System.out.println("LiveQuery terminée.");
    }

    private void loadData(ODatabaseSession db) {
        try {
            if (!db.isActiveOnCurrentThread()) {
                db.activateOnCurrentThread();
            }
        
            String query = "SELECT FROM " + ClassName;
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));
        
            // Vider les données actuelles
            listModel.clear();
        
            // Recharger les données depuis la base
            for (OVertexDocument vertex : results) {
                StringBuilder rowText = new StringBuilder();
                String id = vertex.getIdentity().toString();
            
                // Ajouter les autres propriétés
                for (String field : vertex.getPropertyNames()) {
                    String propertyValue = vertex.getProperty(field);
                    if (propertyValue != null) {
                        rowText.append(propertyValue).append(" ");
                    } else {
                        rowText.append("null ").append(" ");  // Remplacer par "N/A" ou une chaîne vide si nécessaire
                    }
                }
            
                // Ajouter l'ID à la fin
                rowText.append("ID: ").append(id);
            
                listModel.addElement(rowText.toString());
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données pour " + ClassName + ": " + e.getMessage());
        }
    }

    
    public void loadInitialData(ODatabaseSession db) {
        loadData(db);  // Utiliser la méthode loadData pour charger les données initiales
    }
}