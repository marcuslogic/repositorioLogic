package br.com.logic.treinamento.testes.Dao;

import br.com.logic.dao.interfaces.ISaidaDao;
import br.com.logic.dao.model.SaidaModel;
import br.com.logic.treinamento.testes.util.ArquillianUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@RunWith(Arquillian.class)
@Stateless
public class DaoTests extends ArquillianUtil {

    @Inject
    ISaidaDao saidaDao;

    @Test
    public void testaSalvarLancamento() throws Exception {
        SaidaModel saida = new SaidaModel();

        saida.setData(LocalDateTime.now());
        saida.setNome("teste integracao");
        saida.setTipo("Educação");
        saida.setValor(50.50);

        saida = saidaDao.salvarSaida(saida);

        SaidaModel saidaPesquisa = null;
        saidaPesquisa.setNome("teste integracao");

        for(SaidaModel retornoPesquisa : saidaDao.getSaidasByNome(saidaPesquisa)){
            if(retornoPesquisa.getNome() == saida.getNome()){
                saidaPesquisa = retornoPesquisa;
            }
        }

        Assert.assertEquals(saidaPesquisa, saida);
    }

}
