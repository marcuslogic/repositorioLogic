package br.com.logic.treinamentoservices.resources;

import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.interfaces.ILancamentoMensalService;
import br.com.logic.treinamentoservices.interfaces.ILancamentoMensalResource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Stateless
@Path("/")
public class LancamentoMensalResource implements ILancamentoMensalResource {

    @Inject
    ILancamentoMensalService lancamentoMensalService;

    @POST
    @Path("incluirLancamentoMensal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response incluirLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            LancamentoMensalModel novoLancamento = lancamentoMensalService.incluirLancamentoMensal(lancamentoMensal);
            retorno = Response.ok(novoLancamento);
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();
    }

    @POST
    @Path("alterarLancamentoMensal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response alterarLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            LancamentoMensalModel lancamentoAlterado = lancamentoMensalService.alterarLancamentoMensal(lancamentoMensal);
            retorno = Response.ok(lancamentoAlterado);
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();
    }

    @POST
    @Path("excluirLancamentoMensal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response excluirLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            if(lancamentoMensalService.deletarLancamentoMensal(lancamentoMensal)) {
                retorno = Response.ok("Lancamento excluído.");
            } else {
                retorno = Response.ok("Não foi encontrado lacamento com ID:" + lancamentoMensal.getIdLancamento());
            }
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();
    }

    @POST
    @Path("pesquisarLancamentoPorPeriodo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response pesquisarLancamentoPorPeriodo(LancamentoMensalModel saida) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            retorno = Response.ok(lancamentoMensalService.pesquisarLancamentosPorPeriodo(saida));
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();

    }

    @POST
    @Path("pesquisarLancamentoPorDescricao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response pesquisarLancamentoPorDescricao(LancamentoMensalModel saida) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            retorno = Response.ok(lancamentoMensalService.pesquisarLancamentosPorDescricao(saida));
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();

    }

    @POST
    @Path("pesquisarLancamentoPorTipo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response pesquisarLancamentoPorTipo(LancamentoMensalModel saida) throws Exception {

        Response.ResponseBuilder retorno = null;

        try {
            retorno = Response.ok(lancamentoMensalService.pesqusiarLancamentosPorTipo(saida));
        } catch (Exception e) {
            retorno = Response.serverError().entity(e.getLocalizedMessage());
        }

        return retorno.build();

    }
}
