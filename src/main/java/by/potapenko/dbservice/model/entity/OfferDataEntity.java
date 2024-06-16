package by.potapenko.dbservice.model.entity;


import by.potapenko.dbservice.enam.OfferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "selection_offers")
public class OfferDataEntity {
    @Id
    private UUID clientId;

    @Indexed(expireAfterSeconds = 1800)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

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
    private List<RefinancingCreditEntity> refinancingCredits;
}
