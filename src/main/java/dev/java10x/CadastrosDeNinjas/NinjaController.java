package dev.java10x.CadastrosDeNinjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping


public class NinjaController {

    @GetMapping("/boasVindas")

  public String BoasVindas() {
      return"Essa é minha primeira mensagem nessa rota";
  }

}
