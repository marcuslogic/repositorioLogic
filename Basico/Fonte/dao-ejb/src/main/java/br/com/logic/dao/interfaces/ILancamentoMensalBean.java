package br.com.logic.dao.interfaces;

import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface ILancamentoMensalBean {

    LancamentoMensalModel addLancamentoMensal(LancamentoMensalModel saidaNova) throws Exception;

    LancamentoMensalModel updateLancamentoMensal(LancamentoMensalModel saidaAlterada) throws Exception;

    Boolean deleteLancamentoMensal(Integer idLancamento) throws Exception;

    List<LancamentoMensalModel> find(LancamentoMensalModel pesquisa) throws Exception;
}
