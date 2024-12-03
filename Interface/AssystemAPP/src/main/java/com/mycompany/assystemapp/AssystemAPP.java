package com.mycompany.assystemapp;

import javax.swing.SwingUtilities;

public class AssystemAPP {
    public static void main(String[] args) {
        // Utiliser SwingUtilities pour s'assurer que la création de la GUI se fait sur le thread de l'Event Dispatch
        SwingUtilities.invokeLater(() -> {
            // Créer une instance de Welcome_Page
            Welcome_Page welcomePage = new Welcome_Page();
            welcomePage.setVisible(true); // Rendre le JFrame visible
        });
    }
}