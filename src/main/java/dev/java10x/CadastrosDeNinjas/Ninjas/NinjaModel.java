package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
//transforma uma classe em uma entidade(Classe que representa algo do mundo real)
@Entity
@Table(name = "tb_cadastro")// tudo minusculo boa pratica e o tb no inicio
//lommbok
@NoArgsConstructor // contrutor vazio
@AllArgsConstructor // contrutor com parametro
@Data //cria os geters e seters

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Column(unique = true) // obrigatrio o campo do email
    private String email;
    private int idade;
    // muitos ninjas para MESMA missa@ManyToOne
    @JoinColumn(name = "missoes_id") //chave estrangeira
    private MissoesModel missoes;
}

