package br.com.logic.dao.impl;

import br.com.logic.dao.interfaces.ILancamentoMensalBean;
import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Stateless
public class LancamentoMensalBean implements ILancamentoMensalBean {

    @Override
    public LancamentoMensalModel incluirLancamentoMensal(LancamentoMensalModel insertLancamentoMensal) throws Exception {

        try {

            EntityManager em = new JPAUtil().getEntityManager();

            em.persist(insertLancamentoMensal);
            em.flush();

            return insertLancamentoMensal;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public LancamentoMensalModel alterarLancamentoMensal(LancamentoMensalModel updateLancamentoMensal) throws Exception {

        try {
            EntityManager emf = Persistence.createEntityManagerFactory("Treinamento").createEntityManager();

            emf.merge(updateLancamentoMensal);
            emf.flush();

            return updateLancamentoMensal;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Boolean excluirLancamentoMensal(LancamentoMensalModel deleteLancamentoMensal) throws Exception {

        try {
            EntityManager emf = Persistence.createEntityManagerFactory("Treinamento").createEntityManager();

            emf.remove(deleteLancamentoMensal);
            emf.flush();

            return deleteLancamentoMensal;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorPeriodo(LancamentoMensalModel dataLancamentoMensal) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<LancamentoMensalModel>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From LancamentoMensal" +
                    "\n Where dataLancamento = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setTimestamp(1, Timestamp.valueOf(dataLancamentoMensal.getDataLancamento()));

            rs = ps.executeQuery();

            while (rs.next()) {
                LancamentoMensalModel lancamento = new LancamentoMensalModel();
                lancamento.setIdLancamento(rs.getInt("idLancamento"));
                lancamento.setIdTipoLancamento(rs.getInt("idTipoLancamento"));
                lancamento.setDescricaoLancamento(rs.getString("descricaoLancamento"));
                lancamento.setValorLancamento(rs.getDouble("valorLancamento"));
                lancamento.setDataLancamento(LocalDateTime.of((rs.getDate("dataLancamento").toLocalDate()), LocalTime.now()));
                lancamentos.add(lancamento);
            }
            //</editor-fold>

            return lancamentos;

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorDescricao(LancamentoMensalModel saidaDescricao) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<LancamentoMensalModel>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From LancamentoMensal" +
                    "\n Where descricaoLancamento like ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + saidaDescricao.getDescricaoLancamento() + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                LancamentoMensalModel lancamento = new LancamentoMensalModel();
                lancamento.setIdLancamento(rs.getInt("idLancamento"));
                lancamento.setIdTipoLancamento(rs.getInt("idTipoLancamento"));
                lancamento.setDescricaoLancamento(rs.getString("descricaoLancamento"));
                lancamento.setValorLancamento(rs.getDouble("valorLancamento"));
                lancamento.setDataLancamento(LocalDateTime.of((rs.getDate("dataLancamento").toLocalDate()), LocalTime.now()));
                lancamentos.add(lancamento);
            }
            //</editor-fold>

            return lancamentos;

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Override
    public ArrayList<LancamentoMensalModel> pesquisarLancamentosPorTipo(LancamentoMensalModel saidaTipo) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<LancamentoMensalModel>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From LancamentoMensal" +
                    "\n Where idTipoLancamento = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, saidaTipo.getIdTipoLancamento());

            rs = ps.executeQuery();

            while (rs.next()) {
                LancamentoMensalModel lancamento = new LancamentoMensalModel();
                lancamento.setIdLancamento(rs.getInt("idLancamento"));
                lancamento.setIdTipoLancamento(rs.getInt("idTipoLancamento"));
                lancamento.setDescricaoLancamento(rs.getString("descricaoLancamento"));
                lancamento.setValorLancamento(rs.getDouble("valorLancamento"));
                lancamento.setDataLancamento(LocalDateTime.of((rs.getDate("dataLancamento").toLocalDate()), LocalTime.now()));
                lancamentos.add(lancamento);
            }
            //</editor-fold>

            return lancamentos;

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

}
