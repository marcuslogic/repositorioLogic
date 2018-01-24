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
@Path("/lancamentos")
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
    @GET
    @Path("/findByPeriodo")
    @Override
    public List<LancamentoMensalModel> findByPeriodo(@QueryParam("periodo") String periodo) throws Exception {

        try {

            if(periodo == null) {
                throw new Exception("Periodo obrigatório.");
            }

            return lancamentoMensalService.findByPeriodo(periodo);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GET
    @Path("/findByDescricao")
    @Override
    public List<LancamentoMensalModel> findByDescricao(@QueryParam("descricao") String descricao) throws Exception {

        try {

            if(descricao == null) {
                throw new Exception("Descricao obrigatória.");
            }

            return lancamentoMensalService.findByDescricao(descricao);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GET
    @Path("/findByTipo")
    @Override
    public List<LancamentoMensalModel> findByTipo(@QueryParam("tipo") Integer tipo) throws Exception {

        try {

            if(tipo == null) {
                throw new Exception("Tipo obrigatório.");
            }

            return lancamentoMensalService.findByTipo(tipo);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
