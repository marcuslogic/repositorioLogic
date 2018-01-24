package br.com.logic.treinamentoservices.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalResource {

//    public Response addLancamentoMensal(LancamentoMensalModel saida) throws Exception;
//
//    public Response alterarLancamentoMensal(LancamentoMensalModel saida) throws Exception;
//
//    public Response excluirLancamentoMensal(LancamentoMensalModel saida) throws Exception;
//
//    public Response pesquisarLancamentoPorPeriodo(LancamentoMensalModel saida) throws Exception;

    public List<LancamentoMensalModel> pesquisarLancamentoPorDescricao(String descricao, Integer tipo) throws Exception;

//    public List<LancamentoMensalModel> pesquisarLancamentoPorTipo(Integer tipo) throws Exception;
}
