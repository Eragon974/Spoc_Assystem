package com.mycompany.assystemapp;

import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.record.OElement;
import com.orientechnologies.orient.core.record.OVertex;

public class OrientDB_test {
    public static void main(String[] args) {
        // CREATE ORIENT DB
        OrientDB orientDB = new OrientDB("embedded:/tmp/",OrientDBConfig.defaultConfig());
        orientDB.create("test",ODatabaseType.PLOCAL);
        // CREATE SESSION POOL
        OrientDBConfigBuilder poolCfg = OrientDBConfig.builder();
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MIN, 5);
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MAX, 10);

        ODatabasePool pool = new ODatabasePool(orientDB,"test","admin","admin", poolCfg.build());
        // OPEN DATABASE
        try (ODatabaseSession db = pool.acquire()) {
            OElement d = db.newInstance("DocClass");
            d.setProperty("foo", "Bar");
            d.save();

            OVertex v1 = db.newVertex("VertexClass");
            v1.setProperty("foo", "One");
            v1.save();

            OVertex v2 = db.newVertex("VertexClass");
            v2.setProperty("foo", "Two");
            v2.save();

            v1.addEdge(v2, "EdgeClass").save();

            db.commit();
            db.shutdown();
        }
        pool.close();
        orientDB.close();
    }
}
