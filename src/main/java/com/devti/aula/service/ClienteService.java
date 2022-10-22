package com.devti.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(int id) {
		Cliente cliente = clienteRepository.findById(id).get();
		if(cliente != null) {
			clienteRepository.delete(cliente);
		}
	}
	
	public List<Cliente> encontrarPorCidadeNome(String nome){
		return clienteRepository.findByCidadeNome(nome);
	}
}
