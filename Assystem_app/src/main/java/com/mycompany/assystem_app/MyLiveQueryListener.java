package com.mycompany.assystem_app;
import com.orientechnologies.common.exception.OException;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OLiveQueryResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyLiveQueryListener implements OLiveQueryResultListener {

    private final List<List<Object>> dataMatrix = new ArrayList<>();
    private final DefaultListModel<String> listModel;
    private final Runnable onConnexionCallback;
    private final String ClassName;

    public MyLiveQueryListener(DefaultListModel<String> listModel, String ClassName, Runnable onConnexionCallback) {
        this.listModel = listModel;
        this.onConnexionCallback = onConnexionCallback;
        this.ClassName = ClassName;
    }
    
    public void onConnexion(ODatabaseSession db) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Une fois que la connexion est établie, on récupère toutes les données de la classe associée
                String query = "SELECT FROM " + ClassName;  // Par exemple "Composant" ou "Equipement"
                List<OResult> result = db.query(new OSQLSynchQuery<>(query));

                // Ajouter les résultats à la matrice de données
                synchronized (dataMatrix) {
                    for (OResult r : result) {
                        List<Object> row = new ArrayList<>();
                        for (String field : r.getPropertyNames()) {
                            row.add(r.getProperty(field));  // Ajoute chaque propriété du vertex à la ligne
                        }
                        dataMatrix.add(row);  // Ajoute la ligne à la matrice
                    }
                }

                // Mettre à jour la vue avec les nouvelles données
                updateListView();

                // Appeler le callback (si défini) après la connexion
                if (onConnexionCallback != null) {
                    onConnexionCallback.run();  // Appelle la méthode onConnexionCallback
                }
            } catch (Exception e) {
                e.printStackTrace();  // Gestion des erreurs
            }
        });
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
}
