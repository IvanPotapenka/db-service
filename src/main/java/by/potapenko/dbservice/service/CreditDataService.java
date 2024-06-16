package by.potapenko.dbservice.service;


import by.potapenko.dbservice.exception.BadRequestException;
import by.potapenko.dbservice.exception.ClientNotFoundException;
import by.potapenko.dbservice.mapper.OfferConverter;
import by.potapenko.dbservice.model.Dto.OfferDataDTO;
import by.potapenko.dbservice.model.entity.OfferDataEntity;
import by.potapenko.dbservice.repository.CreditDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditDataService {

    private final CreditDataRepository creditDataRepository;
    private final OfferConverter offerConverter;

    @Transactional
    public UUID saveData(OfferDataDTO dataDTO) throws BadRequestException{
        return creditDataRepository
                .save(offerConverter
                .convertOfferEntityFromDto(dataDTO))
                .getClientId();
    }
    @Transactional(readOnly = true)
    public OfferDataDTO getData(UUID clientId) {
        OfferDataEntity offerData = creditDataRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
        return offerConverter.convertOfferDataEntityToDto(offerData);
    }
}
