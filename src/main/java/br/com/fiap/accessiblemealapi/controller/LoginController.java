package br.com.fiap.accessiblemealapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.accessiblemealapi.model.Cliente;
import br.com.fiap.accessiblemealapi.model.Login;
import br.com.fiap.accessiblemealapi.service.ClienteService;

@RestController
@RequestMapping("/api/cliente/login/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> login(@RequestBody Login login) {

        var optional = service.findByEmailAndPassword(login.getEmail(), login.getPassword());

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.of(optional);
    }
}
