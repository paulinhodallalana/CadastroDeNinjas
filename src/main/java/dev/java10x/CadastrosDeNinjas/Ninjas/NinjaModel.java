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

    @Column(name = "id")
    private long id;

    @Column(name = "nome") //@collumn nome serve para nomear o nome da nossa coluna
    private String nome;

    @Column(unique = true) // serrve para criar a obrigatroriedade do preenchimento do campo do email
    private String email;


    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;




    // muitos ninjas para MESMA missa@ManyToOne
    @JoinColumn(name = "missoes_id") //chave estrangeira
    private MissoesModel missoes;
}

