![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Incluir Lançamento Conta Mensal

## Descrição

Inclusão de lançamentos de conta mensal

## Atributos do Serviço

| Atributo                | Obrigatório | Observações                                      |
|-------------------------|:-----------:|--------------------------------------------------|
| descricaoLancamento     |     S       | Descrição do lançamento. String                  |
| dataLancamento          |     S       | Data do lançamento. "YYYY-MM-dd"                 |
| valorLancamento         |     S       | Valor do lançamento. 99999999.99                 |
| idTipoLancamento        |     S       | Valor do lancamento. Valores: Numeração de 1 a 7 |

## Demais Validações

## JSON Request

~~~json
{
	"descricaoLancamento":"Teste",
	"dataLancamento":"2017-11-26 00:00",
	"valorLancamento":10.50,
	"idTipoLancamento": 1
}
~~~

## Response

~~~json
{
   "idLancamento": 2,
   "descricaoLancamento": "Teste",
   "dataLancamento": "2017-11-26 00:00",
   "valorLancamento": 10.5,
   "idTipoLancamento": 1
}
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
