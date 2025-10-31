package br.dev.java10fx.CadastroDeNninjas.Missions.Model;

import br.dev.java10fx.CadastroDeNninjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

// Uma anotacao para em um fim de um bloco (@Entity) ou fim de uma linha de codigo (@Id)

@Entity
@Table(name = "tb_missions")
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer dificulty;

    @OneToMany (mappedBy = "missoes") // Uma missao tem mais de um ninja. mappedBy - conectar por Chave Estrangeira o relacionamento entre as entidades
    private List<NinjaModel> ninjas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDificulty() {
        return dificulty;
    }

    public void setDificulty(Integer dificulty) {
        this.dificulty = dificulty;
    }

    public MissionModel() {
    }

    public MissionModel(Long id, String name, Integer dificulty) {
        this.id = id;
        this.name = name;
        this.dificulty = dificulty;
    }
}
