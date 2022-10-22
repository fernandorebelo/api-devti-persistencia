package com.devti.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devti.aula.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	public List<Cliente> findByCidadeNome(String nome);
}
