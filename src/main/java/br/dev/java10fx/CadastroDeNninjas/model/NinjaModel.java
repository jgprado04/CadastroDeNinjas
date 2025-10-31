package br.dev.java10fx.CadastroDeNninjas.model;

import jakarta.persistence.*;

// JPA = Java Persistence API, puxamos todas as funcionalidades de interação com a DB a partir do Jakarta
@Entity // Transforma uma classe em uma entidade no DB.
@Table(name = "tb_cadastro") // Criando a tabela na base de dados
public class NinjaModel {

    @Id // Precisamos configurar a sequencia pra o ID (PK) para o atributo abaixo
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Definindo como vai ser esse incremento sequencial para cada registro inserido.
    private Long id;
    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
