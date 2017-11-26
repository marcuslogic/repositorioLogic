![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../ReadMe.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](FU-Lancamento-Contas-Mensais/FU-Lancamento-Contas-Mensais.md)


# Funcionalidade: Lançamento Contas Mensais

## Descrição

Esta funcionalidade permite ao **Usuário** o lançamento de contas de despesas mensais com:
- Data
- Descrição
- Valor

As contas são organizadas por tipo de lançamento.

## Funcionalidades Impactadas

| Funcionalidade                                                                                     | Descrição                                      |
|----------------------------------------------------------------------------------------------------|------------------------------------------------|
| [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos/FU-Consulta-Lancamentos.md)                      | Consulta de Lançamento de Contas Mensais       |
| [FU-Conta Corrente](../FU-Conta-Corrente/FU-Conta-Corrente.md)                                        | Atualização de Totais de Conta Corrente        |
| [FU-Log Rastreamento Contas](../FU-Log-Rastreamento-Contas/FU-Log-Rastreamento-Contas.md)             | Log Rastreamento Lançamentos em Conta Corrente |
| [FU-Notificação Novo Lançamento](../FU-Notificacao-Novo-Lancamento/FU-Notificacao-Novo-Lancamento.md) | Notificacao Web Browser de Novo Lançamento     |

## Regras de Negócios

| Regra de Negócios                                                       | Descrição                                                      |
|-------------------------------------------------------------------------|----------------------------------------------------------------|
| [RN-Campos Contas Mensais](Regras-de-Negocios/RN-Campos-Contas-Mensais.md) | Campos e valores válidos para os lançamentos de contas mensais |
| [RN-Tipo de Lançamento](Regras-de-Negocios/RN-Tipo-de-Lancamento.md)       | Enumeração dos Tipos de Lançamento                             |

## Casos de Uso

## Web Services

**[WADL](Web-Services/WADL.md)**

| Web Service                                                                              | Descrição                                      |
|------------------------------------------------------------------------------------------|------------------------------------------------|
| [WS-Incluir Lancamento Conta Mensal](Web-Services/WS-Incluir-Lancamento-Conta-Mensal.md) | Inclusão de novo Lançamento Conta Mensal       |
| [WS-Alterar Lancamento Conta Mensal](Web-Services/WS-Alterar-Lancamento-Conta-Mensal.md) | Alteração de Lançamento Conta Mensal existente |
| [WS-Excluir Lancamento Conta Mensal](Web-Services/WS-Excluir-Lancamento-Conta-Mensal.md) | Remoção de Lançamento Conta Mensal existente   |

## Estrutura de Classes

**NOTA AO DESENVOLVEDOR:** Coloque aqui as classes relacionadas a funcionalidade, ordenadas alfabeticamente de A->Z pelo nome da classe

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

_Diagrama UML: [UML-Classes-Lancamento-Contas-Mensais.asta](FU-Lancamento-Contas-Mensais-Anexos/UML-Classes-Lancamento-Contas-Mensais.asta)_

## Estrutura de Entidades

| Operação | Banco/Schema   | Entidade         | Descrição                                               |
|:--------:|----------------|------------------|---------------------------------------------------------|
|   ISU    | sistema/public | TB-LancamentoMensal | Despesas Mensais Lançadas                               |
|    S     | sistema/public | TB-TipoLancamento   | Normalização dos Tipo de Lançamento para Contas Mensais |

\* _Operações:_ (I)nsert, (S)elect, (U)pdate, (D)elete

_Diagrama DER: [DER-Lancamento-Contas-Mensais.asta](FU-Lancamento-Contas-Mensais-Anexos/DER-Lancamento-Contas-Mensais.asta)_

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
