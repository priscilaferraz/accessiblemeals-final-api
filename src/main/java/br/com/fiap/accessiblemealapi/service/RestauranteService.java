package br.com.fiap.accessiblemealapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import br.com.fiap.accessiblemealapi.DTO.RestauranteDTO;
import br.com.fiap.accessiblemealapi.model.Restaurante;
import br.com.fiap.accessiblemealapi.repository.RestauranteRepository;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository repository;

    public List<Restaurante> listAll() {
        return repository.findAll();
    }

    public Restaurante save(RestauranteDTO dto) {
        Restaurante restaurante = RestauranteDTO.toModel(dto);
        return repository.save(restaurante);
    } 

    public Optional<Restaurante> getById(Long id) {
        return repository.findById(id);
    }

    public List<Restaurante> findByTypePCD(String typePCD) {
        return repository.findByTypePCD(typePCD);
    }

    public List<Restaurante> findByClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void updateById(Long id, RestauranteDTO dto) {
        var restaurante = getById(id).orElseThrow( () -> new RuntimeException());
        BeanUtils.copyProperties(RestauranteDTO.toModel(dto), restaurante);
        restaurante.setId(id);
        repository.save(restaurante);
    }
    
}
