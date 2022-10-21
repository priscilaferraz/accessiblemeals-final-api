package br.com.fiap.accessiblemealapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.accessiblemealapi.DTO.RestauranteDTO;
import br.com.fiap.accessiblemealapi.model.Restaurante;
import br.com.fiap.accessiblemealapi.service.RestauranteService;

@RestController
@RequestMapping("/api/restaurante/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @GetMapping
    public List<Restaurante> index(@RequestParam(required = false) String typePCD) {
        if (typePCD != null) {
            return service.findByTypePCD(typePCD);
        }
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Restaurante> create(@Valid @RequestBody RestauranteDTO dto) {
        Restaurante restaurante = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurante> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @GetMapping(value="/findbycliente/{clienteId}")
    public List<Restaurante> findByClienteId(@PathVariable Long clienteId){
        return service.findByClienteId(clienteId);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "restaurante", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RestauranteDTO newDto){
        service.updateById(id, newDto);
        return ResponseEntity.ok().build();
    }
}
