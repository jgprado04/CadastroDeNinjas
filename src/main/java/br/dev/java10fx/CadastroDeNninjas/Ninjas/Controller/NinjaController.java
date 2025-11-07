package br.dev.java10fx.CadastroDeNninjas.Ninjas.Controller;

import br.dev.java10fx.CadastroDeNninjas.DTO.NinjaDTO;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Services.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO =  ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Created with sucess: " + ninjaDTO.getName() + " ID: " + ninjaDTO.getId());
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjaDTOS = ninjaService.listNinjas();
        return ResponseEntity.ok(ninjaDTOS);
    }

    // Mostrar ninja por id (Read)
    @GetMapping("/list/{id}") // Path Variable, vai trocar pelo valor do parametro dado.
    public ResponseEntity<?> showNinjaById(@PathVariable Long id) {
        NinjaDTO foundedNinja = ninjaService.listNinjaByID(id);
        return foundedNinja != null ? ResponseEntity.status(HttpStatus.FOUND).body(foundedNinja)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja not founded with ID: " + id);
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO updateNinja) {
        NinjaDTO ninjaFounded = ninjaService.updateNinja(id, updateNinja);
        return ninjaFounded != null ? ResponseEntity.ok(ninjaFounded) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id: " + id + " not founded");
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/deleteID/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {
        if(ninjaService.listNinjaByID(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja ID: " + id + " deleted with sucess");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: " + id + " not founded");
    }

}
