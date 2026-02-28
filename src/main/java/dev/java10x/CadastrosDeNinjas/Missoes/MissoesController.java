package dev.java10x.CadastrosDeNinjas.Missoes;


import jakarta.persistence.ManyToOne;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesModel missao) {
        MissoesModel novaMissao = missoesService.criarMissoes(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());


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

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        boolean deletado = missoesService.deletarMissaoPorId(id);
        if (deletado) {
            return ResponseEntity.ok("Missão com ID: " + id + " deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com ID: " + id + " não encontrada");
    }
    }





