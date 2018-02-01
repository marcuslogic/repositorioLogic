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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(Arquillian.class)
@Stateless
public class DaoTests extends ArquillianUtil {

    @Inject
    private ILancamentoMensalBean lancamentoMensalBean;

    @Inject
    private IConnectBean connectBean;

    private LancamentoMensalModel getLancamentoById(int id) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
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
                lancamentoMensal.setDataLancamento(rs.getDate("dataLancamento"));
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

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-01"));
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);

        Assert.assertNotEquals(lancamentoMensal.getIdLancamento(), 0);
    }

    @Test
    public void testaAlterarLancamento() throws Exception {
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-01"));
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);

        lancamentoMensal.setDescricaoLancamento("Lancamento Alterado");

        lancamentoMensal = lancamentoMensalBean.updateLancamentoMensal(lancamentoMensal);

        LancamentoMensalModel alterado = getLancamentoById(lancamentoMensal.getIdLancamento());

        Assert.assertEquals(alterado.getIdLancamento(), lancamentoMensal.getIdLancamento());
        Assert.assertEquals(alterado.getDescricaoLancamento(), lancamentoMensal.getDescricaoLancamento());
        Assert.assertEquals(alterado.getValorLancamento(), lancamentoMensal.getValorLancamento(), 0.0);
        Assert.assertEquals(alterado.getIdTipoLancamento(), lancamentoMensal.getIdTipoLancamento());

    }

    @Test
    public void testaExcluirLancamento() throws Exception {
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-01"));
        lancamentoMensal.setDescricaoLancamento("teste integracao");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);

        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);

        lancamentoMensalBean.deleteLancamentoMensal(lancamentoMensal.getIdLancamento());

        Assert.assertNull(getLancamentoById(lancamentoMensal.getIdLancamento()));
    }

    @Test
    public void testaPesquisarLancamentoPorData() throws Exception {
        ArrayList<LancamentoMensalModel> lancamentosCriados = new ArrayList<>();
        LancamentoMensalModel lancamentoMensal = new LancamentoMensalModel();

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-01"));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 1");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.ALIMENTACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-02"));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 2");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-03"));
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 3");
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.LAZER.getCodigo());
        lancamentoMensal.setValorLancamento(50.50);
        lancamentoMensal = lancamentoMensalBean.addLancamentoMensal(lancamentoMensal);
        lancamentosCriados.add(lancamentoMensal);

        List<LancamentoMensalModel> lancamentos = new ArrayList<>();

        lancamentoMensal = new LancamentoMensalModel();
        lancamentoMensal.setDataLancamento(Date.valueOf("2018-02-01"));

        lancamentos = lancamentoMensalBean.find(lancamentoMensal);

        Assert.assertEquals(lancamentos.get(0).getDataLancamento(), lancamentoMensal.getDataLancamento());

        lancamentoMensal = new LancamentoMensalModel();
        lancamentoMensal.setIdTipoLancamento(TipoLancamentoEnum.EDUCACAO.getCodigo());

        lancamentos = lancamentoMensalBean.find(lancamentoMensal);

        Assert.assertEquals(lancamentos.get(0).getIdTipoLancamento(), lancamentoMensal.getIdTipoLancamento());

        lancamentoMensal = new LancamentoMensalModel();
        lancamentoMensal.setDescricaoLancamento("Pesquisa Data 3");

        lancamentos = lancamentoMensalBean.find(lancamentoMensal);

        Assert.assertEquals(lancamentos.get(0).getDescricaoLancamento(), lancamentoMensal.getDescricaoLancamento());

    }

}
