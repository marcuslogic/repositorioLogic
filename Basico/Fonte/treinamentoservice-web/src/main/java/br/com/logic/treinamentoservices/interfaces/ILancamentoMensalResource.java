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
    public List<LancamentoMensalModel> findByPeriodo(String saida) throws Exception;

    public List<LancamentoMensalModel> findByDescricao(String descricao) throws Exception;

    public List<LancamentoMensalModel> findByTipo(Integer tipo) throws Exception;
}
