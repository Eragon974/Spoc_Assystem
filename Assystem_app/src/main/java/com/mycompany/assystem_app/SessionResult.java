package com.mycompany.assystem_app;

import com.orientechnologies.orient.core.db.ODatabasePool;
import com.orientechnologies.orient.core.db.ODatabaseSession;

public class SessionResult {
    private ODatabasePool pool;
    private ODatabaseSession db;

    public SessionResult(ODatabasePool pool, ODatabaseSession db) {
        this.pool = pool;
        this.db = db;
    }

    public ODatabasePool getPool() {
        return pool;
    }

    public ODatabaseSession getDb() {
        return db;
    }
}
