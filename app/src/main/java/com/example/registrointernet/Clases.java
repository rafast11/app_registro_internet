package com.example.registrointernet;

public class Clases {
    String Id, Nombre, Calle, Numero, Colonia, Municipio, Estado, Compania, Velocidad, Hora, Fecha,Numero_de_dispositivos, Tipos_de_dispositivos;

    public Clases(String id, String nombre, String calle, String numero, String colonia, String municipio, String estado, String compania, String velocidad, String hora, String fecha, String numero_de_dispositivos, String tipos_de_dispositivos) {
        Id = id;
        Nombre = nombre;
        Calle = calle;
        Numero = numero;
        Colonia = colonia;
        Municipio = municipio;
        Estado = estado;
        Compania = compania;
        Velocidad = velocidad;
        Hora = hora;
        Fecha = fecha;
        Numero_de_dispositivos = numero_de_dispositivos;
        Tipos_de_dispositivos = tipos_de_dispositivos;
    }

    public String getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCalle() {
        return Calle;
    }

    public String getNumero() {
        return Numero;
    }

    public String getColonia() {
        return Colonia;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCompania() {
        return Compania;
    }

    public String getVelocidad() {
        return Velocidad;
    }

    public String getHora() {
        return Hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getNumero_de_dispositivos() {
        return Numero_de_dispositivos;
    }

    public String getTipos_de_dispositivos() {
        return Tipos_de_dispositivos;
    }
}
