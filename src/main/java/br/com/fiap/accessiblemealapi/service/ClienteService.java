package br.com.fiap.accessiblemealapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.accessiblemealapi.model.Cliente;
import br.com.fiap.accessiblemealapi.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<Cliente> listAll() {
        return repository.findAll();
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    } 

    public Optional<Cliente> getById(Long id) {
        return repository.findById(id);
    }
    
    public Optional<Cliente> findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public Map<String, Object> login(String email, String password) {
        Cliente cliente = repository.findByEmailAndPassword(email, password).orElseThrow(() -> new RuntimeException() );
        Map<String, Object> response = new HashMap<>();

        response.put("id", cliente.getId());
        response.put("name", cliente.getName());
        response.put("email", cliente.getEmail());
        response.put("isPCD", cliente.getIsPCD());
        response.put("typePCD", cliente.getTypePCD());

        return response;
    }

}
