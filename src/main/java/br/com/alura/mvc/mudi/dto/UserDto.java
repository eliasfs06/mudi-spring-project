package br.com.alura.mvc.mudi.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.securingweb.Authority;

public class UserDto {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private Boolean enabled;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
    private Set<Authority> authorities = new HashSet<>();

	public User toUser() {
		User user = new User();
		user.setNome(nome);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(enabled);
		user.setAuthorities(authorities);
		
		return user;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
