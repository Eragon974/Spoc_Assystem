package com.mycompany.assystem_app;

import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.orientechnologies.common.exception.OException;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OLiveQueryResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.impl.OVertexDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

/**
 * Listener pour les requêtes live OrientDB, permettant de mettre à jour dynamiquement
 * une JTable lors de la création, modification ou suppression de données dans la base.
 */
public class MyLiveQueryListener implements OLiveQueryResultListener {  
    private final JTable table; // Table à mettre à jour
    private final String className; // Nom de la classe OrientDB à surveiller
    private final ODatabaseSession db; // Session de base de données
    public DefaultTableModel modelE; // Modèle pour Equipement
    public DefaultTableModel modelC; // Modèle pour Composant

    /**
     * Constructeur du listener.
     * @param table JTable à mettre à jour
     * @param className Nom de la classe OrientDB à surveiller
     * @param db Session de base de données
     * @param modelE Modèle Equipement
     * @param modelC Modèle Composant
     */
    public MyLiveQueryListener(JTable table, String className, ODatabaseSession db, DefaultTableModel modelE, DefaultTableModel modelC) {
        this.modelE = modelE;
        this.modelC = modelC;
        this.table = table;
        this.className = className;
        this.db = db;
    }

    // Appelé lors de la création d'un enregistrement
    @Override
    public void onCreate(ODatabaseDocument odd, OResult or) {
        updateTableData();
    }

    // Appelé lors de la modification d'un enregistrement
    @Override
    public void onUpdate(ODatabaseDocument odd, OResult or, OResult or1) {
        updateTableData();
    }

    // Appelé lors de la suppression d'un enregistrement
    @Override
    public void onDelete(ODatabaseDocument odd, OResult or) {
        updateTableData();
    }

    // Appelé en cas d'erreur dans la requête live
    @Override
    public void onError(ODatabaseDocument odd, OException oe) {
        System.err.println("Erreur dans le LiveQuery : " + oe.getMessage());
    }

    // Appelé à la fin de la requête live
    @Override
    public void onEnd(ODatabaseDocument odd) {
        System.out.println("LiveQuery terminée.");
    }

    /**
     * Charge les données depuis la base et met à jour la JTable.
     * @param db Session de base de données
     */
    private void loadData(ODatabaseSession db) {
        try {
            if (!db.isActiveOnCurrentThread()) {
                db.activateOnCurrentThread();
            }

            String query = "SELECT FROM " + className;
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));
            
            // Création du modèle de table
            DefaultTableModel model = new DefaultTableModel();
            
            // Détermination dynamique des colonnes à partir du premier résultat
            if (!results.isEmpty()) {
                OVertexDocument firstVertex = results.get(0);
                for (String field : firstVertex.getPropertyNames()) {
                    model.addColumn(field);
                }
            }
            model.addColumn("ID"); // Ajout de la colonne ID
            
            // Ajout des lignes de données
            for (OVertexDocument vertex : results) {
                Vector<Object> rowData = new Vector<>();
                String id = vertex.getIdentity().toString();
                
                // Ajout des valeurs des propriétés
                for (String field : vertex.getPropertyNames()) {
                    Object propertyValue = vertex.getProperty(field);
                    rowData.add(propertyValue != null ? propertyValue : "");
                }
                rowData.add(id);
                
                model.addRow(rowData);
            }
            
            // Application du modèle à la JTable
            table.setModel(model);

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données pour " + className + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Met à jour la JTable et les modèles de données de façon thread-safe.
     */
    private synchronized void updateTableData() {
        SwingUtilities.invokeLater(() -> {
            loadData(db);
            updateData(className, modelE, modelC);
        });
    }
    
    /**
     * Charge les données initiales dans la JTable.
     */
    public void loadInitialData() {
        loadData(db);
    }

    /**
     * Met à jour le modèle de données correspondant à la classe surveillée.
     * @param className Nom de la classe OrientDB
     * @param model1 Modèle Equipement
     * @param model2 Modèle Composant
     * @return Le modèle mis à jour ou null si erreur
     */
    public synchronized DefaultTableModel updateData(String className, DefaultTableModel model1, DefaultTableModel model2) {
        try {
            if (!db.isActiveOnCurrentThread()) {
                db.activateOnCurrentThread();
            }

            String query = "SELECT FROM " + className;
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));

            // Création du modèle de table
            DefaultTableModel model = new DefaultTableModel();

            // Détermination dynamique des colonnes à partir du premier résultat
            if (!results.isEmpty()) {
                OVertexDocument firstVertex = results.get(0);
                for (String field : firstVertex.getPropertyNames()) {
                    model.addColumn(field);
                }
            }

            // Ajout de la colonne ID
            model.addColumn("ID");

            // Ajout des lignes de données
            for (OVertexDocument vertex : results) {
                Vector<Object> rowData = new Vector<>();
                String id = vertex.getIdentity().toString();

                // Ajout des valeurs des propriétés
                for (String field : vertex.getPropertyNames()) {
                    Object propertyValue = vertex.getProperty(field);
                    rowData.add(propertyValue != null ? propertyValue : "");
                }
                rowData.add(id);

                model.addRow(rowData);
            }

            // Mise à jour du modèle correspondant selon le nom de la classe
            if (className.equals("Equipement")) {
                model1 = model;
                return model;
            } else if (className.equals("Composant")) {
                model2 = model;
                return model;
            } else {
                System.err.println("Nom de classe inconnu : " + className);
                return null;
            }

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données pour " + className + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}