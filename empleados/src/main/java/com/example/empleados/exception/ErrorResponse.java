package com.example.empleados.exception;


//Respuesta del error
public class ErrorResponse {

    private String mensaje;
    private int codigo;

    public ErrorResponse(String mensaje, int codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getCodigo() {
        return codigo;
    }
}
