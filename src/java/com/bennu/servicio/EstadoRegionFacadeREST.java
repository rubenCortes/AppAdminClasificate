/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bennu.servicio;

import com.bennu.entidad.EstadoRegion;
import com.bennu.entidad.Pais;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("estadoregion")
public class EstadoRegionFacadeREST extends AbstractFacade<EstadoRegion> {

    @EJB
    private PaisFacadeREST paisREST;

    @PersistenceContext(unitName = "AppAdminClasificatePU")
    private EntityManager em;

    public EstadoRegionFacadeREST() {
        super(EstadoRegion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EstadoRegion entity) {
        //System.out.println(entity);
        super.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(EstadoRegion entity) {
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
    public EstadoRegion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EstadoRegion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EstadoRegion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("pais/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EstadoRegion> findEstadoPais(@PathParam("id") Integer id){
        
        /*
        Pais pais = this.paisREST.find(id);
        
        List<EstadoRegion> lista = pais.getEstadoRegionList();
        
        System.out.println("Número de estados: " + lista.size());
        */
        
        
        TypedQuery<EstadoRegion> consultaEstadosPorPais= em.createNamedQuery("EstadoRegion.findByPais", EstadoRegion.class);
        consultaEstadosPorPais.setParameter("idPais", id);
        List<EstadoRegion> lista= consultaEstadosPorPais.getResultList();
        
        
        return lista;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
