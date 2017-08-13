/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bennu.entidad.auxiliar;

import com.bennu.entidad.SubCategoria;

/**
 *
 * @author administrador
 */
public class SubCategoriaSimple {
    
    private long idSubCategoria;

    private String nombre;

    public SubCategoriaSimple() {
    }

    public SubCategoriaSimple(SubCategoria subCategoria) {
        this.setSubCategoria(subCategoria);
    }

    public SubCategoriaSimple(long idSubCategoria, String nombre) {
        this.idSubCategoria = idSubCategoria;
        this.nombre = nombre;
    }

    
    /**
     * Get the value of idSubCategoria
     *
     * @return the value of idSubCategoria
     */
    public long getIdSubCategoria() {
        return idSubCategoria;
    }

    /**
     * Set the value of idSubCategoria
     *
     * @param idSubCategoria new value of idSubCategoria
     */
    public void setIdSubCategoria(long idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSubCategoria(SubCategoria subCategoria){
        this.setIdSubCategoria(subCategoria.getIdSubCategoria());
        this.setNombre(subCategoria.getNombre());
    }
    
}
