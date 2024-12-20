package com.segsat.segsat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter @AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Column(unique = true, name = "cliente_email")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cep")
    @NotNull(message = "O CEP não pode ser nulo")
    private String cep;

    @Column(name = "endereco")
    @NotNull(message = "O endereço não pode ser nulo")
    private String endereco;

    @NotNull(message = "O bairro não pode ser nulo")
    @Column(name = "bairro")
    private String bairro;

    @NotNull(message = "A cidade não pode ser nulo")
    @Column(name = "cidade")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    @Column(name = "estado")
    private String estado;

    public Cliente(long id, String nome, String email, String cep, String endereco, String bairro,
                   String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
