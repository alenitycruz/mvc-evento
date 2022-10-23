package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.entities.Evento;
import com.gft.repositories.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    //Salvar
    public Evento salvarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    //Listar todos
    public List<Evento> listarTodosOsEventos(){
        return eventoRepository.findAll();
    }

    //Listar por id
    public Optional<Evento> listarPorIdEvento(Long id){
        return eventoRepository.findById(id);
    }

    //Obter 
    public Evento obterEvento(Long id) throws Exception{
        Optional<Evento> evento = eventoRepository.findById(id);
        if(evento.isEmpty()){
            throw new Exception("Evento não encontrado");
        }
        return evento.get();
    }

    //Excluir
    public void excluirEvento(Long id) throws Exception{
        Evento evento = obterEvento(id);
        //eventoRepository.deleteById(id);
        evento.setStatus(false);
        eventoRepository.save(evento);
    }
}
