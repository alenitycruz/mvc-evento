package com.gft.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.entities.Evento;
import com.gft.services.EventoService;

@Controller
@RequestMapping("evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @RequestMapping(path="novo")
    public ModelAndView novoEvento(){

        ModelAndView mv = new ModelAndView("evento/cadastrar.html");
        mv.addObject("evento", new Evento());
        return mv;
    }
    
    @RequestMapping(method=RequestMethod.POST, path="novo")
    public ModelAndView salvarEvento(@Valid Evento evento, BindingResult bindingResult){

        ModelAndView mv = new ModelAndView("evento/cadastrar.html");

        boolean novo = true;

        if(evento.getId_evento() != null){
            novo=false;
        }

        if(bindingResult.hasErrors()){
            mv.addObject("evento", evento);
            return mv;
        }
        Evento linguagemSalva = eventoService.salvarEvento(evento);
        if(novo){
            mv.addObject("evento", new Evento());
        }else{
            mv.addObject("evento", linguagemSalva);
        }
        mv.addObject("mensagem", "Evento salvo com sucesso");
        return mv;
    }

    @RequestMapping
    public ModelAndView listarEvento(){
        ModelAndView mv = new ModelAndView("evento/listar.html");
        mv.addObject("lista", eventoService.listarTodosOsEventos());
        return mv;
    }

    @RequestMapping("/editar")
    public ModelAndView editarEvento(@RequestParam Long id){
        ModelAndView mv = new ModelAndView("evento/cadastrar.html");
        Evento ling;
        try {
            ling = eventoService.obterEvento(id);
        } catch (Exception e) {
            ling = new Evento();
            mv.addObject("mensagem", e.getMessage());
        }
        mv.addObject("evento", ling);
        return mv;
    }

    @RequestMapping("/excluir")
    public ModelAndView excluirEvento(@RequestParam Long id, RedirectAttributes redirectAttributes){
        ModelAndView mv = new ModelAndView("redirect:/evento");
        try {
            eventoService.excluirEvento(id);
            redirectAttributes.addFlashAttribute("mensagem", "Evento excluído com sucesso");
        } catch (Exception e) {
            mv.addObject("mensagem", "Erro ao excluir evento"+e.getMessage());
        }
        return mv;
    }
}
