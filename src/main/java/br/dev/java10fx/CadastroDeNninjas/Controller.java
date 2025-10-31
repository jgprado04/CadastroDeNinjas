package br.dev.java10fx.CadastroDeNninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Um controlador para API Rest
@RequestMapping // Colocar todas nossas rotas em um mesmo lugar, mapear as rotas
public class Controller {

    @GetMapping("/welcome") // Criando a rota e inserindo a mensagem
    public String welcome() {
        return "This is my first message in this rote!";
    }

}
