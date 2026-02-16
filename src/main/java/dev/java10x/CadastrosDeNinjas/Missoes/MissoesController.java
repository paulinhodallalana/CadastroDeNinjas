package dev.java10x.CadastrosDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    //CRUDE - CRIAR, MOSTRAR, INSERIR,DELETAR
    // Get - mandar requisoçao para mostrar as requisisoes
    //POST - MANDAR REQUISIÇÃO PARA CRIAR AS MISSOES
    //PUT - MANRA PARA ALTERAR AS MISSOES
    //DELETE - REMOVER AS MISSOES


    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao Criada com suceso";
    }

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Todas as missoes";
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
