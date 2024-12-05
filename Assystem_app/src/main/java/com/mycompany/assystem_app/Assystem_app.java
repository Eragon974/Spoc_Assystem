package com.mycompany.assystem_app;

import java.util.ArrayList;
import java.util.List;

import com.aspose.cells.Cell;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;


 
public class Assystem_app {

    public static void main(String[] args) throws Exception {
        // LINK TO LOCALHOST
        /*OrientDB orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        String dbName = "test";
        if (!orientDB.exists(dbName)) {
            // Création de la base de données
            orientDB.create(dbName, ODatabaseType.PLOCAL);
            
            // Ajout d'un utilisateur admin
            orientDB.open(dbName, "root", "root").command(
                "CREATE USER admin IDENTIFIED BY 'admin' ROLE admin"
            ).close();
        }
        // CREATE SESSION POOL
        OrientDBConfigBuilder poolCfg = OrientDBConfig.builder();
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MIN, 5);
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MAX, 10);

        ODatabasePool pool = new ODatabasePool(orientDB, dbName, "admin", "admin", poolCfg.build());
        
        // OPEN DATABASE
        try (ODatabaseSession db = pool.acquire()) {
            // CREATE CLASSES IF THEY DO NOT EXIST
            if (db.getMetadata().getSchema().getClass("Armoire") == null) {
                db.createVertexClass("Armoire");
            }
            if (db.getMetadata().getSchema().getClass("Prise") == null) {
                db.createVertexClass("Prise");
            }
            if (db.getMetadata().getSchema().getClass("Linked") == null) {
                db.createEdgeClass("Linked");
            }

            // CREATE VERTICES
            OVertex v1 = db.newVertex("Armoire");
            v1.setProperty("name","A1");
            OVertex v2 = db.newVertex("Prise");
            v2.setProperty("name","P1");

            // LINKING THE VERTICES WITH AN EDGE
            v1.addEdge(v2, "Linked");
            
            v1.save();
            v2.save();
        }
        // CLOSE SESSION AND CONNECTION
        pool.close();
        orientDB.close();*/
        ExtractDataFromExcel();
    }

public static int levenshtein(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
        for (int j = 0; j <= b.length(); j++) {
            if (i == 0) {
                dp[i][j] = j;
            } else if (j == 0) {
                dp[i][j] = i;
            } else {
                dp[i][j] = Math.min(
                    dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1),
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                );
            }
        }
    }

    return dp[a.length()][b.length()];  
}
public static List<List<String>> ExtractDataFromExcel() throws Exception {
        // Chemin du fichier Excel
        String path = "C:\\Users\\frate\\OneDrive\\Bureau\\Insa\\TC\\4TC\\SPOC\\Exemple fichier BdP v2.xlsb";

        // Charger le fichier Excel
        Workbook workbook = new Workbook(path);

        // Accéder à la fiche de travail
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Accéder aux données de la cellule (par exemple, A1)
        Cell cell = worksheet.getCells().get("A1");
        System.out.println("Data in cell A1: " + cell.getStringValue());

        // Accéder et parcourir les lignes et les colonnes
        return getworksheet(worksheet);
        }
public static List<List<String>> getworksheet(Worksheet worksheet){
    
    List<String> familles = new ArrayList<>();
    List<String> sous_familles = new ArrayList<>();
    List<String> types = new ArrayList<>();
    List<String> constructeurs = new ArrayList<>();

    for (int row = 0; row < worksheet.getCells().getMaxDataRow() + 1; row++) {
        List<String> rowList = new ArrayList<>();
        for (int col = 2; col < 6; col++) {
            Cell dataCell = worksheet.getCells().get(row, col);
            rowList.add(dataCell.getStringValue());
        }
        //ajout de chaque élément de la ligne dans les listes
        familles.add(rowList.get(0));
        sous_familles.add(rowList.get(1));
        types.add(rowList.get(2));
        constructeurs.add(rowList.get(3));

        }
    List<List<String>> result = new ArrayList<>();
    result.add(familles);
    result.add(sous_familles);
    result.add(types);
    result.add(constructeurs);
    System.out.println(result);
    return result;
    }
}








