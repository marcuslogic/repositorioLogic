package br.com.logic.treinamentoservices.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface ILancamentoMensalResource {

    Response addLancamentoMensal(LancamentoMensalModel saida);

    Response updateLancamentoMensal(LancamentoMensalModel saida);

    Response deleteLancamentoMensal(Integer idLancamento);

    Response find(LancamentoMensalModel pesquisa);
}
