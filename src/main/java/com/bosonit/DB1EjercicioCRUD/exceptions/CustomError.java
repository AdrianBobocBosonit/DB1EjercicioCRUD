package com.bosonit.DB1EjercicioCRUD.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CustomError {
    String mensaje;
    int httpCode;
    Date timeStamp;

    public CustomError(String mensaje, int httpCode) {
        setMensaje(mensaje);
        setHttpCode(httpCode);
        setTimeStamp(new Date());
    }
}
