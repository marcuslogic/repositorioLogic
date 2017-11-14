package br.com.logic.treinamento.dao.impl;

import br.com.logic.treinamento.dao.interfaces.IConnectionBeanLocal;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

@Stateless
public class ConnectionBean implements IConnectionBeanLocal {

    public Connection getConnection() throws Exception {
        InitialContext context = null;
        Connection conn = null;
        try {
            context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:jboss/datasources/TreinamentoDS");
            conn = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
