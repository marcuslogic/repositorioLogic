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
    public List<LancamentoMensalModel> find(LancamentoMensalModel pesquisa) throws Exception {

        return lancamentoMensalBean.find(pesquisa);
    }

}
