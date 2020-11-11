package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Convidado;
import models.Evento;
import repository.ConvidadoRepository;
import repository.EventoRepository;

@Controller
public class EventoController {
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:cadastrarEvento";
	}
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView model= new ModelAndView("index");
		Iterable<Evento> eventos = eventoRepository.findAll();
		model.addObject("evento", eventos);
		return model;
		
	}
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") String codigo) {	
		Evento evento = this.eventoRepository.findByCodigo(Long.valueOf(codigo));
		
		ModelAndView model = new ModelAndView("evento/detalhesEvento");
		model.addObject("evento",evento);
		Iterable<Convidado> convidados= convidadoRepository.findByEvento(evento);
		model.addObject("convidados",convidados);
		return model;
		
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") String codigo, Convidado convidado) {	
		Evento evento = this.eventoRepository.findByCodigo(Long.valueOf(codigo));
		convidado.setEvento(evento);
		convidadoRepository.save(convidado);
		
		return "redirect:/{codigo}";
		
	}

}
