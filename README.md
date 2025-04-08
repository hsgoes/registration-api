# registration-api

API para gerenciamento de pessoas, construída com Java e Spring.

## 🚀 Tecnologias

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java (versão 21)
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - JWT (Json Web Token)
- Maven

## 📦 Como rodar localmente

1. **Clone o repositório**

```bash
git clone https://github.com/hsgoes/registration-api.git
cd registration-api
```

2. **Compile o projeto com Maven**

Certifique-se de ter o Maven instalado. Rode o comando abaixo para construir o projeto e gerar o `.jar`:

```bash
mvn clean install
```

O arquivo `.jar` será gerado na pasta `target`.

3. **Execute o projeto com variáveis de ambiente**

Você pode passar as variáveis diretamente como propriedades do sistema no comando `java`:

```bash
java \
  -DDB_USERNAME=username \
  -DDB_PASSWORD=password \
  -DVIA_CEP_BASE_URL=https://viacep.com.br/ws \
  -DJWT_SECRET=secret \
  -DJWT_ISSUER=issuer \
  -jar target/registration-api-0.0.1-SNAPSHOT.jar
```

> Substitua os valores conforme o seu ambiente.

> Obs: ajuste o nome do arquivo `.jar` conforme a versão gerada.

## 🧪 Como usar

- Ao subir o projeto, a documentação completa da API estará disponível via Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

- Também está incluído neste repositório um arquivo `.json` contendo uma collection do Postman pronta para importação e testes.

## 👤 Autor

- [Hugo Goes](https://github.com/hsgoes)

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

