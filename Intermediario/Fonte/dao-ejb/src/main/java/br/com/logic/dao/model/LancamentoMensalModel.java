package br.com.logic.dao.model;

import br.com.logic.dao.util.JsonDateDeserializer;
import br.com.logic.dao.util.JsonDateSerializer;
import br.com.logic.dao.util.LocalDateTimeConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement
@XmlType(propOrder = {"idLancamento", "descricaoLancamento", "dataLancamento", "valorLancamento", "idTipoLancamento"})
@Entity
@Table(name = "LANCAMENTOMENSAL")
public class LancamentoMensalModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idLancamento;

    @NotNull
    @Column(name = "DESCRICAOLANCAMENTO")
    private String descricaoLancamento;

    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @NotNull
    @Column(name = "DATALANCAMENTO")
    private LocalDateTime dataLancamento;

    @NotNull
    @Column(name = "VALORLANCAMENTO")
    private double valorLancamento;

    @NotNull
    @Column(name = "IDTIPOLANCAMENTO")
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
