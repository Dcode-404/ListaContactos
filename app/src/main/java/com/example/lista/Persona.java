package com.example.lista;

public class Persona {
    private String nombre;
    private String profesion;
    private String correo;
    private String numero;
    private String pais;
    private int imagen;

    public Persona(String nombre, String profesion, String correo, String numero, String pais, int imagen) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.correo = correo;
        this.numero = numero;
        this.pais = pais;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}