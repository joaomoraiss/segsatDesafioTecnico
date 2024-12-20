
# Desafio Técnico SEGSAT

## Acesso ao Banco de Dados

1. Acesse o console do H2 em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. Use as seguintes configurações para conectar:
    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **Username**: `sa`
    - **Password**: (deixe em branco)

---

## Rotas da API

### 1. Criar Cliente (POST)
- **URL**: `http://localhost:8080/clientes`
- **CEP**: Deve ser enviado exclusivamente no formato **"12345678"**.
- **Exemplo de Parâmetros (JSON)**:
```json
{
  "nome": "Carlos Oliveira",
  "email": "carlos@example.com",
  "telefone": "111111111",
  "cep": "52130275"
}
```
- **Respostas**:
    - `201 Created`: Cliente criado com sucesso.
    - `400 Bad Request`: Validação falhou (ex.: CEP em formato incorreto, email já existente ou algum parâmetro não foi enviado).

---

### 2. Buscar Todos os Clientes (GET)
- **URL**: `http://localhost:8080/clientes`
- **Respostas**:
    - `200 OK`: Lista de clientes retornada.

---

### 3. Buscar Cliente por ID (GET)
- **URL**: `http://localhost:8080/clientes/{id}`
- **Respostas**:
    - `200 OK`: Cliente encontrado.
    - `404 Not Found`: Cliente não encontrado.

---

### 4. Deletar Cliente (DELETE)
- **URL**: `http://localhost:8080/clientes/{id}`
- **Respostas**:
    - `204 No Content`: Cliente deletado com sucesso.
    - `404 Not Found`: Cliente não encontrado.

---

### 5. Atualizar Cliente (PUT)
- **URL**: `http://localhost:8080/clientes/{id}`
- **Exemplo de Parâmetros (JSON)**:
```json
{
  "nome": "Carlos Silva",
  "email": "carlos.silva@example.com",
  "telefone": "22222222",
  "cep": "01001000"
}
```
- **Respostas**:
    - `200 OK`: Cliente atualizado com sucesso.
    - `400 Bad Request`: Validação falhou.
    - `404 Not Found`: Cliente não encontrado.

---

## Observações

- Certifique-se de que a aplicação está em execução na porta 8080.
- Use ferramentas como Postman ou cURL para testar as rotas da API.
