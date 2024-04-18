package fr.eni.encheres2.mapping;


import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.entity.Retrait;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RetraitMapper extends CustomModelMapper implements Mapper<Retrait, RetraitDTO>{
    public RetraitMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Retrait mapToEntity(RetraitDTO dto) {
        return modelMapper.map(dto, Retrait.class);
    }

    @Override
    public RetraitDTO mapToDto(Retrait entity) {
        return modelMapper.map(entity, RetraitDTO.class);
    }
}
