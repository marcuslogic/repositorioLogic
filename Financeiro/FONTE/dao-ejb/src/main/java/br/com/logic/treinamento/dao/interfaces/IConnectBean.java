package br.com.logic.treinamento.dao.interfaces;

import javax.ejb.Local;
import java.sql.Connection;
import java.sql.SQLException;

@Local
public interface IConnectBean {

    public Connection connect() throws SQLException;
}
