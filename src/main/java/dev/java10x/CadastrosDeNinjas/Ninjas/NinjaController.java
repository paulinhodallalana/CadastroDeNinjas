package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")


public class NinjaController {

    @GetMapping("/boasVindas")

  public String BoasVindas() {
      return"Essa é minha primeira mensagem nessa rota";
  }

}
