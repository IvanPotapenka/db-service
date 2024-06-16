package by.potapenko.dbservice.exception.handler;

import by.potapenko.dbservice.exception.BadRequestException;
import by.potapenko.dbservice.exception.ClientNotFoundException;
import by.potapenko.dbservice.exception.response.ApiErrorResponse;
import com.mongodb.MongoException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static by.potapenko.dbservice.builder.ApiResponseBuilder.responseBuild;
import static by.potapenko.dbservice.util.ErrorResponseMessage.CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA;
import static by.potapenko.dbservice.util.ErrorResponseMessage.CHECK_YOUR_INTERNET_CONNECTION_OR_SERVER;
import static by.potapenko.dbservice.util.ErrorResponseMessage.CLIENT_NOT_FOUND;

public class ErrorHandler {

    @ExceptionHandler(MongoException.class)
    public ResponseEntity<ApiErrorResponse> handleMongoException(MongoException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseBuild(String.valueOf(ex.getCode()), CHECK_YOUR_INTERNET_CONNECTION_OR_SERVER, ex.getMessage()));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiErrorResponse> handleDataAccessException(DataAccessException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseBuild(HttpStatus.BAD_REQUEST.name(), CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA, ex.getMessage()));
    }
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> offerBadRequestException(ClientNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseBuild(HttpStatus.NOT_FOUND.name() , CLIENT_NOT_FOUND, e.getMessage()));
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> offerBadRequestException(BadRequestException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseBuild(HttpStatus.BAD_REQUEST.name() ,CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA, e.getMessage() ));
    }
}
