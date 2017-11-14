package br.com.logic.treinamento.dao.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Stateless
public class Conexao {

    @Resource(lookup = "java:jboss/datasource/FinanceiroDB")
    private DataSource ds;

    public Connection connect() throws SQLException {
        return ds.getConnection();
    }
}
