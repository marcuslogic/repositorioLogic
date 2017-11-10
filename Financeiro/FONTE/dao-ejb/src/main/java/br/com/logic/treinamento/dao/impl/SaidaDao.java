package br.com.logic.treinamento.dao.impl;

import br.com.logic.treinamento.dao.interfaces.ISaidaDao;
import br.com.logic.treinamento.dao.model.SaidaModel;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Stateless(mappedName = "SaidaDao")
public class SaidaDao implements ISaidaDao {

    @Inject
    Conexao persistFacatory;


    @PostConstruct
    public void teste2() throws Exception {
        System.out.print("teste");
    }


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

            sql = "select *" +
                    "\n from contasmensais";

            //<editor-fold desc="Lógica">
            conn = persistFacatory.connect();
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
            ps.close();
            rs.close();
        }
    }

}
