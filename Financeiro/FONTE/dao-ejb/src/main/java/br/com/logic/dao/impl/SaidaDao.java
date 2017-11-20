package br.com.logic.dao.impl;

import br.com.logic.dao.interfaces.ISaidaDao;
import br.com.logic.dao.model.SaidaModel;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Stateless
public class SaidaDao implements ISaidaDao {

    @Inject
    ConnectBean connectBean;

    @Override
    public ArrayList<SaidaModel> obterTodasSaidas() throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From saida";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                SaidaModel saida = new SaidaModel();
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setNome(rs.getString("nome"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getTimestamp("data").toLocalDateTime());
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
    public SaidaModel obterSaidaById(int id) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        SaidaModel saida = new SaidaModel();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From saida" +
                    "\n Where id = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setNome(rs.getString("nome"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getTimestamp("data").toLocalDateTime());
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
    public SaidaModel salvarSaida(SaidaModel saidaInsert) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        Boolean monitoraSql = Boolean.FALSE;
        // </editor-fold>

        try {

            sql = "Insert into saida" +
                    "\n (tipo, " +
                    "\n nome, " +
                    "\n valor, " +
                    "\n data) " +
                    "\n Values " +
                    "\n (?, " +
                    "\n ?, " +
                    "\n ?, " +
                    "\n ?)";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);

            ps.setString(1, saidaInsert.getTipo());
            ps.setString(2, saidaInsert.getNome());
            ps.setDouble(3, saidaInsert.getValor());
            ps.setTimestamp(4, Timestamp.valueOf(saidaInsert.getData()));

            ps.execute();

            rs = ps.getGeneratedKeys();

            while (rs.next()) {
                saidaInsert.setId(rs.getInt("id"));
            }
            //</editor-fold>

            return saidaInsert;

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
        Boolean monitoraSql = Boolean.FALSE;
        // </editor-fold>

        try {

            sql = "Update saida Set" +
                    "\n tipo = ?, " +
                    "\n nome = ?, " +
                    "\n valor = ?, " +
                    "\n data = ? " +
                    "\n Where id = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaUpdate.getTipo());
            ps.setString(2, saidaUpdate.getNome());
            ps.setDouble(3, saidaUpdate.getValor());
            ps.setTimestamp(4, Timestamp.valueOf(saidaUpdate.getData()));
            ps.setInt(5, saidaUpdate.getId());

            ps.execute();

            saidaUpdate = obterSaidaById(saidaUpdate.getId());

            //</editor-fold>

            return saidaUpdate;

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
    public Boolean deletarSaida(SaidaModel saidaDelete) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        Boolean monitoraSql = Boolean.FALSE;
        int retorno = 0;
        // </editor-fold>

        try {

            sql = "Delete From saida" +
                    "\n Where id = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, saidaDelete.getId());

            retorno = ps.executeUpdate();

            if(retorno == 1) {
                monitoraSql = Boolean.TRUE;
            }

            //</editor-fold>

            return monitoraSql;

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
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From saida" +
                    "\n Where data = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setTimestamp(1, Timestamp.valueOf(saidaData.getData()));

            rs = ps.executeQuery();

            while (rs.next()) {
                SaidaModel saida = new SaidaModel();
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setNome(rs.getString("nome"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(LocalDateTime.of((rs.getDate("data").toLocalDate()), LocalTime.now()));
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
    public ArrayList<SaidaModel> getSaidasByNome(SaidaModel saidaDescricao) throws Exception {

        //<editor-fold desc="Variáveis">
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From saida" +
                    "\n Where nome like ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, "'%" + saidaDescricao.getNome() + "%'");

            rs = ps.executeQuery();

            while (rs.next()) {
                SaidaModel saida = new SaidaModel();
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setNome(rs.getString("nome"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(LocalDateTime.of((rs.getDate("data").toLocalDate()), LocalTime.now()));
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
        // </editor-fold>

        try {

            sql = "Select *" +
                    "\n From saida" +
                    "\n Where tipo = ?";

            //<editor-fold desc="Lógica">
            conn = connectBean.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, saidaTipo.getTipo());

            rs = ps.executeQuery();

            while (rs.next()) {
                SaidaModel saida = new SaidaModel();
                saida.setId(rs.getInt("id"));
                saida.setTipo(rs.getString("tipo"));
                saida.setNome(rs.getString("nome"));
                saida.setValor(rs.getDouble("valor"));
                saida.setData(rs.getTimestamp("data").toLocalDateTime());
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
