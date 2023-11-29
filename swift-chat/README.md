## Projeto SwiftChat
### Visão Geral do Projeto
O SwiftChat é um aplicativo de chat ao vivo que permite a comunicação em tempo real entre múltiplos usuários. Desenvolvido utilizando Java e Spring Boot, o aplicativo utiliza WebSockets para garantir uma comunicação eficiente e em tempo real.

### Problema, Necessidade ou Demanda
A comunicação eficiente e em tempo real é uma necessidade crescente nos dias de hoje. A demanda por soluções de chat ao vivo, que permitam interações instantâneas entre usuários, motivou o desenvolvimento do SwiftChat. Este software visa atender a essa demanda, proporcionando uma plataforma de chat simples e eficaz.

### Proposta de Solução
O SwiftChat é uma proposta de software que resolve o problema da comunicação em tempo real, proporcionando uma experiência de chat dinâmica e interativa. A solução consiste em um sistema de chat baseado em WebSockets, implementado em Java e Spring Boot.

## O escopo do trabalho prático inclui:

### Backend com Spring Boot:
Implementação de um servidor WebSocket para facilitar a comunicação em tempo real.
Utilização do padrão Factory para criar instâncias de salas de chat.

### Frontend Interativo:

Desenvolvimento de uma interface de usuário amigável para o chat.
Utilização do padrão Adapter para integrar o frontend ao servidor WebSocket.

### Persistência de Mensagens:

Implementação da não persistência de mensagens ao sair da sala.

### Lista de Participantes:
Exibição em tempo real da lista de participantes na sala.

## Design e Implementação
O design da proposta de solução faz uso dos seguintes padrões:

### Factory:
Utilizado na criação de instâncias de salas de chat.

### Princípio de Inversão de Dependência:
Aplicado para facilitar a integração entre o frontend e o backend.

### Singleton:
Garante a existência de apenas uma instância do servidor WebSocket.

### Command:
Facilita o processamento de mensagens recebidas.

### Adapter:
Adapta a interface do frontend à interface do servidor WebSocket.

### Template:
Define o esqueleto do algoritmo para o processamento de mensagens.

### Iterator:
Utilizado para percorrer a lista de participantes na sala.

### State:
Gerencia o estado das salas de chat.

### Proxy:
Controla o acesso ao servidor WebSocket, fornecendo uma camada adicional de segurança.

## Requisitos Funcionais

#### Chat em Tempo Real:
Os usuários podem participar de salas de chat em tempo real.
Mensagens são transmitidas instantaneamente para todos os participantes da sala.

#### Presença no Chat:
Lista de participantes atuais visível para todos os usuários na sala.

#### Envio de Mensagens:
Os usuários podem enviar mensagens de texto.
Suporte ao envio de mensagens de imagem.

#### Persistência de Mensagens:
As mensagens não são persistidas. Ao sair da sala, as mensagens são perdidas.

## Requisitos Não Funcionais

#### Desempenho:
Resposta rápida em comunicação e atualização da lista de participantes.

#### Segurança:
Implementação de medidas de segurança para proteger contra ataques como XSS e CSRF.

#### Escalabilidade:
Capacidade de lidar com um grande número de usuários simultâneos.

## Cronograma de Desenvolvimento

#### Semana 1-2: Planejamento Inicial
Definir requisitos detalhados.
Esboçar a arquitetura do sistema.

#### Semana 3-4: Desenvolvimento do Backend
Configurar o ambiente de desenvolvimento.
Implementar a lógica do servidor WebSocket com Spring Boot.

#### Semana 5-6: Desenvolvimento do Frontend
Criar a interface do usuário para o chat.
Integração com o backend.

#### Semana 7-8: Testes e Correções
Realizar testes de unidade e integração.
Corrigir bugs e otimizar o desempenho.

#### Semana 9-10: Documentação e Entrega
Preparar documentação completa.
Realizar a entrega.

## Observações

- Outros padrões podem ser empregados conforme necessário durante a implementação.

- Este documento, juntamente com o design e a implementação correspondente, atende aos requisitos do trabalho prático, fornecendo uma visão clara do problema, da proposta de solução e dos padrões utilizados na implementação do SwiftChat.
