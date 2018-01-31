package br.com.logic.dao.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalBean {

    public LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    public LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    public Boolean excluirLancamentoMensal(LancamentoMensalModel saidaRemocao) throws Exception;

    List<LancamentoMensalModel> findByPeriodo(String periodo) throws Exception;

    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorDescricao(LancamentoMensalModel saidaDescricao) throws Exception;

    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorTipo(LancamentoMensalModel saidaTipo) throws Exception;
}
