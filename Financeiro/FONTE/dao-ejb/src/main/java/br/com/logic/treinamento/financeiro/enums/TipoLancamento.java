package br.com.logic.treinamento.financeiro.enums;

public enum TipoLancamento {
    ALIMENTACAO("Alimentação"),
    MORADIA("Moradia"),
    EDUCACAO("Educação"),
    TRANSPORTE("Transporte"),
    SAUDE("Saúde"),
    LAZER("Lazer"),
    OUTROS("Outros");

    private final String tipoLancamento;

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    TipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
}
