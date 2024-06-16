package by.potapenko.dbservice.exception;

import by.potapenko.dbservice.exception.response.ApiErrorResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {
     ApiErrorResponse apiErrorResponse;

}
