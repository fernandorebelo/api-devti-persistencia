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
import com.devti.aula.service.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService cidadeService;
	
	@PostMapping
	@ApiOperation(value = "Inserir uma cidade")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade inserida"),
			@ApiResponse(code = 500, message = "Não foi possível inserir")
	})
	public Cidade inserirCidade(@RequestBody Cidade cidade) {
		return cidadeService.incluir(cidade);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar todas cidades")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de cidades retornada"),
			@ApiResponse(code = 500, message = "Não foi possível listar")
	})
	public List<Cidade> listarTodas(){
		return cidadeService.listarTodasCidades();
	}
	
	@PutMapping
	@CrossOrigin
	@ApiOperation(value = "Alterar uma cidade")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade alterada"),
			@ApiResponse(code = 500, message = "Não foi possível alterar")
	})
	public Cidade alterar(@RequestBody Cidade cidade) {
		return cidadeService.alterar(cidade);
	}
	
	@DeleteMapping("/excluir/{id}")
	@ApiOperation(value = "Excluir uma cidade")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade excluída"),
			@ApiResponse(code = 500, message = "Não foi possível excluir")
	})
	public void excluir(@PathVariable("id") int id) {
		cidadeService.excluir(id);
	}
	
	@GetMapping("/{uf}")
	@ApiOperation(value = "Buscar uma cidade por UF")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Busca por UF com sucesso"),
			@ApiResponse(code = 500, message = "Não foi possível buscar por UF")
	})
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf){
		return cidadeService.buscarPorUf(uf);
	}
}
