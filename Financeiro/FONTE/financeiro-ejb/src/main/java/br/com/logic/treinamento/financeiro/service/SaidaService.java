package br.com.logic.treinamento.financeiro.service;

import br.com.logic.treinamento.dao.interfaces.ISaidaDao;
import br.com.logic.treinamento.dao.model.SaidaModel;
import br.com.logic.treinamento.financeiro.interfaces.ISaidaService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class SaidaService implements ISaidaService{

    @Inject
    private ISaidaDao saidaBean;

    public ArrayList<SaidaModel> getTodasSaidas() throws Exception {

        return saidaBean.getSaidas();
    }
}
