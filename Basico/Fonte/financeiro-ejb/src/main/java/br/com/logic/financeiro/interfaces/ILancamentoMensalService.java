package br.com.logic.financeiro.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalService {

    LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    Boolean deletarLancamentoMensal(LancamentoMensalModel saidaRemocao) throws Exception;

    List<LancamentoMensalModel> findByPeriodo(String periodo) throws Exception;

    List<LancamentoMensalModel> findByDescricao(String descricao) throws Exception;

    List<LancamentoMensalModel> findByTipo(Integer tipo) throws Exception;
}
