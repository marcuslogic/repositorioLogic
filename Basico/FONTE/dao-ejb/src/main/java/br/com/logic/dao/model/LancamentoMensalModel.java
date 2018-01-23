package br.com.logic.dao.model;

import br.com.logic.dao.util.JsonDateDeserializer;
import br.com.logic.dao.util.JsonDateSerializer;
import br.com.logic.dao.util.LocalDateTimeConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement
@XmlType(propOrder = {"idLancamento", "descricaoLancamento", "dataLancamento", "valorLancamento", "idTipoLancamento"})
public class LancamentoMensalModel implements Serializable {
    private int idLancamento;

    @NotNull
    private String descricaoLancamento;

    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @NotNull
    private LocalDateTime dataLancamento;

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
    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
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
