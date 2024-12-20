package com.segsat.segsat.service;

import com.segsat.segsat.DTO.ViaCepResponse;
import com.segsat.segsat.model.Cliente;
import com.segsat.segsat.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public void criarCliente(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("O email já está cadastrado.");
        }
        preencherEnderecoPorCep(cliente.getCep(), cliente);
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

        preencherEnderecoPorCep(novosDados.getCep(), novosDados);

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

    private void preencherEnderecoPorCep(String cep, Cliente cliente) {
        ResponseEntity<ViaCepResponse> response = restTemplate.getForEntity(VIA_CEP_URL,
                ViaCepResponse.class, cep);

        if (response.getStatusCode().is2xxSuccessful()) {
            ViaCepResponse viaCepResponse = response.getBody();
            if (viaCepResponse != null) {
                cliente.setEndereco(viaCepResponse.getLogradouro());
                cliente.setBairro(viaCepResponse.getBairro());
                cliente.setCidade(viaCepResponse.getLocalidade());
                cliente.setEstado(viaCepResponse.getEstado());
            }
        } else {
            throw new RuntimeException("Falha ao buscar o endereço via API.");
        }
    }

}
