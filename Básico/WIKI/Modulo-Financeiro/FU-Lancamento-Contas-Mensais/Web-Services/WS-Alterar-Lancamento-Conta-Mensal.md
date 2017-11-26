![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Alterar Lançamento Conta Mensal

## Descrição

Alteração de lançamentos de conta mensal.

## Atributos do Serviço

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos da chamada ao WS, sua obrigatoriedade e valores válidos

| Atributo                | Obrigatório | Observações                                      |
|-------------------------|:-----------:|--------------------------------------------------|
| idLancamento            |     S       | Identificador único do lançamento. int           |
| descricaoLancamento     |     N       | Descrição do lançamento. String                  |
| dataLancamento          |     N       | Data do lançamento. "YYYY-MM-dd"                 |
| valorLancamento         |     N       | Valor do lançamento. 99999999.99                 |
| idTipoLancamento        |     N       | Valor do lancamento. Valores: Numeração de 1 a 7 |


## JSON Request

~~~json
{
   "idLancamento": 2,
   "descricaoLancamento": "Teste Teste"
}
~~~

## Response

~~~json
{
   "idLancamento": 2,
   "descricaoLancamento": "Teste Teste",
   "dataLancamento": "2017-11-26 19:08",
   "valorLancamento": 10.5,
   "idTipoLancamento": 1
}
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
