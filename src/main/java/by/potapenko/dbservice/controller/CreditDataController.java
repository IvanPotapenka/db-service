package by.potapenko.dbservice.controller;

import by.potapenko.dbservice.model.Dto.OfferDataDTO;
import by.potapenko.dbservice.service.CreditDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static by.potapenko.dbservice.util.UrlPathUtil.API;
import static by.potapenko.dbservice.util.UrlPathUtil.APPLY;
import static by.potapenko.dbservice.util.UrlPathUtil.DB_SERVICE;
import static by.potapenko.dbservice.util.UrlPathUtil.GET_DATA;

@Slf4j
@RestController
@RequestMapping(API + DB_SERVICE)
@RequiredArgsConstructor
@Tag(name = "Credit data controller", description = "Содержит эндпойнты для полчения и сохранения данных с заявками на кредит от клиентов")
public class CreditDataController {

    private final CreditDataService creditDataService;

    @Operation(summary = "Добавить заявку клиента в БД",
            description = "Позволяет добавить данные клиента по кредиту в БД")
    @PostMapping(APPLY)
    public ResponseEntity<UUID> saveData(
            @Parameter(description = "Описание данных предложений по кредиту клиента")
            @RequestBody OfferDataDTO data) {
        log.info("Создание новой заявки: {}", data.getOfferId());
        return ResponseEntity.ok(creditDataService.saveData(data));
    }

    @Operation(summary = "Получит данные предложения по кредиту клиента",
            description = "Позволяет получить данные предложения  по кредиту клиента")
    @GetMapping(GET_DATA)
    public OfferDataDTO getData(@RequestHeader("Client-Id") UUID clientId) {
        log.info("Получение заявки клиента по id: {}", clientId);
        return creditDataService.getData(clientId);
    }
}
