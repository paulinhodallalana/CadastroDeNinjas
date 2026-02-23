package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")


public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String BoasVindas() {
      return"Essa é minha primeira mensagem nessa rota";
  }


  // CRUDE

   //ADICIONAR NINJA (CREAT) @requestbody
   @PostMapping ("/criar")
    public  NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
      return ninjaService.criarNinja(ninja);
    };


    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas() ;
    }

    //MOSTRAR POR ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id) {
        return  ninjaService.listarNinjaId(id);

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
