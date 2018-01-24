package br.com.logic.financeiro.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalService {

    public LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    public LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    public Boolean deletarLancamentoMensal(LancamentoMensalModel saidaRemocao) throws Exception;

    public ArrayList<LancamentoMensalModel> findByPeriodo(LancamentoMensalModel saidaData) throws Exception;

    public List<LancamentoMensalModel> findByDescricao(String descricao) throws Exception;

    public List<LancamentoMensalModel> findByTipo(Integer tipo) throws Exception;
}
