package br.dev.java10fx.CadastroDeNninjas.Ninjas.Services;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// A camada de logica, tem que ser conectar com a camada de Repository por meio da injecao de dependencia para dar acesso a NinjaRepository
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjaByID(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
