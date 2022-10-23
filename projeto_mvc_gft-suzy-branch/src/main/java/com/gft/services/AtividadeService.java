package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.entities.Atividade;
import com.gft.repositories.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	public Atividade create(Atividade atividade) {
		return atividadeRepository.save(atividade);

	}

	public List<Atividade> readyAll() {
		return atividadeRepository.findAll();

	}

	public Atividade readId(Long id) throws Exception {
		Optional<Atividade> atividade = atividadeRepository.findById(id);

		if (atividade.isEmpty()) {
			throw new Exception("AtividadeEntity não encontrada.");
		}

		return atividade.get();
	}

	public void delete(Long id) {
		atividadeRepository.deleteById(id);

	}
}
