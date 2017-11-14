package br.com.logic.treinamentoservices.web;

import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaResource {
    public ArrayList<SaidaModel> getSaidas() throws Exception;
}
