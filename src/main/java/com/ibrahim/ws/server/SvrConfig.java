package com.ibrahim.ws.server;

import com.ibrahim.data.DbConfig;

/**
 * Created by ibrahim on 3/22/18.
 */
public class SvrConfig {
    private String listenHostname = "localhost";
    private String listenPort = "9999";
    private String listenInterface = "HelloWorld";
    private String listenProtocol = "http";
    private DbConfig dbCfg = new DbConfig();

    public SvrConfig(){

    }

    public String getListenHostname() {
        return listenHostname;
    }

    public void setListenHostname(String listenHostname) {
        this.listenHostname = listenHostname;
    }

    public String getListenPort() {
        return listenPort;
    }

    public void setListenPort(String listenPort) {
        this.listenPort = listenPort;
    }

    public String getListenInterface() {
        return listenInterface;
    }

    public void setListenInterface(String listenInterface) {
        this.listenInterface = listenInterface;
    }

    public String getListenProtocol() {
        return listenProtocol;
    }

    public void setListenProtocol(String listenProtocol) {
        this.listenProtocol = listenProtocol;
    }

    public DbConfig getDbCfg() {
        return dbCfg;
    }

    public void setDbCfg(DbConfig dbCfg) {
        this.dbCfg = dbCfg;
    }
}
