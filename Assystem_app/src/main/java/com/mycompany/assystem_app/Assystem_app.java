package com.mycompany.assystem_app;

import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.db.OrientDBConfigBuilder;
import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.OVertex;

public class Assystem_app {

    public static void main(String[] args) {
        // LINK TO LOCALHOST
        OrientDB orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        String dbName = "test";
        if (!orientDB.exists(dbName)) {
            // Création de la base de données
            orientDB.create(dbName, ODatabaseType.PLOCAL);
            
            // Ajout d'un utilisateur admin
            orientDB.open(dbName, "root", "admin").command(
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
        orientDB.close();
    }
}
