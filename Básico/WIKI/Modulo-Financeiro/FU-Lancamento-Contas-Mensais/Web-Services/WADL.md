
![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WADL](WADL.md)


# WADL da Funcionalidade: Lançamento Contas Mensais

~~~xml

This XML file does not appear to have any style information associated with it. The document tree is shown below.
<application xmlns="http://wadl.dev.java.net/2009/02">
<doc xmlns:jersey="http://jersey.java.net/" jersey:generatedBy="Jersey: 1.19.4 05/24/2017 03:20 PM"/>
<doc title="Treinamento WADL" xml:lang="pt-br">
<![CDATA[ Treinamento WADL ]]>
</doc>
<grammars>
<include href="xsd0.xsd">
<doc/>
</include>
</grammars>
<resources base="http://localhost:8080/Treinamento/saida">
<resource path="/">
<resource path="incluirLancamentoMensal">
<method id="incluirLancamentoMensal" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="alterarLancamentoMensal">
<method id="alterarLancamentoMensal" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="excluirLancamentoMensal">
<method id="excluirLancamentoMensal" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="pesquisarLancamentoPorPeriodo">
<method id="pesquisarLancamentoPorPeriodo" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="pesquisarLancamentoPorDescricao">
<method id="pesquisarLancamentoPorDescricao" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="pesquisarLancamentoPorTipo">
<method id="pesquisarLancamentoPorTipo" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
</resources>
</application>

~~~


_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
