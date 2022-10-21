package br.com.fiap.accessiblemealapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.accessiblemealapi.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String username);

    Optional<Cliente> findByEmailAndPassword(String email, String password);
}
