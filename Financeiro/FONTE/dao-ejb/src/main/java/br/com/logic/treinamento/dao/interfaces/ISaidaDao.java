package br.com.logic.treinamento.dao.interfaces;

import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaDao {

    public ArrayList<SaidaModel> getSaidas() throws Exception;
}
