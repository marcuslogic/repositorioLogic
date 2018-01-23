package br.com.logic.financeiro.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ILancamentoMensalService {

    public LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    public LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    public Boolean deletarLancamentoMensal(LancamentoMensalModel saidaRemocao) throws Exception;

    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorPeriodo(LancamentoMensalModel saidaData) throws Exception;

    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorDescricao(LancamentoMensalModel saidaDescricao) throws Exception;

    public ArrayList<LancamentoMensalModel> pesqusiarLancamentosPorTipo(LancamentoMensalModel saidaTipo) throws Exception;
}
