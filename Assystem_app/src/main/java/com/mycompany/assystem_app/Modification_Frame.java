/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assystem_app;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.OVertex;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author julie
 */
public class Modification_Frame extends javax.swing.JFrame {
    private ODatabaseSession db;
    private List<String> info;
    private String RID;
    private List<String> filteredWords;
    private String[] propertyKeys = {
            "Classe",
            "Famille", 
            "Type",
            "Sous Famille", 
            "Constructeur", 
            "Tension(VCC)", 
            "Puissance Unitaire(W)", 
            "Puissance Transitoire(W)", 
            "Indice de confiance", 
            "Origine de consommation"
        };


    /**
     * Creates new form Modification_Frame
     */
    public Modification_Frame(List<String> info, ODatabaseSession db) {
        this.db = db;
        this.info = info;
        this.RID = info.get(11);
        filteredWords = new ArrayList<>();
        initComponents();
        for (String infos : info) {
            if (!infos.startsWith("ID:") && !infos.startsWith("#")) {
                filteredWords.add(infos.trim());
             }
        }
        
        setTextToAccessibleName("Mod_Classe", filteredWords.get(0));
        setTextToAccessibleName("Mod_Famille", filteredWords.get(1));
        setTextToAccessibleName("Mod_Type", filteredWords.get(2));
        setTextToAccessibleName("Mod_Sous_Famille", filteredWords.get(3));
        setTextToAccessibleName("Mod_Constructeur", filteredWords.get(4));
        setTextToAccessibleName("Mod_Tension", filteredWords.get(5));
        setTextToAccessibleName("Mod_PU", filteredWords.get(6));
        setTextToAccessibleName("Mod_PT", filteredWords.get(7));
        setTextToAccessibleName("Mod_IdC", filteredWords.get(8));
        setTextToAccessibleName("Mod_Cons", filteredWords.get(9));
        
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
        jTextField4 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel6.setText("Constructeur");

        jLabel11.setText("Origine consommation ");

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tension (VCC)");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Puissance unitaire (W)");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel9.setText("Puissance transitoire (W)");

        jLabel2.setText("Classe");

        jLabel3.setText("Famille");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Sous famille");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel5.setText("Type");

        jLabel10.setText("Indice de confiance");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equipement", "Composant" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(jTextField3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField5)
                                            .addComponent(jTextField2))
                                        .addGap(6, 6, 6)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(51, 51, 51)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jTextField4.getAccessibleContext().setAccessibleName("Mod_Sous_Famille");
        jTextField9.getAccessibleContext().setAccessibleName("Mod_Cons");
        jTextField5.getAccessibleContext().setAccessibleName("Mod_Tension");
        jTextField6.getAccessibleContext().setAccessibleName("Mod_PU");
        jTextField7.getAccessibleContext().setAccessibleName("Mod_PT");
        jTextField1.getAccessibleContext().setAccessibleName("Mod_Famille");
        jTextField1.getAccessibleContext().setAccessibleDescription("");
        jTextField2.getAccessibleContext().setAccessibleName("Mod_Constructeur");
        jTextField3.getAccessibleContext().setAccessibleName("Mod_Type");
        jTextField8.getAccessibleContext().setAccessibleName("Mod_IdC");
        jComboBox1.getAccessibleContext().setAccessibleName("Mod_Classe");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OVertex v;
        try {
            ORecordId recordId = new ORecordId(RID);
            OVertex vertex = db.load(recordId);
            
            String className = getTextFromAccessibleName("Mod_Classe");
            String famille = getTextFromAccessibleName("Mod_Famille");
            String sousFamille = getTextFromAccessibleName("Mod_Sous_Famille");
            String type = getTextFromAccessibleName("Mod_Type");
            String constructeur = getTextFromAccessibleName("Mod_Constructeur");
            String tension = getTextFromAccessibleName("Mod_Tension");
            String puissanceUnitaire = getTextFromAccessibleName("Mod_PU");
            String puissanceTransitoire = getTextFromAccessibleName("Mod_PT");
            String indice = getTextFromAccessibleName("Mod_IdC");
            String origineConsommation = getTextFromAccessibleName("Mod_Cons");
            
            if (famille.isEmpty()) famille = "NULL";
            if (sousFamille.isEmpty()) sousFamille = "NULL";
            if (type.isEmpty()) type = "NULL";
            if (constructeur.isEmpty()) constructeur = "NULL";
            if (tension.isEmpty()) tension = "NULL";
            if (puissanceUnitaire.isEmpty()) puissanceUnitaire = "NULL";
            if (puissanceTransitoire.isEmpty()) puissanceTransitoire = "NULL";
            if (indice.isEmpty()) indice = "NULL";
            if (origineConsommation.isEmpty()) origineConsommation = "NULL";
            if (!className.equals(info.get(0))){
                vertex.delete();
                OVertex newVertex = db.newVertex(className);
                newVertex.setProperty("Famille", famille);
                newVertex.setProperty("Type", type);
                newVertex.setProperty("Sous Famille", sousFamille);
                newVertex.setProperty("Constructeur", constructeur);
                newVertex.setProperty("Tension(VCC)", tension);
                newVertex.setProperty("Puissance Unitaire(W)", puissanceUnitaire);
                newVertex.setProperty("Puissance Transitoire(W)", puissanceTransitoire);
                newVertex.setProperty("Indice de confiance", indice);
                newVertex.setProperty("Origine de consommation", origineConsommation);
                newVertex.save();
            }else{
                vertex.setProperty("Famille", famille);
                vertex.setProperty("Type", type);
                vertex.setProperty("Sous Famille", sousFamille);
                vertex.setProperty("Constructeur", constructeur);
                vertex.setProperty("Tension(VCC)", tension);
                vertex.setProperty("Puissance Unitaire(W)", puissanceUnitaire);
                vertex.setProperty("Puissance Transitoire(W)", puissanceTransitoire);
                vertex.setProperty("Indice de confiance", indice);
                vertex.setProperty("Origine de consommation", origineConsommation);
                vertex.save();
            }
            dispose();
        } catch (Exception e) {
            printMessage("Erreur dans la modification : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed
    
    private void setTextToAccessibleName(String accessibleName, String text) {
        setTextToAccessibleNameRecursive(getContentPane(), accessibleName, text);
    }

    private void setTextToAccessibleNameRecursive(java.awt.Container container, String accessibleName, String text) {
    for (java.awt.Component comp : container.getComponents()) {
        // Vérifier si le composant est un JTextField
        if (comp instanceof javax.swing.JTextField) {
            javax.swing.JTextField textField = (javax.swing.JTextField) comp;
            if (accessibleName.equals(textField.getAccessibleContext().getAccessibleName())) {
                textField.setText(text); // Définir le texte
                return; // Arrêter la recherche après modification
            }
        }
        // Vérifier si le composant est un JComboBox
        else if (comp instanceof javax.swing.JComboBox) {
            javax.swing.JComboBox<?> comboBox = (javax.swing.JComboBox<?>) comp;
            if (accessibleName.equals(comboBox.getAccessibleContext().getAccessibleName())) {
                // Vérifier si le texte existe déjà dans la JComboBox
                boolean found = false;
                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    Object item = comboBox.getItemAt(i);
                    if (text.equals(item.toString())) { // Comparer en tant que String
                        comboBox.setSelectedIndex(i); // Sélectionner l'élément existant
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Erreur input");
                }
                return; // Arrêter la recherche après modification
            }
        }
        // Rechercher récursivement dans les sous-conteneurs
        else if (comp instanceof java.awt.Container) {
            setTextToAccessibleNameRecursive((java.awt.Container) comp, accessibleName, text);
        }
    }
}

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
