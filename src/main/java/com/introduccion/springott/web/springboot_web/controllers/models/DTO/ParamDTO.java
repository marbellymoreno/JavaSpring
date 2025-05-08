package com.introduccion.springott.web.springboot_web.controllers.models.DTO;

public class ParamDTO {
private String mensaje;
private String direccion;
private int edad;


public ParamDTO() {
    // Constructor por defecto
}
public ParamDTO(String mensaje) {
    this.mensaje = mensaje;
}

public ParamDTO(String mensaje, String direccion) {
    this.mensaje = mensaje;
    this.direccion = direccion;
}
public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
}
public String getDireccion() {
    return direccion;
}
public void setDireccion(String direccion) {
    this.direccion = direccion;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public ParamDTO(String mensaje, String direccion, int edad) {
    this.mensaje = mensaje;
    this.direccion = direccion;
    this.edad = edad;
}

}