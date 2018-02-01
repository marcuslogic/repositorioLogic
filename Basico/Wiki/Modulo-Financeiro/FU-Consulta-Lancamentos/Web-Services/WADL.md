
![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos/FU-Consulta-Lancamentos.md) :: [WADL](WADL.md)


# WADL da Funcionalidade: Consulta Lançamentos

~~~xml

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
<resources base="http://localhost:8080/Treinamento/v1/lancamentos">
<resource path="lancamentos">
<method id="addLancamentoMensal" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method id="updateLancamentoMensal" name="POST">
<request>
<ns2:representation xmlns:ns2="http://wadl.dev.java.net/2009/02" xmlns="" element="lancamentoMensalModel" mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method id="deleteLancamentoMensal" name="DELETE">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="lancamento" style="query" type="xs:int"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/findByPeriodo">
<method id="findByPeriodo" name="GET">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="periodo" style="query" type="xs:string"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/findByDescricao">
<method id="findByDescricao" name="POST">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/findByTipo">
<method id="findByTipo" name="GET">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="tipo" style="query" type="xs:int"/>
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
