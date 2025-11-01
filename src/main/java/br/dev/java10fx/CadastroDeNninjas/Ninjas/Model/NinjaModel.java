package br.dev.java10fx.CadastroDeNninjas.Ninjas.Model;

import br.dev.java10fx.CadastroDeNninjas.Missions.Model.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Uma anotacao para em um fim de um bloco (@Entity) ou fim de uma linha de codigo (@Id)

// JPA = Java Persistence API, puxamos todas as funcionalidades de interação com a DB a partir do Jakarta
@Entity // Transforma uma classe em uma entidade no DB.
@Table(name = "tb_cadastro") // Criando a tabela na base de dados
@Data // Criar Getter e Setters ao mesmo tempo dos atributos
@NoArgsConstructor // Cria o construtor com argumento vazio
@AllArgsConstructor // Cria o construtor com todos atributos como argumento
public class NinjaModel {

    @Id // Precisamos configurar a sequencia pra o ID (PK) para o atributo abaixo
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Definindo como vai ser esse incremento sequencial para cada registro inserido.
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true) // Dados sensiveis e únicos.
    private String email;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "age")
    private int age;

    @ManyToOne // Um Ninja tem uma unica missao
    @JoinColumn(name = "missions_id") // Juntar as colunas das duas tabelas - (missoes_id : FK)
    private MissionsModel missions;
}
