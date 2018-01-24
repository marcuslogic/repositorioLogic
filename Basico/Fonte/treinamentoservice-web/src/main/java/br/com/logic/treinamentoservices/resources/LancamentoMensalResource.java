package br.com.logic.treinamentoservices.resources;

import br.com.logic.dao.model.LancamentoMensalModel;
import br.com.logic.financeiro.interfaces.ILancamentoMensalService;
import br.com.logic.treinamentoservices.interfaces.ILancamentoMensalResource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LancamentoMensalResource implements ILancamentoMensalResource {

    @Inject
    ILancamentoMensalService lancamentoMensalService;

    //    @POST
//    @Override
//    public Response addLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {
//
//        Response.ResponseBuilder retorno;
//
//        try {
//            LancamentoMensalModel novoLancamento = lancamentoMensalService.incluirLancamentoMensal(lancamentoMensal);
//            retorno = Response.ok(novoLancamento);
//        } catch (Exception e) {
//            retorno = Response.serverError().entity(e.getLocalizedMessage());
//        }
//
//        return retorno.build();
//    }
//
//    @POST
//    @Path("alterarLancamentoMensal")
//    @Override
//    public Response alterarLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {
//
//        Response.ResponseBuilder retorno = null;
//
//        try {
//            LancamentoMensalModel lancamentoAlterado = lancamentoMensalService.alterarLancamentoMensal(lancamentoMensal);
//            retorno = Response.ok(lancamentoAlterado);
//        } catch (Exception e) {
//            retorno = Response.serverError().entity(e.getLocalizedMessage());
//        }
//
//        return retorno.build();
//    }
//
//    @POST
//    @Path("excluirLancamentoMensal")
//    @Override
//    public Response excluirLancamentoMensal(LancamentoMensalModel lancamentoMensal) throws Exception {
//
//        Response.ResponseBuilder retorno = null;
//
//        try {
//            if(lancamentoMensalService.deletarLancamentoMensal(lancamentoMensal)) {
//                retorno = Response.ok("Lancamento excluído.");
//            } else {
//                retorno = Response.ok("Não foi encontrado lacamento com ID:" + lancamentoMensal.getIdLancamento());
//            }
//        } catch (Exception e) {
//            retorno = Response.serverError().entity(e.getLocalizedMessage());
//        }
//
//        return retorno.build();
//    }
//
//    @POST
//    @Path("pesquisarLancamentoPorPeriodo")
//    @Override
//    public Response pesquisarLancamentoPorPeriodo(LancamentoMensalModel saida) throws Exception {
//
//        Response.ResponseBuilder retorno = null;
//
//        try {
//            retorno = Response.ok(lancamentoMensalService.pesquisarLancamentosPorPeriodo(saida));
//        } catch (Exception e) {
//            retorno = Response.serverError().entity(e.getLocalizedMessage());
//        }
//
//        return retorno.build();
//
//    }
//
    @GET
    @Override
    public List<LancamentoMensalModel> pesquisarLancamentos(@QueryParam("campo") String campo, @QueryParam("valor") String valor) throws Exception {

        try {
            if(descricao == null) {
                saida.setIdTipoLancamento(tipo);
                return lancamentoMensalService.pesqusiarLancamentosPorTipo(saida);
            } else {
                saida.setDescricaoLancamento(descricao);
                return lancamentoMensalService.pesquisarLancamentosPorDescricao(saida);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

//    @GET
//    @Override
//    public List<LancamentoMensalModel> pesquisarLancamentoPorTipo(Integer tipo) throws Exception {
//
//        LancamentoMensalModel saida = new LancamentoMensalModel();
//        saida.setIdTipoLancamento(tipo);
//
//        try {
//            return lancamentoMensalService.pesqusiarLancamentosPorTipo(saida);
//        } catch (Exception e) {
//            throw new Exception(e);
//        }
//    }
}
