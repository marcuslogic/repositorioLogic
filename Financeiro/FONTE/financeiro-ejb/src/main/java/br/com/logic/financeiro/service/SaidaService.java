package br.com.logic.financeiro.service;

import br.com.logic.dao.interfaces.ISaidaDao;
import br.com.logic.dao.model.SaidaModel;
import br.com.logic.financeiro.interfaces.ISaidaService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class SaidaService implements ISaidaService {

    @Inject
    private ISaidaDao saidaBean;

    @Override
    public ArrayList<SaidaModel> getSaidas() throws Exception {

        return saidaBean.getSaidas();
    }

    @Override
    public SaidaModel salvarSaida(SaidaModel saida) throws Exception {

        if (saida == null) {
            throw new Exception("Informe os dados de uma conta a ser lançada.");
        }

        if (saida.getData() == null) {
            throw new Exception("Obrigatório informar a data.");
        }

        if (saida.getDescricao() == null) {
            throw new Exception("Obrigatório informar a descrição.");
        }

        if (saida.getTipo() == null) {
            throw new Exception("Obrigatório informar um tipo de lançamento:" +
                    "\n Alimentação;" +
                    "\n Moradia;" +
                    "\n Educação;" +
                    "\n Transporte;" +
                    "\n Saúde;" +
                    "\n Lazer;" +
                    "\n Outros.");
        }

        if (saida.getValor() == 0) {
            throw new Exception("Obrigatório informar um valor.");
        }

        saida = saidaBean.salvarSaida(saida);

        return saida;
    }

    @Override
    public SaidaModel alterarSaida(SaidaModel saida) throws Exception {

        if (saida == null) {
            throw new Exception("Informe os dados de uma conta a ser lançada.");
        }

        if (saida.getData() == null) {
            throw new Exception("Obrigatório informar a data.");
        }

        if (saida.getDescricao() == null) {
            throw new Exception("Obrigatório informar a descrição.");
        }

        if (saida.getTipo() == null) {
            throw new Exception("Obrigatório informar um tipo de lançamento:" +
                    "\n Alimentação;" +
                    "\n Moradia;" +
                    "\n Educação;" +
                    "\n Transporte;" +
                    "\n Saúde;" +
                    "\n Lazer;" +
                    "\n Outros.");
        }

        if (saida.getValor() == 0) {
            throw new Exception("Obrigatório informar um valor.");
        }

        saida = saidaBean.alterarSaida(saida);

        return saida;
    }

    @Override
    public Boolean deletarSaida(SaidaModel saida) throws Exception {
        Boolean sucesso = Boolean.FALSE;

        if (saida.getId() == 0) {
            throw new Exception("Informe um código de saída válido.");
        }

        sucesso = saidaBean.deletarSaida(saida);
    }

    @Override
    public ArrayList<SaidaModel> getSaidasByData(SaidaModel saida) throws Exception {

        if (saida.getData() == null) {
            throw new Exception("Informe uma data válida.");
        }

        return saidaBean.getSaidasByData(saida);
    }

    @Override
    public ArrayList<SaidaModel> getSaidasByDescricao(SaidaModel saida) throws Exception {
        if (saida.getData() == null) {
            throw new Exception("Informe uma descrição válida.");
        }

        return saidaBean.getSaidasByData(saida);
    }

    @Override
    public ArrayList<SaidaModel> getSaidasByTipo(SaidaModel saida) throws Exception {

        if (saida.getData() == null)

        {
            throw new Exception("Informe um tipo válido.");
        }

        return saidaBean.getSaidasByData(saida);

    }
}
