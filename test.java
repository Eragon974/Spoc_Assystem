orient-commons-*.jar
orientdb-core-*.jar
blueprints-core-*.jar
orientdb-graphdb-*.jar 
(blueprints-orient-graph-*.jar only for OrientDB < v1.7)
//For connection with remote server (not local)
orientdb-client-.jar
orientdb-enterprise-*.jar

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
