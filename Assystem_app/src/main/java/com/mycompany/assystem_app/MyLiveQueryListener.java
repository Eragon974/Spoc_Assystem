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

public class MyLiveQueryListener implements OLiveQueryResultListener {

    private final JTable table;
    private final String className;
    private final ODatabaseSession db;
    public DefaultTableModel modelE;
    public DefaultTableModel modelC;

    public MyLiveQueryListener(JTable table, String className, ODatabaseSession db,DefaultTableModel modelE,DefaultTableModel modelC) {
        this.modelE = modelE;
        this.modelC = modelC;
        this.table = table;
        this.className = className;
        this.db = db;
        }

        @Override
        public void onCreate(ODatabaseDocument odd, OResult or) {
            updateTableData();
        }

        @Override
        public void onUpdate(ODatabaseDocument odd, OResult or, OResult or1) {
            updateTableData();
        }

        @Override
        public void onDelete(ODatabaseDocument odd, OResult or) {
            updateTableData();
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
        
            String query = "SELECT FROM " + className;
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));
            
            // Create table model
            DefaultTableModel model = new DefaultTableModel();
            
            // Dynamically determine columns from first result
            if (!results.isEmpty()) {
                OVertexDocument firstVertex = results.get(0);
                for (String field : firstVertex.getPropertyNames()) {
                    model.addColumn(field);
                }
            }

            // Add ID column
            model.addColumn("ID");
            
            // Add data rows
            for (OVertexDocument vertex : results) {
                Vector<Object> rowData = new Vector<>();
                String id = vertex.getIdentity().toString();
                
                
                // Add property values
                for (String field : vertex.getPropertyNames()) {
                    Object propertyValue = vertex.getProperty(field);
                    rowData.add(propertyValue != null ? propertyValue : "");
                }
                rowData.add(id);
                
                model.addRow(rowData);
            }
            
            // Apply model to table
            table.setModel(model);
            
            // Determine which model to update based on the className
            
            
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données pour " + className + ": " + e.getMessage());
            e.printStackTrace();
        }
        // Determine which model to update based on the classNam
       
    }

    private synchronized void updateTableData() {
        SwingUtilities.invokeLater(() -> {
            loadData(db);
            updateData(className, modelE, modelC);
        });
    }
    
    public void loadInitialData() {
        loadData(db);
    }

    public synchronized DefaultTableModel updateData(String className, DefaultTableModel model1, DefaultTableModel model2) {
        try {
            if (!db.isActiveOnCurrentThread()) {
                db.activateOnCurrentThread();
            }

            String query = "SELECT FROM " + className;
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));

            // Create table model
            DefaultTableModel model = new DefaultTableModel();

            // Dynamically determine columns from first result
            if (!results.isEmpty()) {
                OVertexDocument firstVertex = results.get(0);
                for (String field : firstVertex.getPropertyNames()) {
                    model.addColumn(field);
                }
            }

            // Add ID column
            model.addColumn("ID");

            // Add data rows
            for (OVertexDocument vertex : results) {
                Vector<Object> rowData = new Vector<>();
                String id = vertex.getIdentity().toString();

                // Add property values
                for (String field : vertex.getPropertyNames()) {
                    Object propertyValue = vertex.getProperty(field);
                    rowData.add(propertyValue != null ? propertyValue : "");
                }
                rowData.add(id);

                model.addRow(rowData);
            }

            // Determine which model to update based on the className
            if (className.equals("Equipement")) {
                model1 = model;
                return model;
            } else if (className.equals("Composant")) {
                model2 = model;
                return model;
            } else {
                System.err.println("Unknown class name: " + className);
                return null;
            }

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données pour " + className + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}