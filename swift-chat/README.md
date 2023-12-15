# Projeto SwiftChat

### Visão Geral do Projeto
O SwiftChat é uma plataforma de chat ao vivo desenvolvida utilizando Angular no front-end e Spring Boot no back-end, proporcionando uma comunicação eficiente entre múltiplos usuários que possuam acesso a uma sala de bate-papo em comum. A aplicação utiliza WebSockets para facilitar a transmissão de mensagens e utiliza armazenamento em memória para gerenciamento das salas enquanto estão abertas.

### Objetivo do Projeto
O objetivo principal do SwiftChat é prover soluções simples e intuitivas de chat ao vivo, oferecendo uma plataforma para a comunicação entre usuários que possuam acesso a uma sala de bate-papo em comum. A aplicação visa proporcionar uma experiência fluida, permitindo a criação e participação em salas de bate-papo.

### Proposta de Solução
O SwiftChat é uma proposta de software que auxilia a comunicação entre um grupo de pessoas tendo como princípios otimização e simplicidade. A solução consiste em um sistema de chat baseado em WebSockets, implementado em Angular e Spring Boot.

## Cenários de uso da aplicação
### Cenário 1: Sala de Aula com Aluno com Dificuldades de Expressão Verbal
#### Contexto:
Em uma sala de aula, um aluno enfrenta dificuldades em verbalizar suas dúvidas devido à timidez, vergonha ou problemas de fala.

#### Ação do Usuário:
- O aluno, enfrentando uma dúvida ou dificuldade, decide enviar uma mensagem no chat da sala de aula.
#### Interatividade:
- O aluno utiliza o chat para formular sua pergunta ou expressar sua dúvida de forma escrita, sem a necessidade de fala.
#### Benefícios:
- Permite que alunos com dificuldades de expressão verbal participem ativamente, superando barreiras e contribuindo para o ambiente de aprendizado.

### Cenário 2: Espera entre Alunos em um Contexto de Perguntas ao Professor

#### Contexto:
- Em um ambiente onde os alunos devem esperar sua vez para fazer perguntas ao professor, há o risco de esquecer o que queriam perguntar durante a espera.
#### Ação do Usuário:
- Um aluno, enquanto espera sua vez para fazer uma pergunta ao professor, decide registrar a pergunta no chat para evitar esquecimentos.
#### Interatividade:
- O aluno utiliza o chat para digitar a pergunta, mantendo-a registrada enquanto aguarda a oportunidade de falar com o professor.
#### Benefícios:
- Evita que os alunos esqueçam suas perguntas durante a espera, garantindo que todas as dúvidas sejam abordadas.

### Cenário 3: Sala de Aula em um Ambiente Grande ou Auditório
#### Contexto:
Em uma sala de aula muito grande ou auditório, os alunos podem enfrentar dificuldades ao tentar fazer perguntas ao professor devido à distância.

#### Ação do Usuário:
- Um aluno, mesmo estando distante do professor, deseja esclarecer uma dúvida ou fazer uma pergunta.
#### Interatividade:
- O aluno utiliza o chat para enviar a pergunta ao professor, garantindo que ela seja recebida mesmo a uma distância considerável.
#### Benefícios:
- Elimina a necessidade de gritar ou levantar a voz, proporcionando um ambiente mais confortável para os alunos e evitando desgaste vocal.

## Composição da Aplicação:

### Back-End:
API REST utilizando Spring Boot.

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

## Requisitos Não Funcionais

RNF001 Desempenho: O sistema deve atualizar o chat de todos os usuários em até 10 segundos após o envio da mensagem.

RNF002 Segurança: Implementação de medidas de segurança para proteger contra ataques como XSS e CSRF.

RNF003 Escalabilidade: Capacidade de lidar com um número de até 30 usuários por sala. 

## Regras de Negócio

RN001: O sistema não irá persistir informações de salas e mensagens após o bate-papo ser encerrado.

RN002: O sistema deverá ter o controle de usuários que já acessaram a aplicação por meio de um token ou session cookie armazenado no navegador.

RN003: Caso um usuário acesse uma URL que possua um ID que a aplicação não reconheça, este será redirecionado para a página inicial do site.

RN004: Apenas o administrador tem acesso à funcionalidades de gerenciamento da sala de bate-papo.

## Observações

- Este documento, juntamente com o design e a implementação correspondente, atende aos requisitos do trabalho prático, fornecendo uma visão clara do problema, da proposta de solução e dos padrões utilizados na implementação do SwiftChat.
