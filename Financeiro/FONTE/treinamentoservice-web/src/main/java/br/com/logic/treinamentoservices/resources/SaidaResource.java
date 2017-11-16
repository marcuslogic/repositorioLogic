package br.com.logic.treinamentoservices.resources;

import br.com.logic.dao.model.SaidaModel;
import br.com.logic.financeiro.interfaces.ISaidaService;
import br.com.logic.treinamentoservices.interfaces.ISaidaResource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Stateless
@Path("saidas")
public class SaidaResource implements ISaidaResource {

    @Inject
    ISaidaService saidaService;

    @POST
    @Path("getSaidas")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<SaidaModel> getSaidas() throws Exception {
        return saidaService.getTodasSaidas();
    }

    @POST
    @Path("salvarSaida")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SaidaModel insertSaida(SaidaModel saida) throws Exception {
        return saidaService.salvarSaida(saida);
    }

    @POST
    @Path("salvarSaida")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SaidaModel updateSaida(SaidaModel saida) throws Exception {
        return saidaService.updateSaida(saida);
    }
}
