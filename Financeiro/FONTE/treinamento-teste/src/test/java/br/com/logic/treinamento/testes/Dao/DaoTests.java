package br.com.logic.treinamento.testes.Dao;

import br.com.logic.dao.impl.SaidaDao;
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
    SaidaDao SaidaDao;

    @Test
    public void testaSalvarLancamento() throws Exception {
        SaidaModel saida = null;

        saida.setData(LocalDateTime.now());
        saida.setNome("teste integracao");
        saida.setTipo("Educação");
        saida.setValor(50.50);

        saida = SaidaDao.salvarSaida(saida);

        SaidaModel saidaPesquisa = null;
        saidaPesquisa.setNome("teste integracao");

        for(SaidaModel retornoPesquisa : SaidaDao.getSaidasByNome(saidaPesquisa)){
            if(retornoPesquisa.getNome() == saida.getNome()){
                saidaPesquisa = retornoPesquisa;
            }
        }

        Assert.assertEquals(saidaPesquisa, saida);
    }

}
