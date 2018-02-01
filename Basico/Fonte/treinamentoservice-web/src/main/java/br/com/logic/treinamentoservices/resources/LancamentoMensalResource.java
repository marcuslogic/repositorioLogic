package br.com.logic.treinamentoservices.resources;

import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.interfaces.ILancamentoMensalService;
import br.com.logic.treinamentoservices.interfaces.ILancamentoMensalResource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("lancamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LancamentoMensalResource implements ILancamentoMensalResource {

    @Inject
    ILancamentoMensalService lancamentoMensalService;

    @PUT
    @Override
    public Response addLancamentoMensal(LancamentoMensalModel lancamentoMensal) {

        try {
            if (lancamentoMensal.getValorLancamento() == 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um valor.").build();
            }

            if (lancamentoMensal == null) {
                return Response.status(Status.BAD_REQUEST).entity("Informe os dados de uma conta a ser lançada.").build();
            }

            if (lancamentoMensal.getDataLancamento() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar a data.").build();
            }

            if (lancamentoMensal.getDescricaoLancamento() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar a descrição.").build();
            }

            if (lancamentoMensal.getIdTipoLancamento() <= 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um tipo de lançamento:\" +\n" +
                        "                        \"\\n 1 - Alimentação;\" +\n" +
                        "                        \"\\n 2 - Moradia;\" +\n" +
                        "                        \"\\n 3 - Educação;\" +\n" +
                        "                        \"\\n 4 - Transporte;\" +\n" +
                        "                        \"\\n 5 - Saúde;\" +\n" +
                        "                        \"\\n 6 - Lazer;\" +\n" +
                        "                        \"\\n 7 - Outros.").build();
            }

            return Response.ok().entity(lancamentoMensalService.addLancamentoMensal(lancamentoMensal)).build();

        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Override
    public Response updateLancamentoMensal(LancamentoMensalModel lancamentoMensal) {

        try {

            if (lancamentoMensal.getValorLancamento() == 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um valor.").build();
            }

            if (lancamentoMensal == null) {
                return Response.status(Status.BAD_REQUEST).entity("Informe os dados de uma conta a ser lançada.").build();
            }

            if (lancamentoMensal.getDataLancamento() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar a data.").build();
            }

            if (lancamentoMensal.getDescricaoLancamento() == null) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar a descrição.").build();
            }

            if (lancamentoMensal.getIdTipoLancamento() <= 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um tipo de lançamento:\" +\n" +
                        "                        \"\\n 1 - Alimentação;\" +\n" +
                        "                        \"\\n 2 - Moradia;\" +\n" +
                        "                        \"\\n 3 - Educação;\" +\n" +
                        "                        \"\\n 4 - Transporte;\" +\n" +
                        "                        \"\\n 5 - Saúde;\" +\n" +
                        "                        \"\\n 6 - Lazer;\" +\n" +
                        "                        \"\\n 7 - Outros.").build();
            }

            return Response.ok().entity(lancamentoMensalService.updateLancamentoMensal(lancamentoMensal)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Override
    public Response deleteLancamentoMensal(@QueryParam("lancamento") Integer idLancamento) {

        try {

            if (idLancamento <= 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um identificador de lancamento válido.").build();
            }

            if (lancamentoMensalService.deleteLancamentoMensal(idLancamento)) {
                return Response.ok().entity("Lancamento excluído.").build();
            } else {
                return Response.ok().entity("Não foi encontrado lacamento com ID:" + idLancamento).build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Override
    public Response find(LancamentoMensalModel pesquisa) {

        try {

            if (pesquisa.getDescricaoLancamento() == null && pesquisa.getDataLancamento() == null && pesquisa.getIdTipoLancamento() <= 0) {
                return Response.status(Status.BAD_REQUEST).entity("Obrigatório informar um dado para pesquisa.").build();
            }

            return Response.ok().entity(lancamentoMensalService.find(pesquisa)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
