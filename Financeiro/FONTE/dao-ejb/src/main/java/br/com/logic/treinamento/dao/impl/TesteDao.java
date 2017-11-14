package br.com.logic.treinamento.dao.impl;

import javax.ejb.Stateless;

@Stateless(mappedName = "SaidaDao")
public class TesteDao {

    public void testeEjb() {
        System.out.print("teste realizado");
    }
}
