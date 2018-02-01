package br.com.logic.dao.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.Date;

@XmlRootElement
@XmlType(propOrder = {"idLancamento", "descricaoLancamento", "dataLancamento", "valorLancamento", "idTipoLancamento"})
public class LancamentoMensalModel implements Serializable {
    private int idLancamento;

    @NotNull
    private String descricaoLancamento;

    @NotNull
    private Date dataLancamento;

    @NotNull
    private double valorLancamento;

    @NotNull
    private int idTipoLancamento;

    @XmlElement
    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    @XmlElement
    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    @XmlElement
    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @XmlElement
    public double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    @XmlElement
    public int getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(int idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }
}
