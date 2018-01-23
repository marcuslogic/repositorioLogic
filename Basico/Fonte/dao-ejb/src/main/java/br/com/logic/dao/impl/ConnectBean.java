package br.com.logic.dao.impl;

import br.com.logic.dao.interfaces.IConnectBean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Stateless
public class ConnectBean implements IConnectBean{

    @Resource(name = "TreinamentoDS")
    private DataSource TreinamentoDS;

    public Connection getConnection() throws SQLException {
        return TreinamentoDS.getConnection();
    }
}
