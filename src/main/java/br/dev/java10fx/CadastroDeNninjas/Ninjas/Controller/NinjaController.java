package br.dev.java10fx.CadastroDeNninjas.Ninjas.Controller;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Services.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Um controlador para API Rest, para controlar as rotas
@RequestMapping("/ninjas") // Colocar todas nossas rotas em um mesmo lugar, mapear as rotas
public class NinjaController {

    private NinjaService ninjaService;

    // Injetando a dependencia do ninjaService...
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/allId")
    public List<NinjaModel> showNinjasById(Iterable<Long> ids) {
        return ninjaService.listNinjasById(ids);
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
