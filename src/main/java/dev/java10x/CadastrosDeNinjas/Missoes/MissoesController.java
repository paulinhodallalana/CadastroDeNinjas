package dev.java10x.CadastrosDeNinjas.Missoes;


import jakarta.persistence.ManyToOne;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

  

    //CRUDE - CRIAR, MOSTRAR, INSERIR,DELETAR
    // Get - mandar requisoçao para mostrar as requisisoes
    //POST - MANDAR REQUISIÇÃO PARA CRIAR AS MISSOES
    //PUT - MANRA PARA ALTERAR AS MISSOES
    //DELETE - REMOVER AS MISSOES

    //SEMPRE CHAMAR O SERVICE E FAZER O CONTRUTOR
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Criar missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissoes(missao);
    }


    //LISTAR MISSOES
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarmissoes() ;
    }

   @GetMapping("/listar/{id}")
   public MissoesModel missoesModel(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
   }


    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "missao deletada com sucesso";
    }




}
