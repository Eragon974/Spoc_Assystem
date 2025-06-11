/*
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt pour modifier ce fichier de licence
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java pour éditer ce modèle
 */
package com.mycompany.assystem_app;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.OVertex;

/**
 * Fenêtre de modification d'un objet (Composant ou Equipement) dans la base de données.
 */
public class Modification_Frame extends javax.swing.JFrame {
    private ODatabaseSession db; // Session de base de données OrientDB
    private List<String> info; // Informations de l'objet à modifier
    private String RID; // RID de l'objet (case 10 de info)
    private List<String> filteredWords; // Liste filtrée des informations utiles (sans le RID)

    /**
     * Constructeur de la fenêtre de modification.
     * @param info Liste des informations de l'objet à modifier
     * @param db Session de base de données
     */
    public Modification_Frame(List<String> info, ODatabaseSession db) {
        this.db = db;
        this.info = info;
        this.RID = info.get(10);
        filteredWords = new ArrayList<>();
        initComponents();
        // Filtrer les informations pour ne garder que les champs utiles
        for (String infos : info) {
            if (!infos.startsWith("ID:") && !infos.startsWith("#")) {
                filteredWords.add(infos.trim());
             }
        }
        // Initialisation des champs de la fenêtre avec les informations de l'objet
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

    /**
     * Permet d'afficher des messages dans la JTextArea avec l'heure courante.
     * @param message Message à afficher
     */
    public void printMessage(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm:ss.SSS");  // Format de l'heure
        String time = sdf.format(new Date());  // Obtenir l'heure actuelle
        String formattedMessage = time + " : " + message + "\n";
        jTextArea1.append(formattedMessage);
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength()); // Faire défiler jusqu'à la fin
    }

    /**
     * Cette méthode est appelée dans le constructeur pour initialiser la fenêtre.
     * ATTENTION : Ne pas modifier ce code généré automatiquement par l'éditeur de formulaire.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Code généré par l'éditeur de formulaire">//GEN-BEGIN:initComponents
    private void initComponents() {
        // ... (code généré automatiquement, inchangé)
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action du bouton "Modifier" : met à jour l'objet dans la base de données.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OVertex v;
        try {
            ORecordId recordId = new ORecordId(RID);
            v = db.load(recordId); // Récupération de l'objet dans la base de données
            // Initialisation des variables pour les propriétés
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

            // Récupération des valeurs selon la classe (Composant ou Equipement)
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

                // Remplacement des champs vides par "NULL"
                if (famille.isEmpty()) famille = "NULL";
                if (sousFamille.isEmpty()) sousFamille = "NULL";
                if (type.isEmpty()) type = "NULL";
                if (constructeur.isEmpty()) constructeur = "NULL";
                if (tension.isEmpty()) tension = "NULL";
                if (puissanceUnitaire.isEmpty()) puissanceUnitaire = "NULL";
                if (puissanceTransitoire.isEmpty()) puissanceTransitoire = "NULL";
                if (indice.isEmpty()) indice = "NULL";
                if (origineConsommation.isEmpty()) origineConsommation = "NULL";

                // Vérification des champs numériques
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

                // Remplacement des champs vides par "NULL"
                if (type.isEmpty()) type = "NULL";
                if (constructeur.isEmpty()) constructeur = "NULL";
                if (TensionCircuiPuissance.isEmpty()) TensionCircuiPuissance = "NULL";
                if (TensionCircuitCommande.isEmpty()) TensionCircuitCommande = "NULL";
                if (PuissanceUnitaireCons.isEmpty()) PuissanceUnitaireCons = "NULL";
                if (PuissanceEqtFermé.isEmpty()) PuissanceEqtFermé = "NULL";
                if (PuissanceEqtOuverte.isEmpty()) PuissanceEqtOuverte = "NULL";
                if (indice.isEmpty()) indice = "NULL";
                if (origineConsommation.isEmpty()) origineConsommation = "NULL";

                // Vérification des champs numériques
                if (!isNumericAndPositive(TensionCircuiPuissance)) { printMessage("Tension Circuit Puissance invalide."); return; }
                if (!isNumericAndPositive(TensionCircuitCommande)) { printMessage("Tension Circuit Commande invalide."); return; }
                if (!isNumericAndPositive(PuissanceUnitaireCons)) { printMessage("Puissance Unitaire Consommée invalide."); return; }
                if (!isNumericAndPositive(PuissanceEqtFermé)) { printMessage("Puissance Eqt Fermé invalide."); return; }
                if (!isNumericAndPositive(PuissanceEqtOuverte)) { printMessage("Puissance Eqt Ouverte invalide."); return; }
                if (!indice.equals("NULL") && !isIndiceValid(indice)) { printMessage("Indice de confiance invalide. Il doit être entre 0 et 1."); return; }
            }

            // Si la classe a changé, suppression de l'ancien objet et création d'un nouveau
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
                // Mise à jour des propriétés pour un Composant
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
                // Mise à jour des propriétés pour un Equipement
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
            dispose(); // Fermer la fenêtre après modification
        } catch (Exception e) {
            printMessage("Erreur dans la modification : " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Action lors du changement de sélection dans la ComboBox de classe.
     * Met à jour les labels selon la classe sélectionnée.
     */
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

    /**
     * Vérifie si une chaîne est un nombre positif.
     * @param value Valeur à vérifier
     * @return true si numérique et positif, false sinon
     */
    private boolean isNumericAndPositive(String value) {
        try {
            return value != null && Double.parseDouble(value) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Vérifie si l'indice de confiance est valide (entre 0 et 1).
     * @param value Valeur à vérifier
     * @return true si valide, false sinon
     */
    private boolean isIndiceValid(String value) {
        try {
            double d = Double.parseDouble(value);
            return d >= 0 && d <= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Modifie le texte d'un champ identifié par son AccessibleName.
     * @param accessibleName Nom accessible du champ
     * @param text Texte à mettre
     */
    private void setTextToAccessibleName(String accessibleName, String text) {
        setTextToAccessibleNameRecursive(getContentPane(), accessibleName, text);
    }

    /**
     * Recherche récursive d'un champ par AccessibleName et modification de son texte.
     */
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
            // Recherche récursive dans les sous-conteneurs
            else if (comp instanceof java.awt.Container) {
                setTextToAccessibleNameRecursive((java.awt.Container) comp, accessibleName, text);
            }
        }
    }

    /**
     * Récupère le texte d'un champ identifié par son AccessibleName.
     * @param accessibleName Nom accessible du champ
     * @return Texte du champ
     */
    public String getTextFromAccessibleName(String accessibleName) {
        return getTextFromAccessibleNameRecursive(getContentPane(), accessibleName);
    }

    /**
     * Recherche récursive d'un champ par AccessibleName et retourne son texte.
     */
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
            // Recherche récursive dans les sous-conteneurs
            else if (comp instanceof java.awt.Container) {
                String result = getTextFromAccessibleNameRecursive((java.awt.Container) comp, accessibleName);
                if (!result.isEmpty()) {
                    return result;
                }
            }
        }
        return ""; 
    }

    // Déclaration des variables de la fenêtre (généré automatiquement)
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
