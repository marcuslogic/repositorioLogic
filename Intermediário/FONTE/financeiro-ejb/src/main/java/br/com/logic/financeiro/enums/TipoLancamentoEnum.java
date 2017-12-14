package br.com.logic.financeiro.enums;

public enum TipoLancamentoEnum {
    ALIMENTACAO(1, "Alimentação"),
    MORADIA(2, "Moradia"),
    EDUCACAO(3, "Educação"),
    TRANSPORTE(4, "Transporte"),
    SAUDE(5, "Saúde"),
    LAZER(6, "Lazer"),
    OUTROS(7, "Outros");

    private final int codigo;
    private final String tipoLancamento;

    TipoLancamentoEnum(int codigo, String tipoLancamento) {
        this.codigo = codigo;
        this.tipoLancamento = tipoLancamento;
    }

    public String getDescricaoTipo() {
        return tipoLancamento;
    }

    public int getCodigo() {
        return codigo;
    }
}
