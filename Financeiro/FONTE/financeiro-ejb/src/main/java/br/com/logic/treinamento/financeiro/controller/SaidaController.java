package br.com.logic.treinamento.financeiro.controller;

import br.com.logic.treinamento.dao.model.SaidaModel;
import br.com.logic.treinamento.financeiro.service.SaidaService;
import com.google.gson.Gson;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Stateless
@WebService
public class SaidaController {

    static SaidaService saidaService = new SaidaService();

    @WebMethod
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String busca() throws Exception {

        System.out.print("TEste");
        ArrayList<SaidaModel> saidas = new ArrayList<SaidaModel>();
        saidas.addAll(saidaService.getTodasSaidas());
        Gson jsonParse = new Gson();

        return jsonParse.toJson(saidas);
    }
}
