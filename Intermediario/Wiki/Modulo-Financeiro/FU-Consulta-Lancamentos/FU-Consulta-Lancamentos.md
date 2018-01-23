![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](FU-Consulta-Lancamentos.md)


# Funcionalidade: Consulta Lançamentos

## Descrição

Consulta de Lançamento de Contas Mensais.

## Funcionalidades Impactadas

| Funcionalidade | Descrição |
|----------------|-----------|
| N.H.           | N.H.      |

## Regras de Negócios

| Regra de Negócios | Descrição |
|-------------------|-----------|
| N.H.              | N.H.      |

## Web Services

**[WADL](Web-Services/WADL.md)**

| Web Service                                                                              | Descrição                                      |
|------------------------------------------------------------------------------------------|------------------------------------------------|
| [WS-Pesquisar Lancamentos por Período](Web-Services/WS-Pesquisar-Lancamentos-Por-Periodo.md) | Pesquisa de lançamentos por período de tempo (dia/mês/ano) |
| [WS-Pesquisar Lancamentos por Nome](Web-Services/WS-Pesquisar-Lancamentos-Por-Nome.md) | Pesquisa de lançamentos por parte do nome do lançamento |
| [WS-Pesquisar Lancamentos por Tipo](Web-Services/WS-Pesquisar-Lancamentos-Por-Tipo.md) | Pesquisa de lançamentos por tipo de lançamento |


## Estrutura de Classes

| Pacote                                     | Classe                | Descrição                       |
|--------------------------------------------|-----------------------|---------------------------------|
| br.com.logic.dao.impl                      | ConnectBean              | Injeção do Datasource        |
| br.com.logic.dao.impl                      | LancamentoMensalBean     | DAO dos Lançamentos          |
| br.com.logic.dao.impl                      | LancamentoMensalModel    | Entidade dos Lancamentos     |
| br.com.logic.dao.util                      | JsonDateDeserializer     | Conversor de datas do Json   |
| br.com.logic.dao.util                      | JsonDateSerializer       | Conversor de datas do Json   |
| br.com.logic.financeiro.enums              | TipoLancamentoEnum       | Tipos de Lançamentos válidos |
| br.com.logic.financeiro.service            | LancamentoMensalService  | Valida regras de negócio     |
| br.com.logic.treinamentoservices.endpoint  | LancamentoMensalEndpoint | Endpoint REST                |
| br.com.logic.treinamentoservices.resources | LancamentoMensalResource | Serviços REST                |


_Diagrama UML: [UML-Classes-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/UML-Classes-Consulta-Lancamentos.asta)_

## Estrutura de Entidades

| Banco/Schema   | Entidade         | Descrição                                               |
|----------------|------------------|---------------------------------------------------------|
| sistema/public | LancamentoMensal | Despesas Mensais Lançadas                               |
| sistema/public | TipoLancamento   | Normalização dos Tipo de Lançamento para Contas Mensais |

_Diagrama DER: [DER-Consulta-Lancamentos.asta](FU-Consulta-Lancamentos-Anexos/DER-Consulta-Lancamentos.asta)_

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
