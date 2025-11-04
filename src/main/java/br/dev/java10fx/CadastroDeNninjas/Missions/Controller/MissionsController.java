package br.dev.java10fx.CadastroDeNninjas.Missions.Controller;

import org.springframework.web.bind.annotation.*;

// Camada de apresentacao na Web (Controller)
@RestController
@RequestMapping("missions")
public class MissionsController {
    @GetMapping("/show") // GET - Mandar uma requisicao para mostrar missoes
    public String showMissions() {
        return "All missions";
    }

    @PostMapping("/create") // POST - Mandar uma requisicao para criar missoes
    public String createMission() {
        return "Mission create";
    }

    @PutMapping("/update") // PUT - Mandar uma requisicao para atualizar as missoes
    public String updateMission() {
        return "Mision update";
    }

    @DeleteMapping("/delete") // DELETE - Mandar uma requisicao para deletar as missoes
    public String deleteMission() {
        return "Mission delete";
    }
}
