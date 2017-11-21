package br.com.logic.treinamento.financeiro.interfaces;

import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaBeanLocal {

    public ArrayList<SaidaModel> getSaidas() throws Exception;
    public SaidaModel insertSaida(SaidaModel saidaNova) throws Exception;
    public SaidaModel updateSaida(SaidaModel saidaAlterada) throws Exception;
    public SaidaModel deleteSaida(SaidaModel saidaRemocao) throws Exception;
    public ArrayList<SaidaModel> getSaidasByData(SaidaModel saidaData) throws Exception;
    public ArrayList<SaidaModel> getSaidasByDescricao(SaidaModel saidaDescricao) throws Exception;
    public ArrayList<SaidaModel> getSaidasByTipo(SaidaModel saidaTipo) throws Exception;
}
