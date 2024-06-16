package by.potapenko.dbservice.mapper;

import by.potapenko.dbservice.model.Dto.OfferDataDTO;
import by.potapenko.dbservice.model.entity.OfferDataEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OfferConverter {

    private final ModelMapper modelMapper;

    public OfferDataEntity convertOfferEntityFromDto(OfferDataDTO offerDataDTO) {
        return modelMapper.map(offerDataDTO, OfferDataEntity.class);
    }

    public OfferDataDTO convertOfferDataEntityToDto(OfferDataEntity offer) {
        return modelMapper.map(offer, OfferDataDTO.class);
    }
}
