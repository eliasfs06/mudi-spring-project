package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest page = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findAllByStatus(StatusPedido.ENTREGUE, page);	
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}
	
}
