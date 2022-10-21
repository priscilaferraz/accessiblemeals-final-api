package br.com.fiap.accessiblemealapi.repository;

import java.util.List;

import br.com.fiap.accessiblemealapi.model.Restaurante;

public interface RestauranteRepositoryCustom {
    List<Restaurante> getByAcessibilidade(String acessibilidade);
}
