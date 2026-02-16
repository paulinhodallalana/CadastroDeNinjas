package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")


public class NinjaController {

    @GetMapping("/boasVindas")

  public String BoasVindas() {
      return"Essa é minha primeira mensagem nessa rota";
  }


  // CRUDE

   //ADICIONAR NINJA (CREAT)
   @PostMapping ("/criar")
    public  String criarNinja() {
      return "Ninja criado";
    };


    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Mostrar Ninjas";
    }


    //ALTERAR POR ID(UPDATE)
    @PutMapping("/todosID")
    public String alterarNinjasPorId() {
        return "Mostrar Ninjas Por Id:";
    }

    //DELETAR NINJA(REMOVE)
   @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja Deletado Por ID";
   };



}
