package br.dev.java10fx.CadastroDeNninjas.Missions.Model;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer dificulty;

    @OneToMany (mappedBy = "missoes") // Uma missao tem mais de um ninja. mappedBy - conectar por Chave Estrangeira o relacionamento entre as entidades
    private List<NinjaModel> ninjas;
}
