package com.mycompany.assystem_app;
import com.orientechnologies.common.exception.OException;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OLiveQueryResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.impl.OVertexDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyLiveQueryListener implements OLiveQueryResultListener {

    private final List<List<Object>> dataMatrix = new ArrayList<>();
    private final DefaultListModel<String> listModel;
    private final String ClassName;

    public MyLiveQueryListener(DefaultListModel<String> listModel, String ClassName) {
        this.listModel = listModel;
        this.ClassName = ClassName;
    }
    @Override
    public void onCreate(ODatabaseDocument odd, OResult or) {
        addVertexToMatrix(or);
        updateListView();
    }

    @Override
    public void onUpdate(ODatabaseDocument odd, OResult or, OResult or1) {
        updateVertexInMatrix(or);
        updateListView();
    }

    @Override
    public void onDelete(ODatabaseDocument odd, OResult or) {
        removeVertexFromMatrix(or);
        updateListView();
    }

    @Override
    public void onError(ODatabaseDocument odd, OException oe) {
        System.err.println("Erreur dans le LiveQuery : " + oe.getMessage());
    }

    @Override
    public void onEnd(ODatabaseDocument odd) {
        System.out.println("LiveQuery terminée.");
    }
    
    private void addVertexToMatrix(OResult or) {
        List<Object> row = new ArrayList<>();
        for (String field : or.getPropertyNames()) {
            row.add(or.getProperty(field));
        }
        synchronized (dataMatrix) {
            dataMatrix.add(row);
        }
    }

    private void updateVertexInMatrix(OResult or) {
        synchronized (dataMatrix) {
            int index = findRowIndex(or);
            if (index != -1) {
                List<Object> row = new ArrayList<>();
                for (String field : or.getPropertyNames()) {
                    row.add(or.getProperty(field));
                }
                dataMatrix.set(index, row);
            }
        }
    }

    private void removeVertexFromMatrix(OResult or) {
        synchronized (dataMatrix) {
            int index = findRowIndex(or);
            if (index != -1) {
                dataMatrix.remove(index);
            }
        }
    }

    private int findRowIndex(OResult or) {
        synchronized (dataMatrix) {
            for (int i = 0; i < dataMatrix.size(); i++) {
                List<Object> row = dataMatrix.get(i);
                if (!row.isEmpty() && row.get(0).equals(or.getIdentity())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void updateListView() {
        synchronized (dataMatrix) {
            listModel.clear();
            for (List<Object> row : dataMatrix) {
                StringBuilder rowText = new StringBuilder();
                for (Object value : row) {
                    rowText.append(value).append(" ");
                }
                listModel.addElement(rowText.toString());
            }
        }
    }
    
    public void loadInitialData(ODatabaseSession db) {
        try {
            if (!db.isActiveOnCurrentThread()) {
                db.activateOnCurrentThread(); // Assure que la session est active dans le thread
            }
            String query = "SELECT FROM " + ClassName; // Requête pour récupérer toutes les données de la classe
            System.out.println("Exécution de la requête : " + query);
            // Exécute la requête et récupère les résultats
            List<OVertexDocument> results = db.query(new OSQLSynchQuery<>(query));
            System.out.println("Nombre de résultats trouvés : " + results.size());      
            synchronized (dataMatrix) {
                for (OVertexDocument vertex : results) {
                    List<Object> row = new ArrayList<>();
                    for (String field : vertex.getPropertyNames()) {
                        row.add(vertex.getProperty(field)); // Ajoute chaque propriété à la ligne
                    }
                    dataMatrix.add(row); // Ajoute la ligne au dataMatrix
                }
            }
            updateListView(); // Mets à jour directement la liste
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des données initiales pour " + ClassName + ": " + e.getMessage());
        }
    }

}
