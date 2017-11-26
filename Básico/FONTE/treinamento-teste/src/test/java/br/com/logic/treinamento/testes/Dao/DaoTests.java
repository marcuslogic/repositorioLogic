package br.com.logic.treinamento.testes.Dao;

import br.com.logic.dao.interfaces.IConnectBean;
import br.com.logic.dao.interfaces.ILancamentoMensalBean;
import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.enums.TipoLancamentoEnum;
import br.com.logic.treinamento.testes.util.ArquillianUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RunWith(Arquillian.class)
@Stateless
public class DaoTests extends ArquillianUtil {

    @Inject
    ILancamentoMensalBean lancamentoMensalBean;

    @Inject
    IConnectBean connectBean;

    private LancamentoMensalModel getLancamentoById(int id) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        LancamentoMensalModel lancamentoMensal = null;
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From LancamentoMensal" +
                    "\n Where idLancamento = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                lancamentoMensal = new LancamentoMensalModel();
                lancamentoMensal.setIdLancamento(rs.getInt("idLancamento"));
                lancamentoMensal.setIdTipoLancamento(rs.getInt("idTipoLancamento"));
                lancamentoMensal.setDescricaoLancamento(rs.getString("descricaoLancamento"));
                lancamentoMensal.setValorLancamento(rs.getDouble("valorLancamento"));
                lancamentoMensal.setDataLancamento(rs.getTimestamp("dataLancamento").toLocalDateTime());
            }
            //</editor-fold>

            return lancamentoMensal;

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Test
    public void testaIncluirLancamento() throws Exception {
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        Assert.assertNotEquals(lancamentoMensal.getIdLancamento(), 0);
    }

    @Test
    public void testaAlterarLancamento() throws Exception {
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        lancamentoMensal.setDescricaoLancamento("Lancamento Alterado");

        lancamentoMensal = lancamentoMensalBean.alterarLancamentoMensal(lancamentoMensal);

        LancamentoMensalModel alterado = getLancamentoById(lancamentoMensal.getIdLancamento());

        Assert.assertEquals(alterado.getIdLancamento(), lancamentoMensal.getIdLancamento());
        Assert.assertEquals(alterado.getDescricaoLancamento(), lancamentoMensal.getDescricaoLancamento());
        Assert.assertEquals(alterado.getValorLancamento(), lancamentoMensal.getValorLancamento(), 0.0);
        Assert.assertEquals(alterado.getIdTipoLancamento(), lancamentoMensal.getIdTipoLancamento());

    }

    @Test
    public void testaExcluirLancamento() throws Exception {
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        lancamentoMensalBean.excluirLancamentoMensal(lancamentoMensal);

        Assert.assertNull(getLancamentoById(lancamentoMensal.getIdLancamento()));
    }

    @Test
    public void testaPesquisarLancamentoPorData() throws Exception {
        ArrayList<LancamentoMensalModel> lancamentosCriados = new ArrayList<>();
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 1");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 2");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 3");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<>();

        lancamentos = lancamentoMensalBean.pesquisarLancamentosPorPeriodo(lancamentoMensal);

        Assert.assertEquals(lancamentos.size(), lancamentosCriados.size());

    }

    @Test
    public void testaPesquisarLancamentoPorDescricao() throws Exception {
        ArrayList<LancamentoMensalModel> lancamentosCriados = new ArrayList<>();
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("Pesquisa");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<>();

        lancamentos = lancamentoMensalBean.pesquisarLancamentosPorDescricao(lancamentoMensal);

        Assert.assertEquals(lancamentos.size(), lancamentosCriados.size());

    }

    @Test
    public void testaPesquisarLancamentoPorTipo() throws Exception {
        ArrayList<LancamentoMensalModel> lancamentosCriados = new ArrayList<>();
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(LocalDateTime.now());
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 1");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.ALIMENTACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 2");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        lancamentoMensal.setDataLancamento(LocalDateTime.of(2017, 11, 26, 12, 30));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 3");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.incluirLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<>();

        lancamentos = lancamentoMensalBean.pesquisarLancamentosPorTipo(lancamentoMensal);

        Assert.assertEquals(lancamentos.size(), lancamentosCriados.size());

    }

}
