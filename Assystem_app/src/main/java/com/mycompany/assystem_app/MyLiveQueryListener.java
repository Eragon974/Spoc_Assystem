package com.mycompany.assystem_app;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.db.OLiveQueryResultListener;
import com.orientechnologies.common.exception.OException;
public class MyLiveQueryListener implements OLiveQueryResultListener{

    @Override
    public void onCreate(ODatabaseDocument odd, OResult or) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void onUpdate(ODatabaseDocument odd, OResult or, OResult or1) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void onDelete(ODatabaseDocument odd, OResult or) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void onError(ODatabaseDocument odd, OException oe) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void onEnd(ODatabaseDocument odd) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}