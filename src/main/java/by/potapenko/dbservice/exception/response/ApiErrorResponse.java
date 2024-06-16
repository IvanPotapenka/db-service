package by.potapenko.dbservice.exception.response;

import lombok.Builder;

@Builder
public record ApiErrorResponse(String errorCode, String message, String description) {
}
