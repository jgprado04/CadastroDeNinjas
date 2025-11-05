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
    @PostMapping("/create") // @RequestBody Pegar um dado json e serializar para o controller receber e mandar para o db
    public NinjaModel createNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.createNinja(ninjaModel);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/list")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/list/{id}") // Path Variable, vai trocar pelo valor do parametro dado.
    public NinjaModel showNinjaById(@PathVariable Long id) {
        return ninjaService.listNinjaByID(id);
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
