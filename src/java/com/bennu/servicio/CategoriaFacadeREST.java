/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bennu.servicio;

import com.bennu.entidad.Categoria;
import com.bennu.entidad.SubCategoria;
import com.bennu.entidad.auxiliar.CategoriaSimple;
import com.bennu.entidad.auxiliar.SubCategoriaSimple;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author administrador
 */
@Stateless
@Path("categoria")
public class CategoriaFacadeREST extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "AppAdminClasificatePU")
    private EntityManager em;

    @EJB
    SubCategoriaFacadeREST subCategoriaREST;
    
    public CategoriaFacadeREST() {
        super(Categoria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Categoria entity) {
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Categoria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categoria find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    
    @GET
    @Path("simple")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CategoriaSimple> getCategoriaSub() {
        
        List<Categoria> categoriaLista = super.findAll();
        List<CategoriaSimple> categoriaSimpleLista = new ArrayList<>();
        
        categoriaLista.forEach(categoria -> {
            
            List<SubCategoria> subCategoriaLista = subCategoriaREST.findSubCategoriaCategoria(categoria.getIdCategoria());
            List<SubCategoriaSimple> subCategoriaSimpleLista = new ArrayList<>();    
            
            subCategoriaLista.forEach(subCategoria -> subCategoriaSimpleLista.add( new SubCategoriaSimple(subCategoria) ) );
            
            categoriaSimpleLista.add( new CategoriaSimple(categoria, subCategoriaSimpleLista) );
            
        });
        
        
        return categoriaSimpleLista;
    }

    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
