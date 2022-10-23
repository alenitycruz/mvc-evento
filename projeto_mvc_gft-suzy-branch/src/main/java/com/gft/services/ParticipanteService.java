package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.entities.Participante;
import com.gft.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteRepository participanteRepository;

	public Participante create(Participante participante) {
		return participanteRepository.save(participante);

	}

	public List<Participante> readyAll() {
		return participanteRepository.findAll();

	}

	public Participante readId(Long id) throws Exception {
		Optional<Participante> participante = participanteRepository.findById(id);

		if (participante.isEmpty()) {
			throw new Exception("Participante não encontrado.");
		}

		return participante.get();
	}

	public void delete(Long id) {
		participanteRepository.deleteById(id);

	}
}
