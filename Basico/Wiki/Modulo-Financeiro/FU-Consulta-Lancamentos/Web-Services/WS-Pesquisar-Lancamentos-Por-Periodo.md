![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos.md) :: [WS-Pesquisar Lancamentos por Período](WS-Pesquisar-Lancamentos-Por-Periodo.md)


# WebService: findByPeríodo

## Descrição

Pesquisa de lançamentos por período de tempo (dia/mês/ano)

## Atributos do Serviço

| Atributo                          | Obrigatório | Observações                                      |
|-----------------------------------|:-----------:|--------------------------------------------------|
| dataLancamento                    |     S       | Data do lancamento. Valores: "YYYY-MM-dd"        |

## URL Request

http://localhost:8080/Treinamento/v1/lancamentos/findByPeriodo?periodo=2018-01-01


## Response

~~~json
[{
   "idLancamento": 2,
   "descricaoLancamento": "Teste",
   "dataLancamento": "2017-11-26",
   "valorLancamento": 10.5,
   "idTipoLancamento": 1
}]
~~~

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
