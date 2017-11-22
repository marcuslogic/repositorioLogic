package br.com.logic.treinamentoservices.interfaces;

import br.com.logic.dao.model.SaidaModel;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ISaidaResource {
    public ArrayList<SaidaModel> obterTodasSaidas() throws Exception;

    public SaidaModel salvarSaida(SaidaModel saida) throws Exception;

    public SaidaModel alterarSaida(SaidaModel saida) throws Exception;

    public Boolean deletarSaida(SaidaModel saida) throws Exception;

    public ArrayList<SaidaModel> obterSaidaPorData(SaidaModel saida) throws Exception;

    public ArrayList<SaidaModel> obterSaidaPorNome(SaidaModel saida) throws Exception;

    public ArrayList<SaidaModel> obterSaidaPorTipo(SaidaModel saida) throws Exception;
}
