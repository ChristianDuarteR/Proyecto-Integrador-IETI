package com.escuelaing.edu.co.proyectoIntegrador.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/v1/health")
    public String checkAPI(){
        return "<h1>The API is working ok!</h1>";
    }
}
