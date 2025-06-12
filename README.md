## LibGames - Biblioteca de Jogos
Descrição do Projeto
LibGames é um sistema simples, porém eficiente, para gerenciar uma biblioteca de jogos digitais. Desenvolvido em Java, o projeto oferece funcionalidades básicas de um CRUD (Create, Read, Update, Delete) para cadastro, consulta, atualização e exclusão de jogos.

Ideal para quem quer controlar sua coleção de jogos de forma organizada, armazenando dados importantes como plataforma, gênero, nota, desenvolvedora e status do jogo (zerado, jogando, não iniciado).

## Diagrama de classe inicial
![](https://cdn.discordapp.com/attachments/1250289117909090375/1382871346144346122/raw.png?ex=684cbacd&is=684b694d&hm=f856312cec8e462e9d43bb153145dc8fc45ade6ee9283d3a8101932a7542103f)
## Funcionalidades
Cadastrar jogos: Permite adicionar novos jogos com informações completas.
Listar jogos: Exibe todos os jogos cadastrados com detalhes.
Atualizar jogos: Modifica os dados de jogos já existentes.
Excluir jogos: Remove jogos da biblioteca.
Interface de console simples: Fácil de usar via linha de comando.

## Tecnologias Utilizadas

Java 11+
JDBC para conexão com banco de dados MySQL
MySQL Connector/J (driver JDBC)
Maven para gerenciamento de dependências

## Estrutura do Projeto
enumeration: Enumerações para plataformas e status dos jogos.
model: Classe Jogos representando o objeto de domínio.
dao: Classe de acesso a dados para operações no banco.
view: Interface via terminal para interação com o usuário.
Banco de Dados
Utiliza MySQL para armazenar os dados dos jogos. É necessário configurar a conexão no ConnectionFactory.

## Como Rodar

Configure seu banco MySQL e ajuste as credenciais no ConnectionFactory.
Compile e execute o projeto via Maven.
Utilize o menu interativo para cadastrar, listar, atualizar ou excluir jogos.

## Objetivo
Criar uma aplicação funcional e didática que exemplifica o padrão CRUD utilizando Java e banco de dados, ideal para aprendizado e como base para projetos futuros.

