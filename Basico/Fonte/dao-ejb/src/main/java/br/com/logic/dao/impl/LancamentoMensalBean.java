package br.com.logic.dao.impl;

import br.com.logic.dao.interfaces.IConnectBean;
import br.com.logic.dao.interfaces.ILancamentoMensalBean;
import br.com.logic.dao.model.LancamentoMensalModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LancamentoMensalBean implements ILancamentoMensalBean {

    @Inject
    private IConnectBean connectBean;

    @Override
    public LancamentoMensalModel addLancamentoMensal(LancamentoMensalModel insertLancamentoMensal) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        // </editor-fold>

        try {

            sql = "Insert into LancamentoMensal" +
                    "\n (descricaoLancamento, " +
                    "\n dataLancamento, " +
                    "\n valorLancamento, " +
                    "\n idTipoLancamento) " +
                    "\n Values " +
                    "\n (?, " +
                    "\n ?, " +
                    "\n ?, " +
                    "\n ?)";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);

            ps.setString(1, insertLancamentoMensal.getDescricaoLancamento());
            ps.setTimestamp(2, Timestamp.valueOf(insertLancamentoMensal.getDataLancamento()));
            ps.setDouble(3, insertLancamentoMensal.getValorLancamento());
            ps.setInt(4, insertLancamentoMensal.getIdTipoLancamento());

            ps.execute();

            rs = ps.getGeneratedKeys();

            while (rs.next()) {
                insertLancamentoMensal.setIdLancamento(rs.getInt("idLancamento"));
            }
            //</editor-fold>

            return insertLancamentoMensal;

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

    @Override
    public LancamentoMensalModel updateLancamentoMensal(LancamentoMensalModel updateLancamentoMensal) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        // </editor-fold>

        try {

            sql = "Update LancamentoMensal Set" +
                    "\n descricaoLancamento = ?, " +
                    "\n dataLancamento = ?, " +
                    "\n valorLancamento = ?, " +
                    "\n idTipoLancamento = ? " +
                    "\n Where idLancamento = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, updateLancamentoMensal.getDescricaoLancamento());
            ps.setTimestamp(2, Timestamp.valueOf(updateLancamentoMensal.getDataLancamento()));
            ps.setDouble(3, updateLancamentoMensal.getValorLancamento());
            ps.setInt(4, updateLancamentoMensal.getIdTipoLancamento());
            ps.setInt(5, updateLancamentoMensal.getIdLancamento());

            ps.execute();

            //</editor-fold>

            return updateLancamentoMensal;

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

    @Override
    public Boolean deleteLancamentoMensal(Integer idLancamento) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        Boolean retorno = Boolean.FALSE;
        int retornoSql = 0;
        // </editor-fold>

        try {

            sql = "Delete From LancamentoMensal" +
                    "\n Where idLancamento = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, idLancamento);

            retornoSql = ps.executeUpdate();

            if(retornoSql != 0) {
                retorno = Boolean.TRUE;
            }

            //</editor-fold>

            return retorno;

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

    @Override
    public List<LancamentoMensalModel> find(PesquisaRequest pesquisa) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        ArrayList<LancamentoMensalModel> lancamentos = new ArrayList<>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From LancamentoMensal";

            if(pesquisa.nome != null) {
              sql += "\n Where descricaoLancamento like ?";
            }

            if(pesquisa.tipo != null) {
               if(sql.contains("Where")) {
                 sql += "\n And idTipoLancamento = ?";
               } else {
                 sql += "\n Where idTipoLancamento = ?";
               }
            }

            if(pesquisa.periodo != null){
              if(sql.contains("Where")) {
                sql += "\n And dataLancamento = ?";
              } else {
                sql += "\n Where dataLancamento = ?";
              }
            }

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            if(pesquisa.nome != null) {
              ps.setString(1, "%" + descricao + "%");
            }

            if(pesquisa.tipo != null) {
              ps.setInt(1, tipo);
            }

            if(pesquisa.periodo != null) {
              ps.setDate(1, Date.valueOf(periodo));
            }

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
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }
}
