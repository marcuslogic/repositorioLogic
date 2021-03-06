package br.com.logic.financeiro.service;

import br.com.logic.dao.interfaces.ILancamentoMensalBean;
import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.interfaces.ILancamentoMensalService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

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
    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorPeriodo(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal.getDataLancamento() == null) {
            throw new Exception("Informe uma data válida.");
        }

        return lancamentoMensalBean.pesquisarLancamentosPorPeriodo(lancamentoMensal);
    }

    @Override
    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorDescricao(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal.getDescricaoLancamento() == null) {
            throw new Exception("Informe um nome válido.");
        }

        return lancamentoMensalBean.pesquisarLancamentosPorDescricao(lancamentoMensal);
    }

    @Override
    public ArrayList<LancamentoMensalModel> pesqusiarLancamentosPorTipo(LancamentoMensalModel lancamentoMensal) throws Exception {

        if (lancamentoMensal.getIdTipoLancamento() == 0) {
            throw new Exception("Informe um tipo válido.");
        }

        return lancamentoMensalBean.pesquisarLancamentosPorTipo(lancamentoMensal);

    }
}
