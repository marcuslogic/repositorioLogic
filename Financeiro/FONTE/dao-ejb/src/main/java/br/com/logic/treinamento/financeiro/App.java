package br.com.logic.treinamento.financeiro;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Hello world!
 */
@Stateless
@Path("teste")
public class App {

    @Inject
    static ContaDAO dao;

    public void teste() throws Exception {

        dao.teste();

    }
}
