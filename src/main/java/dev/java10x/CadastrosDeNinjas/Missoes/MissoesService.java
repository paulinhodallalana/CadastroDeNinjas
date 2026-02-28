package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;


    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }


    //Listar TODAS  missoes
    public List<MissoesModel> listarmissoes(){
        return  missoesRepository.findAll();
    }

    //CRIAR MISSAO
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return  missoesRepository.save(missoes);

    }

    //Listar por ID
    // O findById retorna um Optional, que pode ou não conter um objeto
    // O orElse(null) diz: "Se existir, retorna o objeto, se não existir, retorna null"
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null); //
    };

    public boolean deletarMissaoPorId(Long id) {
        if (missoesRepository.existsById(id)) {
            missoesRepository.deleteById(id);
            return true;
        }
        return false;
    }

}


