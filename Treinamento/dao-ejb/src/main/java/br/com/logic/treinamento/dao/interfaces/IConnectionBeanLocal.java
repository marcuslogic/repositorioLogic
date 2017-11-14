package br.com.logic.treinamento.dao.interfaces;

import javax.ejb.Local;
import java.sql.Connection;

@Local
public interface IConnectionBeanLocal {

    public Connection getConnection() throws Exception;
}
