package br.dev.java10fx.CadastroDeNninjas.DTO;

import br.dev.java10fx.CadastroDeNninjas.Missions.Model.MissionsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Tudo que eu tenho no meu Model, mas nao tem responsabilidade de uma Entidade
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private String rank;
    private MissionsModel missions;
}
