package br.com.logic.treinamento.financeiro.service;

import br.com.logic.treinamento.dao.interfaces.ISaidaDao;
import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.inject.Inject;
import java.util.ArrayList;

public class SaidaService {

    @Inject
    private ISaidaDao saidaDao;

    public ISaidaDao getSaidaDao() {
        return saidaDao;
    }

    public void setSaidaDao(ISaidaDao saidaDao) {
        this.saidaDao = saidaDao;
    }

    public ArrayList<SaidaModel> getTodasSaidas() throws Exception {


        if (saidaDao != null) {
            System.out.print(saidaDao.toString());
        } else {
            System.out.print("ta nulo");
        }
        return saidaDao.getSaidas();
    }
}
