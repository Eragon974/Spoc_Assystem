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
public class Modification_Frame extends javax.swing.JFrame {
    private ODatabaseSession db;
    private List<String> info; //Informations de l'objet à modifier
    private String RID; //Case 10 de info
    private List<String> filteredWords; //On ne veut garder que les informations utile (pas le RID de l'objet dans la BDD)

    public Modification_Frame(List<String> info, ODatabaseSession db) {
        this.db = db;
        this.info = info;
        this.RID = info.get(10);
        filteredWords = new ArrayList<>();
        initComponents();
        for (String infos : info) {
            if (!infos.startsWith("ID:") && !infos.startsWith("#")) {
                filteredWords.add(infos.trim());
             }
        }
        
        //Initialisation des informations de infos dans les cases de la Frame
        setTextToAccessibleName("Mod_Classe", filteredWords.get(0)); 
        setTextToAccessibleName("Mod_1", filteredWords.get(1));
        setTextToAccessibleName("Mod_2", filteredWords.get(2));
        setTextToAccessibleName("Mod_3", filteredWords.get(3));
        setTextToAccessibleName("Mod_4", filteredWords.get(4));
        setTextToAccessibleName("Mod_5", filteredWords.get(5));
        setTextToAccessibleName("Mod_6", filteredWords.get(6));
        setTextToAccessibleName("Mod_7", filteredWords.get(7));
        setTextToAccessibleName("Mod_8", filteredWords.get(8));
        setTextToAccessibleName("Mod_9", filteredWords.get(9));
        
    }
    //Permet d'afficher des messages dans la JTextArea
    public void printMessage(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm:ss.SSS");  // Format de l'heure
        String time = sdf.format(new Date());  // Obtenir l'heure actuelle
        String formattedMessage = time + " : " + message + "\n";
        jTextArea1.append(formattedMessage);
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());// Faire défiler jusqu'à la fin pour afficher le dernier message
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

        jLabel6.setText("Tension Circuit de commande (V)");

        jLabel11.setText("Origine consommation ");

        jButton1.setText("Modifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Puissance Unitaire consommée (W)");

        jLabel8.setText("Puissance Eqt fermé");

        jLabel9.setText("Puissance Eqt ouverte");

        jLabel2.setText("Classe");

        jLabel3.setText("Type");

        jLabel4.setText("Tension circuit puissance (V)");

        jLabel5.setText("Constructeur");

        jLabel10.setText("Indice de confiance");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equipement", "Composant" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

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
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jTextField4.getAccessibleContext().setAccessibleName("Mod_3");
        jTextField9.getAccessibleContext().setAccessibleName("Mod_9");
        jTextField5.getAccessibleContext().setAccessibleName("Mod_5");
        jTextField6.getAccessibleContext().setAccessibleName("Mod_6");
        jTextField7.getAccessibleContext().setAccessibleName("Mod_7");
        jTextField1.getAccessibleContext().setAccessibleName("Mod_1");
        jTextField1.getAccessibleContext().setAccessibleDescription("");
        jTextField2.getAccessibleContext().setAccessibleName("Mod_4");
        jTextField3.getAccessibleContext().setAccessibleName("Mod_2");
        jTextField8.getAccessibleContext().setAccessibleName("Mod_8");
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
//Bouton de modification
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OVertex v;
        try {
            ORecordId recordId = new ORecordId(RID);
            v = db.load(recordId); // Récupération de l'objet dans la base de données
            String famille = "NULL";
            String sousFamille = "NULL";
            String type = "NULL";
            String constructeur = "NULL";
            String tension = "NULL";
            String puissanceUnitaire = "NULL";
            String puissanceTransitoire = "NULL";
            String indice = "NULL";
            String origineConsommation = "NULL";
            String TensionCircuiPuissance = "NULL";
            String TensionCircuitCommande = "NULL";
            String PuissanceUnitaireCons = "NULL";
            String PuissanceEqtFermé = "NULL";
            String PuissanceEqtOuverte = "NULL";
            String className = getTextFromAccessibleName("Mod_Classe");
            if (className.equals("Composant")) {
                famille = getTextFromAccessibleName("Mod_1");
                type = getTextFromAccessibleName("Mod_2");
                sousFamille = getTextFromAccessibleName("Mod_3");
                constructeur = getTextFromAccessibleName("Mod_4");
                tension = getTextFromAccessibleName("Mod_5");
                puissanceUnitaire = getTextFromAccessibleName("Mod_6");
                puissanceTransitoire = getTextFromAccessibleName("Mod_7");
                indice = getTextFromAccessibleName("Mod_8");
                origineConsommation = getTextFromAccessibleName("Mod_9");
                if (famille.isEmpty()) famille = "NULL";
                if (sousFamille.isEmpty()) sousFamille = "NULL";
                if (type.isEmpty()) type = "NULL";
                if (constructeur.isEmpty()) constructeur = "NULL";
                if (tension.isEmpty()) tension = "NULL";
                if (puissanceUnitaire.isEmpty()) puissanceUnitaire = "NULL";
                if (puissanceTransitoire.isEmpty()) puissanceTransitoire = "NULL";
                if (indice.isEmpty()) indice = "NULL";
                if (origineConsommation.isEmpty()) origineConsommation = "NULL";
                if (!isNumericAndPositive(tension)) { printMessage("Tension invalide."); return; }
                if (!isNumericAndPositive(puissanceUnitaire)) { printMessage("Puissance Unitaire invalide."); return; }
                if (!isNumericAndPositive(puissanceTransitoire)) { printMessage("Puissance Transitoire invalide."); return; }
                if (!indice.equals("NULL") && !isIndiceValid(indice)) { printMessage("Indice de confiance invalide. Il doit être entre 0 et 1."); return; }
            } else if (className.equals("Equipement")) {
                type = getTextFromAccessibleName("Mod_1");
                constructeur = getTextFromAccessibleName("Mod_2");
                TensionCircuiPuissance = getTextFromAccessibleName("Mod_3");
                TensionCircuitCommande = getTextFromAccessibleName("Mod_4");
                PuissanceUnitaireCons = getTextFromAccessibleName("Mod_5");
                PuissanceEqtFermé = getTextFromAccessibleName("Mod_6");
                PuissanceEqtOuverte = getTextFromAccessibleName("Mod_7");
                indice = getTextFromAccessibleName("Mod_8");
                origineConsommation = getTextFromAccessibleName("Mod_9");
                if (type.isEmpty()) type = "NULL";
                if (constructeur.isEmpty()) constructeur = "NULL";
                if (TensionCircuiPuissance.isEmpty()) TensionCircuiPuissance = "NULL";
                if (TensionCircuitCommande.isEmpty()) TensionCircuitCommande = "NULL";
                if (PuissanceUnitaireCons.isEmpty()) PuissanceUnitaireCons = "NULL";
                if (PuissanceEqtFermé.isEmpty()) PuissanceEqtFermé = "NULL";
                if (PuissanceEqtOuverte.isEmpty()) PuissanceEqtOuverte = "NULL";
                if (indice.isEmpty()) indice = "NULL";
                if (origineConsommation.isEmpty()) origineConsommation = "NULL";
                if (!isNumericAndPositive(TensionCircuiPuissance)) { printMessage("Tension Circuit Puissance invalide."); return; }
                if (!isNumericAndPositive(TensionCircuitCommande)) { printMessage("Tension Circuit Commande invalide."); return; }
                if (!isNumericAndPositive(PuissanceUnitaireCons)) { printMessage("Puissance Unitaire Consommée invalide."); return; }
                if (!isNumericAndPositive(PuissanceEqtFermé)) { printMessage("Puissance Eqt Fermé invalide."); return; }
                if (!isNumericAndPositive(PuissanceEqtOuverte)) { printMessage("Puissance Eqt Ouverte invalide."); return; }
                if (!indice.equals("NULL") && !isIndiceValid(indice)) { printMessage("Indice de confiance invalide. Il doit être entre 0 et 1."); return; }
            }

            if (!className.equals(info.get(0))) {
                v.delete();
                OVertex newVertex = db.newVertex(className);
                if (className.equals("Composant")) {
                    newVertex.setProperty("Famille", famille);
                    newVertex.setProperty("Type", type);
                    newVertex.setProperty("Sous Famille", sousFamille);
                    newVertex.setProperty("Constructeur", constructeur);
                    newVertex.setProperty("Tension(VCC)", tension);
                    newVertex.setProperty("Puissance Unitaire", puissanceUnitaire);
                    newVertex.setProperty("Puissance Transitoire", puissanceTransitoire);
                    newVertex.setProperty("Indice de confiance", indice);
                    newVertex.setProperty("Origine de consommation", origineConsommation);
                    newVertex.save();
                } else if (className.equals("Equipement")) {
                    newVertex.setProperty("Type", type);
                    newVertex.setProperty("Constructeur", constructeur);
                    newVertex.setProperty("Tension Circuit Puissance", TensionCircuiPuissance);
                    newVertex.setProperty("Tension Circuit de commande", TensionCircuitCommande);
                    newVertex.setProperty("Puissance Unitaire consommée", PuissanceUnitaireCons);
                    newVertex.setProperty("Puissance Eqt fermée", PuissanceEqtFermé);
                    newVertex.setProperty("Puissance Eqt ouverte", PuissanceEqtOuverte);
                    newVertex.setProperty("Indice de confiance", indice);
                    newVertex.setProperty("Origine de consommation", origineConsommation);
                    newVertex.save();
                }
            } else if (className.equals("Composant")) {
                v.setProperty("Famille", famille);
                v.setProperty("Type", type);
                v.setProperty("Sous Famille", sousFamille);
                v.setProperty("Constructeur", constructeur);
                v.setProperty("Tension(VCC)", tension);
                v.setProperty("Puissance Unitaire", puissanceUnitaire);
                v.setProperty("Puissance Transitoire", puissanceTransitoire);
                v.setProperty("Indice de confiance", indice);
                v.setProperty("Origine de consommation", origineConsommation);
                v.save();
            } else if (className.equals("Equipement")) {
                v.setProperty("Type", type);
                v.setProperty("Constructeur", constructeur);
                v.setProperty("Tension Circuit Puissance", TensionCircuiPuissance);
                v.setProperty("Tension Circuit de commande", TensionCircuitCommande);
                v.setProperty("Puissance Unitaire consommée", PuissanceUnitaireCons);
                v.setProperty("Puissance Eqt fermée", PuissanceEqtFermé);
                v.setProperty("Puissance Eqt ouverte", PuissanceEqtOuverte);
                v.setProperty("Indice de confiance", indice);
                v.setProperty("Origine de consommation", origineConsommation);
                v.save();
            }
            dispose();
        } catch (Exception e) {
            printMessage("Erreur dans la modification : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//Vérification de la valeur de la Classe pour mettre les bonnes cases à l'affichage
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedItem = (String) jComboBox1.getSelectedItem();
        if ("Equipement".equals(selectedItem)) {
            jLabel3.setText("Type");
            jLabel5.setText("Constructeur");
            jLabel4.setText("Tension circuit puissance (V)");
            jLabel6.setText("Tension Circuit de commande (V)");
            jLabel7.setText("Puissance Unitaire consommée (W)");
            jLabel8.setText("Puissance Eqt fermé");
            jLabel8.setText("Puissance Eqt ouverte");
        }else if ("Composant".equals(selectedItem)) {
            jLabel3.setText("Famille");
            jLabel5.setText("Type");
            jLabel4.setText("Sous Famille");
            jLabel6.setText("Constructeur");
            jLabel7.setText("Tension (VCC)");
            jLabel8.setText("Puissance Unitaire (W)");
            jLabel8.setText("Puissance Transitoire (W)");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
//Vérification valeur numérique
    private boolean isNumericAndPositive(String value) {
        try {
            return value != null && Double.parseDouble(value) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
//Vérification Indice de confiance
    private boolean isIndiceValid(String value) {
        try {
            double d = Double.parseDouble(value);
            return d >= 0 && d <= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

//Modifier les informations d'une case
    private void setTextToAccessibleName(String accessibleName, String text) {
        setTextToAccessibleNameRecursive(getContentPane(), accessibleName, text);
    }
//Recherche de toutes les cases de manière récursive
    private void setTextToAccessibleNameRecursive(java.awt.Container container, String accessibleName, String text) {
    for (java.awt.Component comp : container.getComponents()) {
        if (comp instanceof javax.swing.JTextField) {
            javax.swing.JTextField textField = (javax.swing.JTextField) comp;
            if (accessibleName.equals(textField.getAccessibleContext().getAccessibleName())) {
                textField.setText(text);
                return; 
            }
        }
        else if (comp instanceof javax.swing.JComboBox) {
            javax.swing.JComboBox<?> comboBox = (javax.swing.JComboBox<?>) comp;
            if (accessibleName.equals(comboBox.getAccessibleContext().getAccessibleName())) {
                boolean found = false;
                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    Object item = comboBox.getItemAt(i);
                    if (text.equals(item.toString())) { 
                        comboBox.setSelectedIndex(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    printMessage("Erreur input");
                }
                return;
            }
        }
        // Rechercher récursivement dans les sous-conteneurs
        else if (comp instanceof java.awt.Container) {
            setTextToAccessibleNameRecursive((java.awt.Container) comp, accessibleName, text);
        }
    }
}
//Accéder aux informations d'une case
    public String getTextFromAccessibleName(String accessibleName) {
        return getTextFromAccessibleNameRecursive(getContentPane(), accessibleName);
    }
//Recherche de toutes les cases de manière récursive
    public String getTextFromAccessibleNameRecursive(java.awt.Container container, String accessibleName) {
        for (java.awt.Component comp : container.getComponents()) {
            if (comp instanceof javax.swing.JTextField) {
                javax.swing.JTextField textField = (javax.swing.JTextField) comp;
                if (accessibleName.equals(textField.getAccessibleContext().getAccessibleName())) {
                    return textField.getText();
                }
            }    
            else if (comp instanceof javax.swing.JComboBox) {
                javax.swing.JComboBox<?> comboBox = (javax.swing.JComboBox<?>) comp;
                if (accessibleName.equals(comboBox.getAccessibleContext().getAccessibleName())) {
                    Object selectedItem = comboBox.getSelectedItem();
                    return selectedItem != null ? selectedItem.toString() : ""; 
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
        return ""; 
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
