package br.com.logic.treinamentoservices.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Local
public interface ILancamentoMensalResource {

    public Response incluirLancamentoMensal(LancamentoMensalModel saida) throws Exception;

    public Response alterarLancamentoMensal(LancamentoMensalModel saida) throws Exception;

    public Response excluirLancamentoMensal(LancamentoMensalModel saida) throws Exception;

    public Response pesquisarLancamentoPorPeriodo(LancamentoMensalModel saida) throws Exception;

    public Response pesquisarLancamentoPorDescricao(LancamentoMensalModel saida) throws Exception;

    public Response pesquisarLancamentoPorTipo(LancamentoMensalModel saida) throws Exception;
}
