/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bennu.entidad.auxiliar;

import com.bennu.entidad.EstadoRegion;
import com.bennu.entidad.Poblacion;

/**
 *
 * @author administrador
 */
public class UsuarioExtendido {
    
    private long idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String contrasenia;
    private Poblacion poblacion;
    private EstadoRegion estado;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    public EstadoRegion getEstado() {
        return estado;
    }

    public void setEstado(EstadoRegion estado) {
        this.estado = estado;
    }
    
    
}
