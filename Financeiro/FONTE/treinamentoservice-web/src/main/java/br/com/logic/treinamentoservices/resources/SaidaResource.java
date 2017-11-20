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
    @Path("obterTodasSaidas")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ArrayList<SaidaModel> obterTodasSaidas() throws Exception {
        return saidaService.obterTodasSaidas();
    }

    @POST
    @Path("salvarSaida")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public SaidaModel salvarSaida(SaidaModel saida) throws Exception {

        return saidaService.salvarSaida(saida);
    }

    @POST
    @Path("alterarSaida")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public SaidaModel alterarSaida(SaidaModel saida) throws Exception {
        return saidaService.alterarSaida(saida);
    }

    @POST
    @Path("deletarSaida")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Boolean deletarSaida(SaidaModel saida) throws Exception {
        return saidaService.deletarSaida(saida);
    }

    @POST
    @Path("obterSaidaPorData")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ArrayList<SaidaModel> obterSaidaPorData(SaidaModel saida) throws Exception {
        return saidaService.getSaidasByData(saida);
    }

    @POST
    @Path("obterSaidaPorNome")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ArrayList<SaidaModel> obterSaidaPorNome(SaidaModel saida) throws Exception {
        return saidaService.getSaidasByNome(saida);
    }

    @POST
    @Path("obterSaidaPorTipo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public ArrayList<SaidaModel> obterSaidaPorTipo(SaidaModel saida) throws Exception {
        return saidaService.getSaidasByTipo(saida);
    }
}
