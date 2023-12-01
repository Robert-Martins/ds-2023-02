## Projeto SwiftChat

### Visão Geral do Projeto
O SwiftChat é um aplicativo de chat ao vivo que permite a comunicação entre múltiplos usuários. Desenvolvido utilizando Angular e Spring Boot, o aplicativo utiliza WebSockets para garantir uma comunicação eficiente e em tempo real.

### Problema, Necessidade ou Demanda
A comunicação eficiente e em tempo real é uma necessidade crescente nos dias de hoje. A demanda por soluções de chat ao vivo, que permitam interações instantâneas entre usuários, motivou o desenvolvimento do SwiftChat. Este software visa atender a essa demanda, proporcionando uma plataforma de chat simples e eficaz.

### Proposta de Solução
O SwiftChat é uma proposta de software que resolve o problema da comunicação em tempo real, proporcionando uma experiência de chat dinâmica e interativa. A solução consiste em um sistema de chat baseado em WebSockets, implementado em Java e Spring Boot.

## Composição da Aplicação:

### Back-End:
API REST utilizando 

### Front-End:
Desenvolvimento de uma interface de usuário amigável para o chat.

### Web Sockets:
Uso de Websockets para compartilhamento de dados do servidor para os devidos clientes.

### Banco de Dados H2:
Uso do banco de dados relacional H2 para persistência de informações de salas em execução na memória da aplicação.

## Requisitos Funcionais

RF001: Cadastro de salas de bate-papo: Usuários, ao acessar a aplicação, terão a possibilidade cadastrar uma nova sala de bato-papo.

RF002: Compartilhamento de acesso à sala de bate-papo: Usuários administradores, responsáveis pela criação da sala, conseguirão, pela aplicação, disponibilizar a URL ou QR Code para que outros usuários tenham acesso à sala de bate-papo.

RF003: Acesso à sala de bate-papo: Usuários participantes, que acessam uma sala já existente, terão acesso a um bate-papo ao acessar um link válido.

RF004: Inclusão de nome de usuário: Usuários, ao acessarem ou criarem salas de bate-papo, deverão definir o nome de seus usuários, caso já o tenham feito, terão a possibilidade de alterar o descrito.

RF006: Lista de Participantes: Usuários terão a possibilidade de visualizar usuários que estão ou já estiveram conectados à sala. Ainda, deverá ser possível identificar usuários online, ausentes e offline. Ausentes seriam aqueles que não realizam ações na UI em um período de tempo de 3 minutos. Offline seriam aqueles que fecharam a guia da sala mas em algum momento estiveram presentes.

RF007: Envio de Mensagens: Os usuários podem enviar mensagens de texto que serão visualizadas por todos os participantes da sala.

RF008: Encerrar bate-papo: O usuário administrador da sala terá a possibilidade de encerrar o bate-papo à qualquer momento. Isto iniciará uma contagem de 1 minuto para desconexão dos usuários.

### Requisitos Não Funcionais

RNF001 Desempenho: O sistema deve atualizar o chat de todos os usuários em até 10 segundos após o envio da mensagem.

RNF002 Segurança: Implementação de medidas de segurança para proteger contra ataques como XSS e CSRF.

RNF003 Escalabilidade: Capacidade de lidar com um número de até 30 usuários por sala. 

### Regras de Negócio

RN001: O sistema não irá persistir informações de salas e mensagens após o bate-papo ser encerrado.

RN002: O sistema deverá ter o controle de usuários que já acessaram a aplicação por meio de um token ou session cookie armazenado no navegador.

RN003: Caso um usuário acesse uma URL que possua um ID que a aplicação não reconheça, este será redirecionado para a página inicial do site.

RN004: Apenas o administrador tem acesso à funcionalidades de gerenciamento da sala de bate-papo.

## Observações

- Este documento, juntamente com o design e a implementação correspondente, atende aos requisitos do trabalho prático, fornecendo uma visão clara do problema, da proposta de solução e dos padrões utilizados na implementação do SwiftChat.
