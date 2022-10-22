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
import com.devti.aula.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService cidadeService;
	
	@PostMapping
	public Cidade inserirCidade(@RequestBody Cidade cidade) {
		return cidadeService.incluir(cidade);
	}
	
	@GetMapping
	public List<Cidade> listarTodas(){
		return cidadeService.listarTodasCidades();
	}
	
	@PutMapping
	public Cidade alterar(@RequestBody Cidade cidade, @RequestParam("id") int id) {
		cidade.setId(id);
		return cidadeService.alterar(cidade);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") int id) {
		cidadeService.excluir(id);
	}
	
	@GetMapping("/{uf}")
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf){
		return cidadeService.buscarPorUf(uf);
	}
}
