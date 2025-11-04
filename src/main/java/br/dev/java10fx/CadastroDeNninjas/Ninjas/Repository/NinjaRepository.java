package br.dev.java10fx.CadastroDeNninjas.Ninjas.Repository;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
