package br.dev.java10fx.CadastroDeNninjas.Missions.Repository;

import br.dev.java10fx.CadastroDeNninjas.Missions.Model.MissionsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionsRepository extends JpaRepository<MissionsModel, Long> {

}
