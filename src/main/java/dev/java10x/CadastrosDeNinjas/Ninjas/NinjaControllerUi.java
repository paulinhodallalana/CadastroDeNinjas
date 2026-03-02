package dev.java10x.CadastrosDeNinjas.Ninjas;


import dev.java10x.CadastrosDeNinjas.Missoes.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/ninjas")
public class NinjaControllerUi {

    private final NinjaService ninjaService;
    private final MissoesService missoesService;


    public NinjaControllerUi(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }

    @GetMapping("/listar/UI")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);

        return "listaninjas"; // tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        model.addAttribute("ninja", ninja);
        return "detalhesNinja"; // crie uma página Thymeleaf chamada detalhesNinja.html
    }



    @GetMapping("/adicionar")
    public String abrirPaginaAdicionar(Model model) {

        model.addAttribute("ninja", new NinjaDTO());

        // 🔥 ESSA LINHA FALTAVA
        model.addAttribute("missoes", missoesService.listarTodas());

        return "adicionarNinja";
    }

    // Salvar o novo ninja
    @PostMapping("/adicionar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja) {
        ninjaService.criarNinja(ninja); // você precisa ter um método salvarNinja no service
        return "redirect:/ninjas/listar/UI"; // volta para a lista
    }


    @PostMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninjaAtualizado) {
        ninjaService.atualizarNinja(id, ninjaAtualizado);
        return "redirect:/ninjas/listar/UI"; // volta para a página de listagem
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/listar/UI";
    }


    @GetMapping("/alterar/UI/{id}")
    public String alterarNinjaUI(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        model.addAttribute("ninja", ninja);

        model.addAttribute("missoes", missoesService.listarTodas());

        return "alterarNinja";
    }
}



