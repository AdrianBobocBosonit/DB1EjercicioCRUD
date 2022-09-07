package com.bosonit.DB1EjercicioCRUD.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UnprocessableEntityException extends RuntimeException {
    int httpCode;
    Date timeStamp;

    public UnprocessableEntityException(String mensaje, int httpCode) {
        super(mensaje);
        setTimeStamp(new Date());
        setHttpCode(httpCode);
    }
}
