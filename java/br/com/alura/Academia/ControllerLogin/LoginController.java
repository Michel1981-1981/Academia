package br.com.alura.Academia.ControllerLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.alura.Academia.Configuracao;

@SpringBootApplication
@Controller
public class LoginController {
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}

	@GetMapping("/")
	public String teste() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}


