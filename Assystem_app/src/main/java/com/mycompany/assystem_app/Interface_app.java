/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assystem_app;

import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OLiveQueryMonitor;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.OrientDBConfigBuilder;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.id.ORecordId;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
import org.apache.commons.text.similarity.LevenshteinDistance;


public class Interface_app extends javax.swing.JFrame {
    private SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm");  // Format de l'heure
    private String time = sdf.format(new Date());
    private OrientDB orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    private OrientDBConfigBuilder poolCfg = OrientDBConfig.builder()
        .addConfig(OGlobalConfiguration.DB_POOL_MIN, 5)
        .addConfig(OGlobalConfiguration.DB_POOL_MAX, 10);
    private ODatabasePool pool;
    private MyLiveQueryListener listenerC;
    private DefaultListModel<String> listModelC = new DefaultListModel<>();
    private OLiveQueryMonitor monitorC;
    private MyLiveQueryListener listenerE;
    private DefaultListModel<String> listModelE = new DefaultListModel<>();
    private OLiveQueryMonitor monitorE;
    private Ajout_BDD_Frame Ajout_BDD_Frame; 
    private Connexion_Frame Connexion_Frame; 

    public Interface_app() {
        initComponents();
    }
    public void printMessage(String message) {
        // Récupérer l'heure actuelle
        SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm:ss.SSS");  // Format de l'heure
        String time = sdf.format(new Date());  // Obtenir l'heure actuelle

        // Construire le message avec l'heure
        String formattedMessage = time + " : " + message + "\n";

        // Ajouter le message à la JTextArea
        jTextArea1.append(formattedMessage);
        
        // Faire défiler jusqu'à la fin pour afficher le dernier message
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setLabelFor(jPanel1);
        jLabel1.setText("Interface Assystem Bilan de Puissance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setText("Se connecter à la base de données");

        jButton3.setText("Connexion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Ajouter à la BDD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Ajouter un composant ou un équipement à la base de données");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(120, 120, 120))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setText("Equipement");

        jList1.setModel(listModelE

        );
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 428, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setText("Composant");

        jList4.setModel(listModelC);
        jScrollPane5.setViewportView(jList4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        jButton2.setText("Deconnexion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField8.setToolTipText("");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Dupliquer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Modifier");

        jLabel12.setText("Recherche");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTextField8.getAccessibleContext().setAccessibleName("Recherche");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Ajout_BDD_Frame = new Ajout_BDD_Frame(pool,this);
        Ajout_BDD_Frame.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connexion_Frame connexionFrame = new Connexion_Frame(this);

    // Afficher la fenêtre de connexion
    connexionFrame.setVisible(true);

    // Utiliser un SwingWorker pour attendre l'interaction de l'utilisateur
    new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            // Attendre que l'utilisateur ait terminé (polling)
            while (connexionFrame.isVisible()) {
                Thread.sleep(100); // Polling interval (100ms)
            }
            return null;
        }

        @Override
        protected void done() {
            // Récupération des informations après la fermeture de la fenêtre
            String BDD = connexionFrame.getBDD();
            String User = connexionFrame.getUser();
            String Password = connexionFrame.getPassword();

            if (BDD != null && User != null && Password != null) {
                try {
                    // Initialisation du pool
                    pool = new ODatabasePool(orientDB, BDD, User, Password, poolCfg.build());
                    printMessage("Connexion réussie à la base de données : " + BDD);

                    ODatabaseSession db = pool.acquire();
                    if (!db.getMetadata().getSchema().existsClass("Composant")) {
                        db.getMetadata().getSchema().createClass("Composant", db.getMetadata().getSchema().getClass("V"));
                        printMessage("La classe Composant a été créée dans le schéma.");
                    }
                    if (!db.getMetadata().getSchema().existsClass("Equipement")) {
                        db.getMetadata().getSchema().createClass("Equipement", db.getMetadata().getSchema().getClass("V"));
                        printMessage("La classe Equipement a été créée dans le schéma.");
                    }

                    listenerC = new MyLiveQueryListener(listModelC, "Composant", db);
                    listenerC.loadInitialData(db);
                    monitorC = db.live("SELECT FROM Composant", listenerC);

                    listenerE = new MyLiveQueryListener(listModelE, "Equipement", db);
                    listenerE.loadInitialData(db);
                    monitorE = db.live("SELECT FROM Equipement", listenerE);
                } catch (Exception e) {
                    printMessage("Erreur lors de la connexion : " + e.getMessage());
                }
            } else {
                printMessage("Connexion annulée par l'utilisateur.");
            }
        }
    }.execute();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            monitorC.unSubscribe();
            monitorE.unSubscribe();
            if (pool != null && !pool.isClosed()) {
                pool.close();
                printMessage("Le pool de connexions a été fermé.");
            } else {
                printMessage("Le pool de connexions est déjà fermé ou non initialisé.");
            }
        } catch (Exception e) {
            printMessage("Erreur lors de la fermeture des connexions : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        String input = getTextFromAccessibleName("Recherche");
        LevenshteinDistance levenshtein = new LevenshteinDistance();

        // Préparer des listes temporaires pour les résultats filtrés
        List<String> closestMatch1 = new ArrayList<>();
        List<String> closestMatch2 = new ArrayList<>();
        List<String> listModelCArray = new ArrayList<>();
        List<String> listModelEArray = new ArrayList<>();

        // Filtrage pour la première JList

        for (int i = 0; i < listModelE.getSize(); i++) {
            listModelEArray.add(listModelE.getElementAt(i));
        }

        for (int i = 0; i < listModelC.getSize(); i++) {
            listModelCArray.add(listModelC.getElementAt(i));
        }

        // Recherche dans la première liste

        for (int i = 0; i < listModelEArray.size(); i++) {
            String element = listModelEArray.get(i);
            if (isMatch(input, element, levenshtein)) {
                closestMatch1.add(element);
            }
        }

        // Filtrage pour la deuxième JList
        for (int i = 0; i < listModelCArray.size(); i++) {
            String element = listModelCArray.get(i);
            if (isMatch(input, element, levenshtein)) {
                closestMatch2.add(element);
            }
        }
        printMessage(closestMatch1.toString());
        printMessage(closestMatch2.toString());

        // Mettre à jour les listes avec les éléments les plus proches
        if (!closestMatch1.isEmpty()) {
            jList1.setListData(closestMatch1.toArray(new String[0]));
        } else if (input.isEmpty()) {
            printMessage("input vide");
            jList1.setListData(listModelEArray.toArray(new String[0]));
        }
        else {
            printMessage("Aucun élément trouvé dans la liste 1" + listModelEArray.toString());
            jList1.setListData(listModelEArray.toArray(new String[0]));
        }

        if (!closestMatch2.isEmpty()) {
            jList4.setListData(closestMatch2.toArray(new String[0]));
        } else if(input.isEmpty()){
            printMessage("input vide");
            jList4.setListData(listModelCArray.toArray(new String[0]));
        }
        else{
            printMessage("Aucun élément trouvé dans la liste 2" + listModelCArray.toString());
            jList4.setListData(listModelCArray.toArray(new String[0]));
        }
    }//GEN-LAST:event_jTextField8ActionPerformed

    private boolean isMatch(String input, String element, LevenshteinDistance levenshtein) {
        // Diviser l'élément en mots
        String[] words = element.split("\\s+");
        for (String word : words) {
            if (word.startsWith("ID:")) continue; // Ignorer les IDs
            int distance = levenshtein.apply(input, word.toLowerCase());
            if (distance <= 3) { // Ajustez le seuil
                return true;
            }
        }
        return false;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                              
        ODatabaseSession db = pool.acquire();

        // Récupérer les éléments sélectionnés dans jList1 et jList4
        List<String> selectedItemsList1 = jList1.getSelectedValuesList();
        List<String> selectedItemsList4 = jList4.getSelectedValuesList();

        // Supprimer les éléments sélectionnés de la base de données
        for (String item : selectedItemsList1) {
            try {
                // Extraire l'ID du vertex (dernière partie du texte dans l'élément de jList)
                String[] parts = item.split("ID: ");  // Assure que l'ID est après "ID: "
                if (parts.length > 1) {
                    String vertexId = parts[1];  // ID récupéré
                    ORecordId recordId = new ORecordId(vertexId);
                    OVertex vertex = db.load(recordId); 
                    if (vertex != null) {
                        vertex.delete();  // Supprimer le vertex
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la suppression : " + e.getMessage());
            }
        }

        for (String item : selectedItemsList4) {
            try {
                // Extraire l'ID du vertex (dernière partie du texte dans l'élément de jList)
                String[] parts = item.split("ID: ");
                if (parts.length > 1) {
                    String vertexId = parts[1];  // ID récupéré
                    ORecordId recordId = new ORecordId(vertexId);
                    OVertex vertex = db.load(recordId);  
                    if (vertex != null) {
                        vertex.delete();  // Supprimer le vertex
                    }
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de la suppression : " + e.getMessage());
            }
        }

        // Afficher un message de confirmation
        printMessage("Éléments supprimés avec succès !");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ODatabaseSession db = pool.acquire();
        // Liste des propriétés associées à filteredWords
        String[] propertyKeys = {
            "Famille", 
            "Sous Famille", 
            "Type", 
            "Constructeur", 
            "Tension(VCC)", 
            "Puissance Unitaire(W)", 
            "Puissance Transitoire(W)", 
            "Indice de confiance", 
            "Origine de consommation"
        };
        List<String> selectedItemsList1 = jList1.getSelectedValuesList();
        List<String> selectedItemsList4 = jList4.getSelectedValuesList();
        if (selectedItemsList1.isEmpty() && selectedItemsList4.isEmpty()){
            printMessage("Pas d'éléments sélectionnés pour la duplication");
            return;
        }
        for (String item : selectedItemsList1){
            String[] info = item.split("\\s+");

            // Filter out the word that starts with "ID:"
            List<String> filteredWords = new ArrayList<>();
            for (String infos : info) {
                if (!infos.startsWith("ID:") && !infos.startsWith("#")) {
                    filteredWords.add(infos.trim());
                }
            }
            System.out.println(filteredWords);
            try {
                printMessage("Tentative de duplication du/des vertex");
                OVertex v = db.newVertex("Equipement");
                    // Parcours de filteredWords et définition des propriétés
                for (int i = 0; i <= 8; i++) {
                    v.setProperty(propertyKeys[i], filteredWords.get(i));
                }
                // Sauvegarde de l'objet
                v.save();
                printMessage("Le/Les Vertex ont bien été dupliqués");
            } catch (Exception e) {
                printMessage("Erreur lors de la duplication : " + e.getMessage());
                e.printStackTrace();
            }
        }
        for (String item : selectedItemsList4){
            String[] info = item.split("\\s+");

            // Filter out the word that starts with "ID:"
            List<String> filteredWords = new ArrayList<>();
            for (String infos : info) {
                if (!infos.startsWith("ID:") && !infos.startsWith("#")) {
                    filteredWords.add(infos.trim());
                }
            }
            System.out.println(filteredWords);
            try {
                printMessage("Tentative de duplication du/des vertex");
                OVertex v = db.newVertex("Composant");
                    // Parcours de filteredWords et définition des propriétés
                for (int i = 0; i <= 8; i++) {
                    v.setProperty(propertyKeys[i], filteredWords.get(i));
                }
                // Sauvegarde de l'objet
                v.save();
                printMessage("Le/Les Vertex ont bien été dupliqués");
            } catch (Exception e) {
                printMessage("Erreur lors de la duplication : " + e.getMessage());
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    public String getTextFromAccessibleName(String accessibleName) {
        return getTextFromAccessibleNameRecursive(getContentPane(), accessibleName);
    }

    public String getTextFromAccessibleNameRecursive(java.awt.Container container, String accessibleName) {
        for (java.awt.Component comp : container.getComponents()) {
            // Vérifier si le composant est un JTextField
            if (comp instanceof javax.swing.JTextField) {
                javax.swing.JTextField textField = (javax.swing.JTextField) comp;
                if (accessibleName.equals(textField.getAccessibleContext().getAccessibleName())) {
                    return textField.getText();
                }
            }    
        // Vérifier si le composant est un JComboBox
            else if (comp instanceof javax.swing.JComboBox) {
                javax.swing.JComboBox<?> comboBox = (javax.swing.JComboBox<?>) comp;
                if (accessibleName.equals(comboBox.getAccessibleContext().getAccessibleName())) {
                    // Récupérer la valeur sélectionnée dans la combobox
                    Object selectedItem = comboBox.getSelectedItem();
                    return selectedItem != null ? selectedItem.toString() : ""; // Retourne une chaîne vide si aucun élément n'est sélectionné
                }
            }
            // Rechercher récursivement dans les sous-conteneurs
            else if (comp instanceof java.awt.Container) {
                String result = getTextFromAccessibleNameRecursive((java.awt.Container) comp, accessibleName);
                if (!result.isEmpty()) {
                    return result;
                }
            }
        }
        return "";  // Retourne une chaîne vide si le champ ou la combobox n'est pas trouvé
    }
    
    public static void main(String args[]) {
        Interface_app interface_app = new Interface_app();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface_app().setVisible(true);
            }
        }); 
    }

    public void setJframeAjout_BDD(Ajout_BDD_Frame Ajout_BDD_Frame){
        this.Ajout_BDD_Frame = Ajout_BDD_Frame;
    }
    public void setJframeConnexion_BDD(Connexion_Frame Connexion_Frame){
        this.Connexion_Frame = Connexion_Frame;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
