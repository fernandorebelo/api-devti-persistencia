package com.devti.aula.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.service.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	@ApiOperation(value = "Listar todos clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de clientes retornada"),
			@ApiResponse(code = 500, message = "Não foi possível listar")
	})
	public List<Cliente> listarTodos(){
		return clienteService.listarTodos();
	}
	
	@PostMapping
	@ApiOperation(value = "Inserir um cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente cadastrado com sucesso"),
			@ApiResponse(code = 500, message = "Não foi possível cadastrar")
	})
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteService.incluir(cliente);
	}
	
	@PutMapping
	@CrossOrigin
	@ApiOperation(value = "Alterar um cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente alterado com sucesso"),
			@ApiResponse(code = 500, message = "Não foi possível alterar")
	})
	public Cliente alterar(@RequestBody Cliente cliente) {
		return clienteService.alterar(cliente);
	}
	
	@DeleteMapping("/excluir/{id}")
	@ApiOperation(value = "Excluir um cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente excluído com sucesso"),
			@ApiResponse(code = 500, message = "Não foi possível excluir")
	})
	public void excluir(@PathVariable("id") int id) {
		clienteService.excluir(id);
	}
	
	@GetMapping("/{cidade}")
	@ApiOperation(value = "Buscar um cliente por cidade")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Busca por cidade concluída com sucesso"),
			@ApiResponse(code = 500, message = "Não foi possível buscar por cidade")
	})
	public List<Cliente> buscarEmCidadePor(@PathVariable("cidade") String cidade){
		return clienteService.encontrarPorCidadeNome(cidade);
	}
}
