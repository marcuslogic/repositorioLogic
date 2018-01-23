![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos.md) :: [WS-Pesquisar Lancamentos por Nome](WS-Pesquisar-Lancamentos-Por-Nome.md)


# WebService: Pesquisar Lancamentos por Nome

## Descrição

Pesquisa de lançamentos por parte do nome do lançamento

## Atributos do Serviço


| Atributo                          | Obrigatório | Observações                              |
|-----------------------------------|:-----------:|------------------------------------------|
| descricaoLancamento               |     S       | Descrição do lancamento. Valores: String |

## JSON Request

~~~json
{
	"descricaoLancamento":"Teste"
}
~~~

## Response

~~~json
[{
   "idLancamento": 2,
   "descricaoLancamento": "Teste",
   "dataLancamento": "2017-11-26 19:06",
   "valorLancamento": 10.5,
   "idTipoLancamento": 1
}]
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
