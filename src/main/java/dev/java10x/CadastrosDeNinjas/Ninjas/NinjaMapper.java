package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    // Converte Model -> DTO
    public NinjaDTO toDTO(NinjaModel ninjaModel) {

        if (ninjaModel == null) {
            return null;
        }

        NinjaDTO dto = new NinjaDTO();

        dto.setId(ninjaModel.getId());
        dto.setNome(ninjaModel.getNome());
        dto.setEmail(ninjaModel.getEmail());
        dto.setImgUrl(ninjaModel.getImgUrl());
        dto.setRank(ninjaModel.getRank());
        dto.setIdade(ninjaModel.getIdade());
        dto.setMissao(ninjaModel.getMissao());

        return dto;
    }

    // Converte DTO -> Model
    public NinjaModel toModel(NinjaDTO dto) {

        if (dto == null) {
            return null;
        }

        NinjaModel model = new NinjaModel();

        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setImgUrl(dto.getImgUrl());
        model.setRank(dto.getRank());
        model.setIdade(dto.getIdade());
        model.setMissao(dto.getMissao());

        return model;
    }
}
