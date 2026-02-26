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
    public  NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
      return ninjaService.criarNinja(ninja);
    };


    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas() ;
    }

    //MOSTRAR POR ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
        return  ninjaService.listarNinjaId(id);

    }

    //ALTERAR POR ID(UPDATE) PACH
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //DELETAR NINJA(REMOVE) Nao esquece q delete é um metodoo void
   @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable  Long id) {
        ninjaService.deletarNinjaPorId(id);
   };



}
