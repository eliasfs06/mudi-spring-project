package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping("pedidos/{status}")
	public String listarPedidos(Model model, @PathVariable String status) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<Pedido> pedidos = pedidoRepository.findByStatusAndUser(status.toUpperCase(), username);
		
		model.addAttribute("pedidos", pedidos);
		return "user/pedidos"; 
	}
	
	@GetMapping("pedidos")
	public String home(Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<Pedido> pedidos = pedidoRepository.findAllByUser(username);	
		model.addAttribute("pedidos", pedidos);
		return "user/pedidos"; 
	}
}
