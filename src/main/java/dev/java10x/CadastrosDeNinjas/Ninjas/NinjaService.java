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
    public NinjaModel listarNinjaId(long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }


}
