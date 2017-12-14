![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Excluir Lançamento Conta Mensal

## Descrição

Remoção de Lançamento Conta Mensal existente.

## Atributos do Serviço

**NOTA AO DESENVOLVEDOR:** Coloque aqui a lista de atributos da chamada ao WS, sua obrigatoriedade e valores válidos

| Atributo                | Obrigatório | Observações                            |
|-------------------------|:-----------:|----------------------------------------|
| idLancamento            |     S       | Identificador único do lançamento. int |


## JSON Request

~~~json
{
   "idLancamento": 2
}
~~~

## Response

~~~json
Lancamento excluído.
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
