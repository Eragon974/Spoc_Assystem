/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.assystem_app;


import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.geom.Point3;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.graphicGraph.GraphicNode;
import org.graphstream.ui.graphicGraph.GraphicEdge;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.graphicGraph.GraphicElement;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
public class Graphe extends javax.swing.JFrame implements KeyListener {
    private ODatabasePool pool;
    private ODatabaseSession db;
    private Interface_app Interface_app;
    private Graph graph;
    private Viewer viewer;
    private String selectedNodeId = null; // Pour stocker le nœud sélectionné
    private String selectedEdgeId = null; // Pour stocker l'arête sélectionnée
    private Edge selectedEdge = null; // Pour stocker l'arête sélectionnée pour la suppression

    public Graphe(ODatabasePool pool,Interface_app Interface_app) {
        this.pool = pool;
        this.Interface_app = Interface_app;
        initComponents();
        createGraph();
        setupInteractions();
    }
    private void createGraph() {
        // Créer un graphe GraphStream
        graph = new SingleGraph("OrientDB Graph");

        // Configurer le style du graphe
        graph.setAttribute("ui.stylesheet", 
            "node { fill-color: red; } " +
            "node.selected { fill-color: yellow; } " +
            "edge { fill-color: blue; } " +
            "edge.selected { fill-color: green; }");

        // Créer un viewer pour afficher le graphe dans jPanel1
        viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        JPanel viewPanel = (JPanel) viewer.addDefaultView(false); // false pour ne pas utiliser OpenGL
        viewPanel.addKeyListener(this); // Ajouter un KeyListener pour gérer les événements clavier
        viewPanel.setFocusable(true); // Ensure the panel can receive key events
        viewer.getDefaultView().enableMouseOptions(); // Activer les interactions de la souris
        
        // Ajouter le viewer à jPanel1
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(viewPanel, java.awt.BorderLayout.CENTER);
    }

    private void setupInteractions() {
        ViewerPipe viewerPipe = viewer.newViewerPipe();
        viewerPipe.addViewerListener(new ViewerListener() {
            @Override
            public void viewClosed(String viewName) {
                // Ignorer
            }

            @Override
            public void buttonPushed(String elementId) {
                if (graph.getNode(elementId) != null) {
                    // Clic sur un nœud
                    handleNodeClick(elementId);
                }

                java.awt.Point mousePoint = ((JPanel)viewer.getDefaultView()).getMousePosition();
                if (mousePoint != null) {
                    handleEdgeClick((float)mousePoint.getX(), (float)mousePoint.getY());
                }
            }

            @Override
            public void buttonReleased(String elementId) {
                // Ignorer
            }

            @Override
            public void mouseOver(String edgeId) {
                // Ignorer
            }

            @Override
            public void mouseLeft(String edgeId) {
                // Ignorer
            }
        });
        new Thread(() -> {
            while (true) {
                try {
                    viewerPipe.pump();
                    Thread.sleep(10); // Small delay to avoid excessive CPU usage
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //Gestion des événements clavier pour supprimer une arête sélectionnée
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE && selectedEdge != null) {
            graph.removeEdge(selectedEdge); // Remove the selected edge
            selectedEdge = null; // Clear the selected edge
            System.out.println("Edge deleted.");
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (selectedNodeId != null) {
                graph.getNode(selectedNodeId).removeAttribute("ui.class"); // Remove highlight from selected node
                selectedNodeId = null; // Clear the selected node
            }
            if (selectedEdge != null) {
                selectedEdge.removeAttribute("ui.class"); // Remove highlight from selected edge
                selectedEdge = null; // Clear the selected edge
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used but required by KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used but required by KeyListener interface
    }

    private void handleNodeClick(String nodeId) {
        if (selectedNodeId == null) {
            // Si aucun nœud n'est sélectionné, sélectionner ce nœud
            selectedNodeId = nodeId;
            graph.getNode(nodeId).setAttribute("ui.class", "selected"); // Mettre en surbrillance
        } else {
            // Si un nœud est déjà sélectionné, créer une arête entre les deux nœuds
            if (selectedNodeId.equals(nodeId)) {
                // Si le même nœud est cliqué, le désélectionner
                graph.getNode(selectedNodeId).removeAttribute("ui.class"); // Retirer la surbrillance
                selectedNodeId = null; // Réinitialiser la sélection
                return;
            }
            graph.addEdge(selectedNodeId + "-" + nodeId, selectedNodeId, nodeId);
            graph.getNode(selectedNodeId).removeAttribute("ui.class"); // Retirer la surbrillance
            selectedNodeId = null; // Réinitialiser la sélection
        }
    }

    private void handleEdgeClick(float mouseX, float mouseY) {
        Edge clickedEdge = selectEdge(mouseX, mouseY);
        if (clickedEdge != null) {
            if (selectedEdge != null) {
                selectedEdge.removeAttribute("ui.class"); // Remove highlight from previously selected edge
            }
            selectedEdge = clickedEdge;
            selectedEdge.setAttribute("ui.class", "selected"); // Highlight the selected edge
        }
    }

    private Edge selectEdge(double mouseX, double mouseY) {
        final double maxDistance = 10; // Maximum distance for edge selection (in pixels)
        final GraphicEdge[] closestEdge = {null}; // Store the closest edge
        final double[] minDistance = {Double.MAX_VALUE}; // Store the minimum distance
    
        GraphicGraph gg = (GraphicGraph) viewer.getGraphicGraph();
    
        // Iterate through all edges in the graph
        gg.edges().forEach(ge -> {
            // Get the two nodes connected by the edge
            GraphicNode gn0 = (GraphicNode) ge.getNode0();
            GraphicNode gn1 = (GraphicNode) ge.getNode1();
    
            // Transform node coordinates from graph units (GU) to pixel coordinates (PX)
            Point3 gn0p = viewer.getDefaultView().getCamera().transformGuToPx(gn0.getX(), gn0.getY(), gn0.getZ());
            Point3 gn1p = viewer.getDefaultView().getCamera().transformGuToPx(gn1.getX(), gn1.getY(), gn1.getZ());
    
            // Vector math: Calculate the perpendicular distance from the mouse to the line segment
            double x1 = gn0p.x, y1 = gn0p.y;
            double x2 = gn1p.x, y2 = gn1p.y;
    
            double dx = x2 - x1;
            double dy = y2 - y1;
    
            if (dx == 0 && dy == 0) {
                // Edge is a point (invalid case)
                return;
            }
    
            // Parametric projection of the mouse point onto the line segment
            double t = ((mouseX - x1) * dx + (mouseY - y1) * dy) / (dx * dx + dy * dy);
    
            // Clamp t to [0, 1] to ensure the projection lies on the segment
            t = Math.max(0, Math.min(1, t));
    
            // Closest point on the line segment to the mouse
            double closestX = x1 + t * dx;
            double closestY = y1 + t * dy;
    
            // Distance from the mouse to the closest point
            double distance = Math.sqrt((mouseX - closestX) * (mouseX - closestX) + (mouseY - closestY) * (mouseY - closestY));
    
            // Check if the distance is within the threshold
            if (distance < maxDistance && distance < minDistance[0]) {
                minDistance[0] = distance;
                closestEdge[0] = (GraphicEdge) ge;
            }
        });
    
        // Return the closest edge if found
        if (closestEdge[0] != null) {
            System.out.println("Selected edge: " + closestEdge[0].getId());
            return graph.getEdge(closestEdge[0].getId());
        }
    
        return null;
        }

        private void saveGraphToOrientDB() {
            // Create OrientGraph with auto transactions disabled
            OrientGraph orientGraph = new OrientGraph("plocal:C:/temp/graph/test", false);
    
            try {
                // Configure the schema for graph elements
                configureGraphSchema(orientGraph);
    
                // Begin transaction manually
                orientGraph.begin();
    
                // Clear existing graph data (optional, depending on your requirements)
                for (com.tinkerpop.blueprints.Vertex vertex : orientGraph.getVertices()) {
                    orientGraph.removeVertex(vertex);
                }
                for (com.tinkerpop.blueprints.Edge edge : orientGraph.getEdges()) {
                    orientGraph.removeEdge(edge);
                }
    
                // Create a map to store node IDs and their corresponding OrientVertex objects
                Map<String, com.tinkerpop.blueprints.Vertex> nodeMap = new HashMap<>();
    
                // Create vertices for all nodes in the GraphStream graph
                for (org.graphstream.graph.Node node : this.graph.nodes().collect(Collectors.toList())) {
                    com.tinkerpop.blueprints.Vertex vertex = orientGraph.addVertex("class:V");
                    vertex.setProperty("nodeId", node.getId());  // Using "nodeId" instead of "id"
    
                    // Store ui.label if present
                    if (node.hasAttribute("ui.label")) {
                        vertex.setProperty("label", node.getAttribute("ui.label").toString());
                    }
    
                    // Save node position if available
                    if (node.hasAttribute("xyz")) {
                        double[] pos = (double[]) node.getAttribute("xyz");
                        vertex.setProperty("x", pos[0]);
                        vertex.setProperty("y", pos[1]);
                        vertex.setProperty("z", pos.length > 2 ? pos[2] : 0.0);
                    }
    
                    nodeMap.put(node.getId(), vertex);
                }
    
                // Create edges
                for (org.graphstream.graph.Edge edge : this.graph.edges().collect(Collectors.toList())) {
                    String sourceId = edge.getSourceNode().getId();
                    String targetId = edge.getTargetNode().getId();
    
                    if (nodeMap.containsKey(sourceId) && nodeMap.containsKey(targetId)) {
                        com.tinkerpop.blueprints.Vertex source = nodeMap.get(sourceId);
                        com.tinkerpop.blueprints.Vertex target = nodeMap.get(targetId);
    
                        com.tinkerpop.blueprints.Edge oEdge = orientGraph.addEdge(null, source, target, "E");
                        oEdge.setProperty("edgeId", edge.getId());  // Using "edgeId" instead of "id"
    
                        if (edge.hasAttribute("weight")) {
                            oEdge.setProperty("weight", edge.getAttribute("weight"));
                        }
    
                        if (edge.hasAttribute("label")) {
                            oEdge.setProperty("label", edge.getAttribute("label").toString());
                        }
                    }
                }

            // Commit transaction
            orientGraph.commit();

            Interface_app.printMessage("Graphe sauvegardé avec succès dans OrientDB");
        } catch (Exception e) {
            // Rollback in case of error
            orientGraph.rollback();
            e.printStackTrace();
            Interface_app.printMessage("Erreur lors de la sauvegarde du graphe: " + e.getMessage());
        } finally {
            orientGraph.shutdown();
        }
    }

    private void configureGraphSchema(OrientGraph graph) {
        ODatabaseDocumentTx db = graph.getRawGraph();

        // Create vertex class
        OClass vertexClass = db.getMetadata().getSchema().getClass("V");
        if (vertexClass == null) {
            vertexClass = db.getMetadata().getSchema().createClass("V");
        }

        // Create edge class
        OClass edgeClass = db.getMetadata().getSchema().getClass("E");
        if (edgeClass == null) {
            edgeClass = db.getMetadata().getSchema().createClass("E");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Ajouter un noeud");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Supprimer ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );

        jButton3.setText("Renommer un noeud");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sauvegarder");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(0, 675, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Graphe OrientDB", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1201, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Graphe Tableau électrique", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Afficher une fenêtre de dialogue personnalisée pour sélectionner un élément
        JDialog dialog = new JDialog(this, "Sélectionnez un élément", true);
        dialog.setSize(500, 400);
        dialog.setLayout(new java.awt.BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Créer des copies des tables au lieu d'utiliser les originales
        JTable equipementsTable = new JTable(Interface_app.jTable1.getModel());
        equipementsTable.setSelectionMode(Interface_app.jTable1.getSelectionModel().getSelectionMode());
        JScrollPane scrollPane1 = new JScrollPane(equipementsTable);
        tabbedPane.addTab("Equipements", scrollPane1);

        // Créer une copie de la deuxième table
        JTable composantsTable = new JTable(Interface_app.jTable2.getModel());
        composantsTable.setSelectionMode(Interface_app.jTable2.getSelectionModel().getSelectionMode());
        JScrollPane scrollPane2 = new JScrollPane(composantsTable);
        tabbedPane.addTab("Composants", scrollPane2);

        // Ajouter un bouton de confirmation
        JButton confirmButton = new JButton("Confirmer");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);

        dialog.add(tabbedPane, java.awt.BorderLayout.CENTER);
        dialog.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        // Variables pour stocker l'élément sélectionné
        final String[] selectedId = {null};
        final int[] selectedTab = {-1};

        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            int tab = tabbedPane.getSelectedIndex();
            JTable selectedTable = tab == 0 ? equipementsTable : composantsTable;
            
            int selectedRow = selectedTable.getSelectedRow();
            if (selectedRow != -1) {
                selectedId[0] = selectedTable.getValueAt(selectedRow, 0).toString();
                selectedTab[0] = tab;
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, 
                "Veuillez sélectionner un élément dans la table.", 
                "Aucune sélection", 
                JOptionPane.WARNING_MESSAGE);
            }
            }
        });

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // Code exécuté après la fermeture de la boîte de dialogue
        if (selectedId[0] != null) {
            // Créer un nouveau nœud avec l'ID sélectionné
            String nodeId = selectedId[0];
            graph.addNode(nodeId);
            
            // Vous pouvez ajouter d'autres attributs basés sur la ligne sélectionnée
            graph.getNode(nodeId).setAttribute("ui.label", nodeId);
        } else {
            // Fallback: créer un nœud avec un ID automatique si aucun élément n'a été sélectionné
            String nodeId = "N" + graph.getNodeCount();
            graph.addNode(nodeId);
            graph.getNode(nodeId).setAttribute("ui.label", nodeId);
        }
        }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (selectedNodeId != null) {
                    graph.removeNode(selectedNodeId); // Supprimer le nœud sélectionné
                    selectedNodeId = null;
                } else if (selectedEdgeId != null) {
                    graph.removeEdge(selectedEdgeId); // Supprimer l'arête sélectionnée
                    selectedEdgeId = null;
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (selectedNodeId != null) {
                    String newName = JOptionPane.showInputDialog("Entrez le nouveau nom du nœud :");
                    if (newName != null && !newName.trim().isEmpty()) {
                        Node node = graph.getNode(selectedNodeId);
                        node.setAttribute("ui.label", newName);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun nœud sélectionné !");
                }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (pool == null) {
            Interface_app.printMessage("Action impossible, la connexion n'est pas établie");
            return;
        }
        saveGraphToOrientDB();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
