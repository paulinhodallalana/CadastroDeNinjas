package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes")
public class missoesController {

    private final MissoesService missoesService;

    public missoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // ================================
    // 🔹 LISTAR TODAS (API)
    // ================================
    @GetMapping
    @ResponseBody
    public List<MissoesModel> listarTodas() {
        return missoesService.listarTodas();
    }

    // ================================
    // 🔹 LISTAR POR ID (API)
    // ================================
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<MissoesModel> listarPorId(@PathVariable Long id) {
        MissoesModel missao = missoesService.listarMissoesPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.notFound().build();
    }

    // ================================
    // 🔹 CRIAR MISSÃO (API)
    // ================================
    @PostMapping
    @ResponseBody
    public MissoesModel criarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissoes(missao);
    }

    // ================================
    // 🔹 DELETAR MISSÃO (API)
    // ================================
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.deletarMissaoPorId(id)) {
            return ResponseEntity.ok("Missão deletada com sucesso");
        }
        return ResponseEntity.notFound().build();
    }

    // ================================
    // 🔹 LISTAR MISSÕES (TELA UI)
    // ================================
    @GetMapping("/listar/UI")
    public String listarMissoesUI(Model model) {
        model.addAttribute("missoes", missoesService.listarTodas());
        return "listarMissoes";
    }

    // ================================
    // 🔹 FORMULÁRIO CRIAR MISSÃO (UI)
    // ================================
    @GetMapping("/criar/UI")
    public String criarMissaoUI(Model model) {
        model.addAttribute("missao", new MissoesModel());
        return "criarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(MissoesModel missao) {
        missoesService.criarMissoes(missao);
        return "redirect:/missoes/listar/UI";
    }
}