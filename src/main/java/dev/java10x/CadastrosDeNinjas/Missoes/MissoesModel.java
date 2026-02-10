package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.awt.*;


@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String nome;

    private String dificuldade;

    // uma missao para muitos ninjas
    @OneToMany(mappedBy = " missoes" )
    private List<NinjaModel> ninjas;




}
