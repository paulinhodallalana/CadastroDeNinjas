package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepositiry missoesRepositiry;


    public MissoesService(MissoesRepositiry missoesRepositiry) {
        this.missoesRepositiry = missoesRepositiry;
    }


    //Listar TODAS  missoes
    public List<MissoesModel> listarmissoes(){
        return  missoesRepositiry.findAll();
    }

    //CRIAR MISSAO
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return  missoesRepositiry.save(missoes);

    }

    //Listar por ID
    // O findById retorna um Optional, que pode ou não conter um objeto
    // O orElse(null) diz: "Se existir, retorna o objeto, se não existir, retorna null"
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepositiry.findById(id);
        return missoesModel.orElse(null); //
    };

}


