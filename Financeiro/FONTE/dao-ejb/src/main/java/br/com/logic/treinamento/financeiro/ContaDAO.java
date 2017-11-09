package br.com.logic.treinamento.financeiro;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Stateless
public class ContaDAO {

    @Resource(name = "FinanceiroDB")
    private DataSource ds;

    public void teste() throws Exception {
        Connection connection = ds.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("CREATE TABLE movie ( director VARCHAR(255), title VARCHAR(255), year integer)");
            stmt.execute();
        } finally {
            connection.close();
        }
    }

    @PostConstruct
    public void teste2() throws Exception {
        Connection connection = ds.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("CREATE TABLE movie ( director VARCHAR(255), title VARCHAR(255), year integer)");
            stmt.execute();
        } finally {
            connection.close();
        }
    }
}
