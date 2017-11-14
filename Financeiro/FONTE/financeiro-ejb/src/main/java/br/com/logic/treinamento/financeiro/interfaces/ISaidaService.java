package br.com.logic.treinamento.financeiro.interfaces;

import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaService {
    public ArrayList<SaidaModel> getTodasSaidas() throws Exception;
}
