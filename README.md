Desafio Técnico SEGSAT 

Acesso ao Banco de Dados ->

1.Acesse o console do H2 em: http://localhost:8080/h2-console

2.Use as seguintes configurações para conectar:
    JDBC URL: jdbc:h2:mem:testdb
    Username: sa
    Password: (deixe em branco)


Rota POST -- http://localhost:8080/clientes
(CEP deve ser enviado exclusivamente no formato "12345678")
    Params: {
            "nome": "Carlos Oliveira",
            "email": "carlos@example.com",
            "telefone": "111111111",
            "cep": "52130275"
        }

201 Created: Cliente criado com sucesso.
400 Bad Request: Validação falhou (ex.: CEP em formato incorreto, email já existente ou alguma parametro não foi enviado).


Rota GET(ALL) -- http://localhost:8080/clientes


Rota GET(ID) -- http://localhost:8080/clientes/{id}


Rota DELETE(ID) -- http://localhost:8080/clientes/{id}

204 No Content: Cliente deletado com sucesso.
404 Not Found: Cliente não encontrado.


Rota PUT(ID) -- http://localhost:8080/clientes/{id}
    Params:{
            "nome": "Carlos Silva",
            "email": "carlos.silva@example.com",
            "telefone": "22222222",
            "cep": "01001000"
    }
200 OK: Cliente atualizado com sucesso.
400 Bad Request: Validação falhou.
404 Not Found: Cliente não encontrado.



Observações:
Certifique-se de que a aplicação está em execução na porta 8080.
Use ferramentas como Postman ou cURL para testar as rotas da API.