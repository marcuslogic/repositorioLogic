package br.com.logic.treinamento.testes.util;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;
import java.io.File;

@RunWith(Arquillian.class)
@Stateless
public class ArquillianUtil {

    @Deployment
    public static EnterpriseArchive createTestArchive() throws Exception {
        EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "treinamento-test.ear");
        ear.addAsModule(new File("../dao-ejb/target/dao-ejb-0.0.1-SNAPSHOT.jar"), "dao-ejb.jar");

        JavaArchive jarTest = ShrinkWrap.create(JavaArchive.class, "treinamento-test.jar").addPackages(true, "br.com.logic.treinamento.testes");
        jarTest.merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory("src/test/resources").as(GenericArchive.class), "/", Filters.includeAll());

        ear.addAsLibrary(jarTest);

        return ear;
    }
}
