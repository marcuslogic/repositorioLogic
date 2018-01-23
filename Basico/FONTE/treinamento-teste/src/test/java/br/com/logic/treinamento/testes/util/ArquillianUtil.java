package br.com.logic.treinamento.testes.util;


import br.com.logic.dao.interfaces.IConnectBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(Arquillian.class)
@Stateless
public class ArquillianUtil {

    @Inject
    IConnectBean connectBean;

    @Before
    public void prepararBanco() throws SQLException {

        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;

        try {
            conn = connectBean.getConnection();

            sql = "CREATE SEQUENCE seqTipoLancamento START WITH 1";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "CREATE SEQUENCE seqLancamento START WITH 1";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "CREATE TABLE TipoLancamento\n" +
                    "(idTipoLancamento INTEGER GENERATED BY DEFAULT AS SEQUENCE seqTipoLancamento PRIMARY KEY,\n" +
                    "descricaoTipoLancamento varchar(100))";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (1, 'Alimentação')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (2, 'Moradia')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (3, 'Educação')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (4, 'Transporte')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (5, 'Saúde')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (6, 'Lazer')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "INSERT INTO TipoLancamento\n" +
                    "VALUES (7, 'Outros')";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "CREATE TABLE LancamentoMensal \n" +
                    "(idLancamento INTEGER GENERATED BY DEFAULT AS SEQUENCE seqLancamento PRIMARY KEY, \n" +
                    "   descricaoLancamento VARCHAR(255),\n" +
                    "   dataLancamento timestamp(2),\n" +
                    "   valorLancamento decimal(10,2),\n" +
                    "   idTipoLancamento int FOREIGN KEY REFERENCES TipoLancamento(idTipoLancamento))";

            ps = conn.prepareStatement(sql);

            ps.execute();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    @After
    public void apagarBanco() throws Exception {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            conn = connectBean.getConnection();

            sql = "DROP TABLE LancamentoMensal";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "DROP TABLE TipoLancamento";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "DROP SEQUENCE seqTipoLancamento";

            ps = conn.prepareStatement(sql);

            ps.execute();

            sql = "DROP SEQUENCE seqLancamento";

            ps = conn.prepareStatement(sql);

            ps.execute();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Deployment
    public static EnterpriseArchive createTestArchive() throws Exception {
        EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "treinamento-test.ear");
        ear.addAsModule(new File("/home/marcus/Logic/repositorioLogic/Básico/FONTE/dao-ejb/target/dao-ejb.jar"),
                "dao-ejb.jar")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        ear.addAsModule(new File("/home/marcus/Logic/repositorioLogic/Básico/FONTE/financeiro-ejb/target/financeiro-ejb.jar"),
                "financeiro-ejb.jar")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        ear.addAsLibrary(new File("/opt/Packages/hsqldb/lib/hsqldb.jar"),
                "hsqldb.jar");

        JavaArchive jarTest = ShrinkWrap.create(JavaArchive.class, "treinamento-test-0.0.1-SNAPSHOT.jar")
                .addPackages(true, "br.com.logic.treinamento.testes")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        jarTest.merge(ShrinkWrap.create(GenericArchive.class)
                .as(ExplodedImporter.class)
                .importDirectory("src/test/resources")
                .as(GenericArchive.class), "/", Filters.includeAll());

        ear.addAsLibrary(jarTest);

        return ear;
    }
}