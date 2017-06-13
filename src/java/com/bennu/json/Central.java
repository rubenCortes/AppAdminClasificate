/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bennu.json;

import com.bennu.entidad.Categoria;
import com.bennu.entidad.EstadoRegion;
import com.bennu.entidad.Pais;
import com.bennu.entidad.Poblacion;
import com.bennu.entidad.SubCategoria;
import java.util.ArrayList;
import java.util.List;
import com.bennu.json.Derivado;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrador
 */
@XmlRootElement
public class Central {
    private long id;
    private String nombre;
    private Derivado padre;
    private List<Derivado> listaHijo = new ArrayList<>();



    public Central() {
    }

    
    public Central(long id, String nombre ) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        public Derivado getPadre() {
        return padre;
    }

    public void setPadre(Derivado padre) {
        this.padre = padre;
    }
    
    public void setListaHijo(List<Derivado> listaHijo) {
        this.listaHijo = listaHijo;
    }

    public List<Derivado> getListaHijo() {
        return listaHijo;
    }

    
    public <T> void asignaDatos( T objeto ){
        
        if  (objeto instanceof Pais){
            
            Pais pais = (Pais) objeto;    
            
            this.setId(pais.getIdPais());
            this.setNombre(pais.getNombre());
           
            for ( EstadoRegion miEstado : pais.getEstadoRegionList() ){
                this.getListaHijo().add(new Derivado(miEstado.getIdEstadoRegion(), miEstado.getNombre() ) ); 
            }
   
        } else if (objeto instanceof EstadoRegion){
            
            EstadoRegion estado = (EstadoRegion) objeto;
            
            this.setId(estado.getIdEstadoRegion());
            this.setNombre(estado.getNombre());
            this.setPadre(new Derivado(estado.getPais().getIdPais(), estado.getPais().getNombre()));
            
            for ( Poblacion poblacion : estado.getPoblacionList() ){
                this.getListaHijo().add(new Derivado(poblacion.getIdPoblacion(), poblacion.getNombre()));
            }
            
        } else if (objeto instanceof Poblacion) {
            
            Poblacion poblacion = (Poblacion) objeto;
            
            this.setId(poblacion.getIdPoblacion());
            this.setNombre(poblacion.getNombre());
            this.setPadre( new Derivado(poblacion.getEstadoRegion().getIdEstadoRegion(), poblacion.getEstadoRegion().getNombre()) );
            
        } else if (objeto instanceof Categoria) {
            
            Categoria categoria = (Categoria) objeto;    
            
            this.setId(categoria.getIdCategoria());
            this.setNombre(categoria.getNombre());
           
            for ( SubCategoria subCategoria : categoria.getSubCategoriaList() ){
                this.getListaHijo().add(new Derivado(subCategoria.getIdSubCategoria(), subCategoria.getNombre()) ); 
            }
        } else if (objeto instanceof SubCategoria){
            
            SubCategoria subCategoria = (SubCategoria) objeto;
            
            this.setId(subCategoria.getIdSubCategoria());
            this.setNombre(subCategoria.getNombre());
            this.setPadre( new Derivado(subCategoria.getCategoria().getIdCategoria(), subCategoria.getCategoria().getNombre()) );
            
        }
    }
    
    
    
}
