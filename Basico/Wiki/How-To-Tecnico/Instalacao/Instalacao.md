![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)


[Home](../../ReadMe.md) :: [How-to Técnico](../How-To-Tecnico.md) :: [Instalação](Instalacao.md)


# Instruções para deploy do sistema


## Ambiente usado

WildFly 11
HSQLDB


## Instalação WildFly 11


1. Clonar todo o projeto no Git no diretório /opt/.
Todos os arquivos necessários já estão inclusos no diretório, não sendo necessário nada além dos no diretório /opt/.

São dois servidores diferentes. Sendo um para os testes, testewildfly, e outro para desenvolvimento, wildfly.

O banco HSQLDB está dentro junto com o servidor /wildfly. Não sendo necessário qualquer intervenção para iniciar o banco, pois foi configurado em modo arquivo. Assim sempre que a aplicação é executada o banco é acessado sob demanda.


## Deploy


1. Acessar o diretório /opt/repositorioLogic/Basico/Fonte/
2. Executar o comando: mvn clean install -DskipTests
3. Executar o seguinte comando para copiar o .ear gerado para o servidor: cp treinamento-ear/target/treinamento-ear.ear ../../wildfly/standalone/deployments/
4. Acessar o diretório /opt/repositorioLogic/wildfly/bin/ e executar o seguinte comando: ./standalone.sh
URI para acessar os serviços: http://localhost:8080/Treinamento/v1/lancamentos/


## Testes


1. Acessar o diretório /opt/repositorioLogic/Basico/Fonte/
2. Executar o comando: mvn tests
Os testes serão executados.