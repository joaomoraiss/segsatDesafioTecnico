package com.segsat.segsat.service;

import com.segsat.segsat.model.Cliente;
import com.segsat.segsat.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("O email já está cadastrado.");
        }
        clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return Optional.ofNullable(clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id)));
    }

    public void deleteClienteById(long id){
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Deleção mal sucedida! Esse Cliente não foi encontrado" +
                    " ou não existe.");

        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(long id, Cliente novosDados) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));

        if (!clienteExistente.getEmail().equals(novosDados.getEmail()) &&
                clienteRepository.existsByEmail(novosDados.getEmail())) {
            throw new IllegalArgumentException("O e-mail já está em uso por outro cliente.");
        }

        clienteExistente.setNome(novosDados.getNome());
        clienteExistente.setEmail(novosDados.getEmail());
        clienteExistente.setTelefone(novosDados.getTelefone());
        clienteExistente.setCep(novosDados.getCep());
        clienteExistente.setEndereco(novosDados.getEndereco());
        clienteExistente.setBairro(novosDados.getBairro());
        clienteExistente.setCidade(novosDados.getCidade());
        clienteExistente.setEstado(novosDados.getEstado());

        return clienteRepository.save(clienteExistente);
    }

}
