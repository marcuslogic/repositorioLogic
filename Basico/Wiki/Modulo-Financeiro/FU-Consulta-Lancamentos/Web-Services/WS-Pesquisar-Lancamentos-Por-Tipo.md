![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos.md) :: [WS-Pesquisar Lancamentos por Tipo](WS-Pesquisar-Lancamentos-Por-Tipo.md)


# WebService: Pesquisar Lancamentos por Tipo

## Descrição

Pesquisa de lançamentos por tipo de lançamento

## Atributos do Serviço


| Atributo                          | Obrigatório | Observações                                      |
|-----------------------------------|:-----------:|--------------------------------------------------|
| idTipoLancamento                  |     S       | Valor do lancamento. Valores: Numeração de 1 a 7 |

## Demais Validações

## JSON Request

~~~xml
{
	"idTipoLancamento":1
}
~~~

## Response

~~~json
[{
   "idLancamento": 2,
   "descricaoLancamento": "Teste",
   "dataLancamento": "2017-11-26 19:08",
   "valorLancamento": 10.5,
   "idTipoLancamento": 1
}]
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
