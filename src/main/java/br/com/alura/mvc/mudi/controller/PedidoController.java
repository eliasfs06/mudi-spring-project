package br.com.alura.mvc.mudi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.NovoPedidoDto;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(NovoPedidoDto novoPedidoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(@Valid NovoPedidoDto novoPedido, BindingResult br) {
		
		if(br.hasErrors()) {
			return "pedido/formulario";
		}
		
		try {
			novoPedido.setStatus(StatusPedido.AGUARDANDO);
			pedidoRepository.save(novoPedido.toPedido(novoPedido));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@GetMapping("{status}")
	public String listarPedidos(Model model, @PathVariable String status) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(status.toUpperCase());
		
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}
}
