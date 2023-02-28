package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.UserDto;
import br.com.alura.mvc.mudi.model.User;

@Controller
@RequestMapping("/novoUsuario")
public class NovoUsuarioController {

	@Autowired
	UserRepositoy userRespository;
	
	@GetMapping("")
	public String novoUsuario(UserDto user) {
		return "user/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid UserDto userDto, BindingResult br) {
		
		if(br.hasErrors()) {
			return "user/formulario";
		}
		
		User user = userDto.toUser();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.addAuthority("USER");
		userRespository.save(user);
		
		return "login";
	}
}
