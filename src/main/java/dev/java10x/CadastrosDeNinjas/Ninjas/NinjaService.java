package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private  NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //LISTAR NINJAS
    public  List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //LISTAR POR ID
    public NinjaModel listarNinjaId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }


    //CRIAR UM NOVO NINJA(SAVE)
    public NinjaModel criarNinja(NinjaModel ninja ) {
       return ninjaRepository.save(ninja);
    }


    //DELETAR NINJA ***TEM QUE SEER UM METODO VOID
    public  void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    //ATUALIZAR NINJAS
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
