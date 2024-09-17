package com.escuelaing.edu.co.proyectoIntegrador.exceptions;

import static com.escuelaing.edu.co.proyectoIntegrador.utils.Constants.TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE;

public class TokenExpiredException extends ServerErrorException {

    public TokenExpiredException() {
        super(TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE);
    }

}
