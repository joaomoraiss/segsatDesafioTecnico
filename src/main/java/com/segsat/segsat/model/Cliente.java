package com.segsat.segsat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter @Setter
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

    public Cliente(long id, String nome, String email, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    public Cliente(long id, String nome, String email, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
    }
}
