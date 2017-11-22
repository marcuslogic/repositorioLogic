package br.com.logic.financeiro.enums;

public enum TipoLancamentoEnum {
    ALIMENTACAO("Alimentação"),
    MORADIA("Moradia"),
    EDUCACAO("Educação"),
    TRANSPORTE("Transporte"),
    SAUDE("Saúde"),
    LAZER("Lazer"),
    OUTROS("Outros");

    private final String tipoLancamento;

    TipoLancamentoEnum(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public String get() {
        return tipoLancamento;
    }

    public static TipoLancamentoEnum recuperaTipoLancamento(String search) {
        for (TipoLancamentoEnum tipo : TipoLancamentoEnum.values()) {
            if (tipo.toString().equals(search)) {
                return tipo;
            }
        }

        return null;
    }
}
