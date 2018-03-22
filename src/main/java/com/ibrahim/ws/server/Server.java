package com.ibrahim.ws.server;

import com.ibrahim.data.DbConfig;
import com.ibrahim.ws.hello.HelloWorld;

import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointReference;
import java.util.logging.Logger;

/**
 * Created by ibrahim on 3/22/18.
 */
public class Server {
    private static final Logger LOG = Logger.getLogger(Server.class.getName());
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_HOST = "saintmonica";
    private static final String DB_PORT = "3306";
    private static final String DB_SID = "employees";
    private static final String DB_USER = "empl_1";
    private static final String DB_PSW = "password";
    private Server(){

    }

    protected static DbConfig getDbConfig(){
        DbConfig dbCfg = new DbConfig();
        dbCfg.setDriverName(MYSQL_DRIVER);
        dbCfg.setHost(DB_HOST);
        dbCfg.setPort(DB_PORT);
        dbCfg.setDb(DB_SID);
        dbCfg.setUid(DB_USER);
        dbCfg.setPsw(DB_PSW);
        return dbCfg;
    }

    private static final String HOST_NAME = "localhost";
    private static final String PORT_NO = "9999";
    private static final String HELLO_SVC_NAME ="java-ws/hello";
    private static final String RPC_EMPL_SVC_NAME = "rpc/employees";
    private static final String DOC_EMPL_SVC_NAME = "doc/employees";
    private static final String PROTOCOL = "http";

    protected static SvrConfig getSvrConfig(){
        SvrConfig svrCfg = new SvrConfig();
        svrCfg.setListenHostname(HOST_NAME);
        svrCfg.setListenPort(PORT_NO);
        svrCfg.setListenInterface(HELLO_SVC_NAME);
        svrCfg.setListenProtocol(PROTOCOL);
        return svrCfg;
    }

    protected static Endpoint publish(SvrConfig cfg, Object svc){
        String url = String.format("%s://%s:%s/%s",
                cfg.getListenProtocol(),
                cfg.getListenHostname(),
                cfg.getListenPort(),
                cfg.getListenInterface());
        Endpoint ep = Endpoint.publish(url, svc);
        EndpointReference epr = ep.getEndpointReference();
        LOG.info("\nEndpoint Ref:\n"+epr.toString());
        return ep;
    }

    protected static void startHelloWorld(){
        SvrConfig cfg = getSvrConfig();
        cfg.setListenHostname(HOST_NAME);
        cfg.setListenInterface(HELLO_SVC_NAME);
        cfg.setListenPort(PORT_NO);
        cfg.setListenProtocol(PROTOCOL);

        HelloWorld hello = new HelloWorld();
        publish(cfg, hello);
        LOG.info("Hello Worls Service started successfully");
    }

    public static void main(String[] args){
        startHelloWorld();
    }
}
