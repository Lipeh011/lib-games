## LibGames - Biblioteca de Jogos
Descrição do Projeto
LibGames é um sistema simples, porém eficiente, para gerenciar uma biblioteca de jogos digitais. Desenvolvido em Java, o projeto oferece funcionalidades básicas de um CRUD (Create, Read, Update, Delete) para cadastro, consulta, atualização e exclusão de jogos.

Ideal para quem quer controlar sua coleção de jogos de forma organizada, armazenando dados importantes como plataforma, gênero, nota, desenvolvedora e status do jogo (zerado, jogando, não iniciado).

## Diagrama de classe inicial
![](https://media.discordapp.net/attachments/1250289117909090375/1382872077714980965/raw.png?ex=684cbb7b&is=684b69fb&hm=7d7c5d7b609844f2e3179a44f7662e64af77acc8dd30eeccc2bff55d0dd91342&=&format=webp&quality=lossless&width=379&height=569)
)
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

