package by.potapenko.dbservice.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefinancingCreditDTO {
    private Long orderNum;
    private BigDecimal amount;
}
