package com.devti.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Cidade;
import com.devti.aula.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	public Cidade incluir(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public List<Cidade> listarTodasCidades(){
		return cidadeRepository.findAll();
	}
	
	public Cidade alterar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Integer id) {
		Cidade cidade = cidadeRepository.findById(id).get();
		if(cidade != null) {
			cidadeRepository.delete(cidade);
		}
	}
	
	public List<Cidade> buscarPorUf(String uf){
		return cidadeRepository.findByUf(uf);
	}
}
