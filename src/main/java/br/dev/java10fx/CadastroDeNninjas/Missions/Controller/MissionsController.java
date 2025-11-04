package br.dev.java10fx.CadastroDeNninjas.Missions.Controller;

import org.springframework.web.bind.annotation.*;

// Camada de apresentacao na Web (Controller)
@RestController
@RequestMapping("/missions")
public class MissionsController {
    @GetMapping("/all") // GET - Mandar uma requisicao para mostrar missoes
    public String showAllMissions() {
        return "All missions";
    }

    @GetMapping("/allID") // GET - Mandar uma requisicao para mostrar missoes
    public String showAllMissionsById() {
        return "All missions by id";
    }

    @PostMapping("/create") // POST - Mandar uma requisicao para criar missoes
    public String createMission() {
        return "Mission create";
    }

    @PutMapping("/update") // PUT - Mandar uma requisicao para atualizar as missoes
    public String updateMission() {
        return "Mision update by id";
    }

    @DeleteMapping("/deleteID") // DELETE - Mandar uma requisicao para deletar as missoes
    public String deleteMission() {
        return "Mission delete by id";
    }
}
