package br.com.logic.treinamentoservices.web;

import br.com.logic.treinamento.dao.model.SaidaModel;
import br.com.logic.treinamento.financeiro.interfaces.ISaidaService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Stateless
@Path("saidas")
public class SaidaResource implements ISaidaResource{

    @Inject
    ISaidaService saidaService;

    @POST
    @Path("getSaidas")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<SaidaModel> getSaidas() throws Exception {
        return saidaService.getTodasSaidas();
    }
}
