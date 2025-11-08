package br.dev.java10fx.CadastroDeNninjas.Ninjas.Services;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.DTO.NinjaDTO;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Mapper.NinjaMapper;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import br.dev.java10fx.CadastroDeNninjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A camada de logica, tem que ser conectar com a camada de Repository por meio da injecao de dependencia para dar acesso a NinjaRepository
@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listNinjas() {
        return ninjaRepository.findAll().stream()
                .map(ninjaMapper::map)
                .toList();
    }

    public NinjaDTO listNinjaByID(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        return ninjaMapper.map(ninjaRepository.save(ninjaMapper.map(ninjaDTO)));
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> existNinja = ninjaRepository.findById(id);
        if(existNinja.isPresent()) {
            NinjaModel updateNinja = ninjaMapper.map(ninjaDTO);
            updateNinja.setId(id);
            return ninjaMapper.map(ninjaRepository.save(updateNinja));
        }
        return null;
    }
}
