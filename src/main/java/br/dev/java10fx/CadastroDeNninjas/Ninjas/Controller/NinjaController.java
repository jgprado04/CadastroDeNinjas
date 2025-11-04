package br.dev.java10fx.CadastroDeNninjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController // Um controlador para API Rest
@RequestMapping // Colocar todas nossas rotas em um mesmo lugar, mapear as rotas
public class NinjaController {

    @GetMapping("/welcome") // Criando a rota e inserindo a mensagem
    public String welcome() {
        return "This is my first message in this rote!";
    }

    // Adicionar Ninja (Create)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja Create";
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/all")
    public String showAllNinjas() {
        return "Show Ninja";
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/allId")
    public String showAllNinjasById() {
        return "Show Ninja by id";
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/update")
    public String updateNinja() {
        return "Ninja Update by id";
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/deleteID")
    public String deleteNinja() {
        return "Ninja deleted by id";
    }

}
