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
    public LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal == null) {
            throw new Exception("Informe os dados de uma conta a ser lançada.");
        }

        if (lancamentoMensal.getDataLancamento() == null) {
            throw new Exception("Obrigatório informar a data.");
        }

        if (lancamentoMensal.getDescricaoLancamento() == null) {
            throw new Exception("Obrigatório informar a descrição.");
        }

        if (lancamentoMensal.getIdTipoLancamento() == 0) {
            throw new Exception("Obrigatório informar um tipo de lançamento:" +
                    "\n 1 - Alimentação;" +
                    "\n 2 - Moradia;" +
                    "\n 3 - Educação;" +
                    "\n 4 - Transporte;" +
                    "\n 5 - Saúde;" +
                    "\n 6 - Lazer;" +
                    "\n 7 - Outros.");
        }

        if (lancamentoMensal.getValorLancamento() == 0) {
            throw new Exception("Obrigatório informar um valor.");
        }

        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        return lancamentoMensal;
    }

    @Override
    public LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal == null) {
            throw new Exception("Informe os dados de uma conta a ser lançada.");
        }

        if (lancamentoMensal.getDataLancamento() == null) {
            throw new Exception("Obrigatório informar a data.");
        }

        if (lancamentoMensal.getDescricaoLancamento() == null) {
            throw new Exception("Obrigatório informar a descrição.");
        }

        if (lancamentoMensal.getIdTipoLancamento() == 0) {
            throw new Exception("Obrigatório informar um tipo de lançamento:" +
                    "\n 1 - Alimentação;" +
                    "\n 2 - Moradia;" +
                    "\n 3 - Educação;" +
                    "\n 4 - Transporte;" +
                    "\n 5 - Saúde;" +
                    "\n 6 - Lazer;" +
                    "\n 7 - Outros.");
        }

        if (lancamentoMensal.getValorLancamento() == 0) {
            throw new Exception("Obrigatório informar um valor.");
        }

        lancamentoMensal = lancamentoMensalBean.alterarLancamentoMensal(lancamentoMensal);

        return lancamentoMensal;
    }

    @Override
    public Boolean deletarLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal.getIdLancamento() <= 0) {
            throw new Exception("Informe um código de saída válido.");
        }

        return lancamentoMensalBean.excluirLancamentoMensal(lancamentoMensal);
    }

    @Override
    public List<LancamentoMensalModel> findByPeriodo(String periodo) throws Exception {

        return lancamentoMensalBean.findByPeriodo(periodo);
    }

    @Override
    public List<LancamentoMensalModel> findByDescricao(String descricao) throws Exception {

        if (descricao == null) {
            throw new Exception("Informe uma descrição válida.");
        }

        return new ArrayList<LancamentoMensalModel>(); //lancamentoMensalBean.pesquisarLancamentosPorDescricao(lancamentoMensal);
    }

    @Override
    public List<LancamentoMensalModel> findByTipo(Integer tipo) throws Exception {

//        if (lancamentoMensal.getIdTipoLancamento() == 0) {
//            throw new Exception("Informe um tipo válido.");
//        }

        return new ArrayList<LancamentoMensalModel>(); //lancamentoMensalBean.pesquisarLancamentosPorTipo(lancamentoMensal);

    }
}
