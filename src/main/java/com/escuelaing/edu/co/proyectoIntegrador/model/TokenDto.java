package com.escuelaing.edu.co.proyectoIntegrador.model;

import java.util.Date;

public record TokenDto (

    String token,

    Date expirationDate) {

}

