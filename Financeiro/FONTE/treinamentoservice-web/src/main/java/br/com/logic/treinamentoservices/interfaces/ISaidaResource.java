package br.com.logic.treinamentoservices.interfaces;

import br.com.logic.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaResource {
    public ArrayList<SaidaModel> getSaidas() throws Exception;

    public SaidaModel insertSaida(SaidaModel saida) throws Exception;
}
