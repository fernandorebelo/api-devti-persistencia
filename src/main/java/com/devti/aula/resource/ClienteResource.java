package com.devti.aula.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteService.listarTodos();
	}
	
	@PostMapping
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteService.incluir(cliente);
	}
	
	@PutMapping
	public Cliente alterar(@RequestBody Cliente cliente, @RequestParam("id") int id) {
		cliente.setId(id);
		return clienteService.alterar(cliente);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") int id) {
		clienteService.excluir(id);
	}
	
	@GetMapping("/{cidade}")
	public List<Cliente> buscarEmCidadePor(@PathVariable("cidade") String cidade){
		return clienteService.encontrarPorCidadeNome(cidade);
	}
}
