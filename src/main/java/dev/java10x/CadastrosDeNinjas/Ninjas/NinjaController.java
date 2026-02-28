package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> BoasVindas() {
      return ResponseEntity.ok("Boas Vindaas");

  }


  // CRUDE

   //ADICIONAR NINJA (CREAT) @requestbody
   @PostMapping ("/criar")
    public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
     return ResponseEntity.status(HttpStatus.CREATED)
             .body("Ninja criado com sucesso " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    };


    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
           return ResponseEntity.ok(ninjaDTOList);
    }

    //MOSTRAR POR ID
    //? é o generic que pode ser passado qualquer coisa STRIG INT ETC
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {

      NinjaDTO ninjaPorId = ninjaService.listarNinjaId(id);

      if(ninjaPorId != null){

          return ResponseEntity.ok(ninjaPorId);
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("ID: " + id + ",Não encontrado");
      }

    }

    //ALTERAR POR ID(UPDATE) PACH
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjasPorId(
            @PathVariable Long id,
            @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);


        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não encontrado");
        }
    }

    //DELETAR NINJA(REMOVE) Nao esquece q delete é um metodoo void
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjaId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok(
                    "Ninja com ID: " + id + " deletado com sucesso"
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não encontrado");
        }
    }



}
