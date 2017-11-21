package br.com.logic.treinamento.financeiro.impl;

import br.com.logic.treinamento.dao.interfaces.ISaidaDaoLocal;
import br.com.logic.treinamento.dao.model.SaidaModel;
import br.com.logic.treinamento.financeiro.interfaces.ISaidaBeanLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class SaidaBean implements ISaidaBeanLocal{

    @Inject
    private ISaidaDaoLocal saidaDao;

    public ArrayList<SaidaModel> getSaidas() throws Exception {
        return saidaDao.getSaidas();
    }

    public SaidaModel insertSaida (SaidaModel saidaInsert) throws Exception {
        return saidaDao.insertSaida(saidaInsert);
    }

    public SaidaModel updateSaida (SaidaModel saidaUpdate) throws Exception {
        return saidaDao.updateSaida(saidaUpdate);
    }

    public SaidaModel deleteSaida (SaidaModel saidaDelete) throws Exception {
        return saidaDao.deleteSaida(saidaDelete);
    }

    public ArrayList<SaidaModel> getSaidasByData (SaidaModel saidaData) throws Exception {
        return saidaDao.getSaidasByData(saidaData);
    }

    public ArrayList<SaidaModel> getSaidasByDescricao (SaidaModel saidaDescricao) throws Exception {
        return saidaDao.getSaidasByDescricao(saidaDescricao);
    }

    public ArrayList<SaidaModel> getSaidasByTipo (SaidaModel saidaTipo) throws Exception {
        return saidaDao.getSaidasByTipo(saidaTipo);
    }
}
