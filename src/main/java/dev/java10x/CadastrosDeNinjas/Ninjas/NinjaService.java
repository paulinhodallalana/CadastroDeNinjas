package dev.java10x.CadastrosDeNinjas.Ninjas;


import dev.java10x.CadastrosDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NinjaService {


    private  NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //LISTAR NINJAS
    public  List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDTO)
                .collect(Collectors.toList());
    }

    //LISTAR POR ID
    public  NinjaDTO listarNinjaId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::toDTO)
                .orElse(null);
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
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.toModel(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.toDTO(ninjaSalvo);


        }
        return  null;
    }

}
