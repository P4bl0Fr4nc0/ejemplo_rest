package com.example.empleados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//Data Transfer Object, intermediario entre El servicio de empleado y el controlador

public record EmpleadoDTO(
       @JsonProperty("id") Long id,
       @JsonProperty("nombre") String nombre,
       @JsonProperty("apaterno") String apaterno,
       @JsonProperty("amaterno") String amaterno
)
{


}
