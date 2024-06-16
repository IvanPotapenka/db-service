package by.potapenko.dbservice.service;

import by.potapenko.dbservice.exception.ClientNotFoundException;
import by.potapenko.dbservice.mapper.OfferConverter;
import by.potapenko.dbservice.model.Dto.OfferDataDTO;
import by.potapenko.dbservice.repository.CreditDataRepository;
import by.potapenko.dbservice.testcontainer.BaseIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static by.potapenko.dbservice.Data.TestData.clientId;
import static by.potapenko.dbservice.Data.TestData.offerDataDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditDataServiceTest extends BaseIntegrationTest {

    @Autowired
    private CreditDataRepository creditDataRepository;

    @Autowired
    private OfferConverter offerConverter;

    @Autowired
    private CreditDataService creditDataService;

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @BeforeEach
    void init() {
        offerConverter = new OfferConverter(MODEL_MAPPER);
        creditDataService = new CreditDataService(creditDataRepository, offerConverter);
    }

    @Test
    public void givenOfferData_whenSaveAndGetOfferData_thenOK() {
       UUID id = creditDataService.saveData(offerDataDTO);
        OfferDataDTO dataDTO = creditDataService.getData(id);
        assertThat(clientId).isEqualTo(dataDTO.getClientId());
    }
    @Test
    public void whenGetOfferData_thenThrow() {
        assertThrows(ClientNotFoundException.class, () -> creditDataService.getData(clientId));
    }
}
