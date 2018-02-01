package br.com.logic.financeiro.service;

import br.com.logic.dao.interfaces.ILancamentoMensalBean;
import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.interfaces.ILancamentoMensalService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LancamentoMensalService implements ILancamentoMensalService {

    @Inject
    private ILancamentoMensalBean lancamentoMensalBean;

    @Override
    public LancamentoMensalModel addLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        return lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);
    }

    @Override
    public LancamentoMensalModel updateLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        return lancamentoMensalBean.updateLancamentoMensal(lancamentoMensal);
    }

    @Override
    public Boolean deleteLancamentoMensal(Integer idLancamento) throws Exception {

        return lancamentoMensalBean.deleteLancamentoMensal(idLancamento);
    }

    @Override
    public List<LancamentoMensalModel> findByPeriodo(String periodo) throws Exception {

        return lancamentoMensalBean.findByPeriodo(periodo);
    }

    @Override
    public List<LancamentoMensalModel> findByDescricao(String descricao) throws Exception {

        return lancamentoMensalBean.findByDescricao(descricao);
    }

    @Override
    public List<LancamentoMensalModel> findByTipo(Integer tipo) throws Exception {

        return lancamentoMensalBean.findByTipo(tipo);

    }

}
