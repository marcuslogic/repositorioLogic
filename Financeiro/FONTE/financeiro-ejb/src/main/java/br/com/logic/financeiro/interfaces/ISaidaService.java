package br.com.logic.financeiro.interfaces;

import br.com.logic.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaService {

    public ArrayList<SaidaModel> getSaidas() throws Exception;

    public SaidaModel salvarSaida(SaidaModel saidaNova) throws Exception;

    public SaidaModel alterarSaida(SaidaModel saidaAlterada) throws Exception;

    public Boolean deletarSaida(SaidaModel saidaRemocao) throws Exception;

    public ArrayList<SaidaModel> getSaidasByData(SaidaModel saidaData) throws Exception;

    public ArrayList<SaidaModel> getSaidasByDescricao(SaidaModel saidaDescricao) throws Exception;

    public ArrayList<SaidaModel> getSaidasByTipo(SaidaModel saidaTipo) throws Exception;
}
