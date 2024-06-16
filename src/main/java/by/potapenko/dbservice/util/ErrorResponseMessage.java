package by.potapenko.dbservice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorResponseMessage {
    public static final String CLIENT_NOT_FOUND = "Клиент не найден c таким id = ";
    public static final String CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA = "Проверьте правильность введенных данных";
    public static final String CHECK_YOUR_INTERNET_CONNECTION_OR_SERVER = "Проверьте соединение с интернетом или сервером";
}
