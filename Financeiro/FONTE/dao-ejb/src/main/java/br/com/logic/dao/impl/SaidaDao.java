package br.com.logic.dao.impl;

import br.com.logic.dao.interfaces.ISaidaDao;
import br.com.logic.dao.model.SaidaModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Stateless
public class SaidaDao implements ISaidaDao {

    @Inject
    ConnectBean connectBean;

    @Override
    public ArrayList<SaidaModel> getSaidas() throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From contasmensais";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setDescricao(rs.getString("descricao"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getDate("data").toLocalDate());
                saidas.add(saida);
            }
            //</editor-fold>

            return saidas;

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
    public SaidaModel insertSaida(SaidaModel saidaInsert) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Insert into contasmensais" +
                    "\n (tipo, " +
                    "\n descricao, " +
                    "\n valor, " +
                    "\n data " +
                    "\n Values " +
                    "\n (?, " +
                    "\n ?, " +
                    "\n ?, " +
                    "\n ?)";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);

            ps.setString(1, saidaInsert.getTipo());
            ps.setString(2, saidaInsert.getDescricao());
            ps.setDouble(3, saidaInsert.getValor());
            ps.setString(4, saidaInsert.getData().toString());

            rs = ps.executeQuery();

            while(rs.next()) {
                saida.setId(rs.getInt("id"));
            }

            //</editor-fold>

            return saida;

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
    public SaidaModel alterarSaida(SaidaModel saidaUpdate) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Update contasmensais Set" +
                    "\n tipo = ?, " +
                    "\n descricao = ?, " +
                    "\n valor = ?, " +
                    "\n data = ? " +
                    "\n Where id = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaUpdate.getTipo());
            ps.setString(2, saidaUpdate.getDescricao());
            ps.setDouble(3, saidaUpdate.getValor());
            ps.setString(4, saidaUpdate.getData().toString());
            ps.setInt(5, saidaUpdate.getId());

            rs = ps.executeQuery();

            //</editor-fold>

            return saida;

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
    public SaidaModel deletarSaida(SaidaModel saidaDelete) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Delete contasmensais" +
                    "\n Where id = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, saidaDelete.getId());

            rs = ps.executeQuery();

            //</editor-fold>

            return saida;

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
    public ArrayList<SaidaModel> getSaidasByData(SaidaModel saidaData) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From contasmensais" +
                    "\n Where data like '%?%'";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaData.getData().toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setDescricao(rs.getString("descricao"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getDate("data").toLocalDate());
                saidas.add(saida);
            }
            //</editor-fold>

            return saidas;

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
    public ArrayList<SaidaModel> getSaidasByDescricao(SaidaModel saidaDescricao) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From contasmensais" +
                    "\n Where descricao like '%?%'";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaDescricao.getDescricao());

            rs = ps.executeQuery();

            while (rs.next()) {
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setDescricao(rs.getString("descricao"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getDate("data").toLocalDate());
                saidas.add(saida);
            }
            //</editor-fold>

            return saidas;

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
    public ArrayList<SaidaModel> getSaidasByTipo(SaidaModel saidaTipo) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From contasmensais" +
                    "\n Where tipo = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaTipo.getTipo());

            rs = ps.executeQuery();

            while (rs.next()) {
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setDescricao(rs.getString("descricao"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getDate("data").toLocalDate());
                saidas.add(saida);
            }
            //</editor-fold>

            return saidas;

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
