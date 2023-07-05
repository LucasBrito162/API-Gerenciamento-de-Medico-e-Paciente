# Sistema de Gerenciamento de Médicos e Pacientes.

Este é um projeto de API para gerenciar médicos e pacientes em uma clínica médica. Ele fornece endpoints para cadastrar, listar, atualizar e excluir registros de médicos e pacientes em um banco de dados.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Banco de dados (ex: MySQL, PostgreSQL)
- Maven

## Configuração do projeto

1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter o Java e o Maven instalados em seu sistema.
3. Configure o banco de dados de acordo com sua preferência e atualize as configurações no arquivo `application.properties`.
4. Execute o comando `mvn spring-boot:run` para iniciar o servidor de desenvolvimento.

## Como usar a API

A API possui os seguintes endpoints:

### Médicos

- `POST /medicos`: Cadastra um novo médico. Envie um payload JSON com os dados do médico.
- `GET /medicos`: Lista os médicos cadastrados.
- `PUT /medicos`: Atualiza as informações de um médico existente. Envie um payload JSON com os dados atualizados.
- `DELETE /medicos/{id}`: Exclui um médico com base no ID fornecido.

### Pacientes

- `POST /paciente`: Cadastra um novo paciente. Envie um payload JSON com os dados do paciente.
- `GET /paciente`: Lista os pacientes cadastrados.
- `PUT /paciente`: Atualiza as informações de um paciente existente. Envie um payload JSON com os dados atualizados.
- `DELETE /paciente/{id}`: Exclui um paciente com base no ID fornecido.

Certifique-se de incluir todas as informações necessárias nos payloads JSON conforme definido nas classes `DadosCadastroMedico`, `DadosAtualizacaoMedico`, `DadosCadastroPaciente` e `DadosAtualizacaoPaciente`.

## Contribuindo

Sinta-se à vontade para contribuir com melhorias neste projeto. Siga as diretrizes de contribuição e abra uma solicitação pull para que possamos revisar suas alterações.
