package dev.java10x.CadastrosDeNinjas.Ninjas;


import dev.java10x.CadastrosDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NinjaService {


    private  NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO ) {
        NinjaModel ninjaModel = ninjaMapper.toModel(ninjaDTO);

        NinjaModel salvo = ninjaRepository.save(ninjaModel);

        return ninjaMapper.toDTO(salvo);
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
