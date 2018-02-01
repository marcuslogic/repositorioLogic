package br.com.logic.financeiro.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalService {

    LancamentoMensalModel addLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    LancamentoMensalModel updateLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    Boolean deleteLancamentoMensal(Integer idLancamento) throws Exception;

    List<LancamentoMensalModel> find(PesquisaRequest pesquisa) throws Exception;
