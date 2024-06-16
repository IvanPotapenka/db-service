package by.potapenko.dbservice.model.Dto;


import by.potapenko.dbservice.enam.OfferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDataDTO {

    private UUID clientId;
    private UUID offerId;
    private OfferType offerType;
    private Boolean verificationRequired;
    private String proofIncomeRequired;
    private Boolean identityDocumentsRequired;
    private String productSubTypeCode;
    private Integer term;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal amountOverLimit;
    private BigDecimal insurancePremium;
    private BigDecimal commissionAmount;
    private BigDecimal discountRate;
    private BigDecimal refinancingAmount;
    private List<RefinancingCreditDTO> refinancingCredits;
}
