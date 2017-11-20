package br.com.logic.dao.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Stateless
public class ConnectBean {

    @Resource(name = "TreinamentoDS")
    private DataSource ds;

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
