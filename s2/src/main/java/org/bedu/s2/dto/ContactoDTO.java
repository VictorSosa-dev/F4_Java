package org.bedu.s2.dto;

public class ContactoDTO {

    private String nombre;
    private String telefono;

    public ContactoDTO() {
    }

    public ContactoDTO(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
