package by.potapenko.dbservice.exception;

import by.potapenko.dbservice.exception.response.ApiErrorResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ClientNotFoundException extends RuntimeException {
   ApiErrorResponse apiErrorResponse;
}
