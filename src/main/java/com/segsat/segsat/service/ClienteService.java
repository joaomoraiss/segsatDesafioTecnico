package com.segsat.segsat.service;

import com.segsat.segsat.model.Cliente;
import com.segsat.segsat.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente){
        if (clienteRepository.findByEmail(cliente.getEmail()) != cliente)
            clienteRepository.save(cliente);
        else throw new IllegalArgumentException("O email já está cadastrado.");
    }

}
