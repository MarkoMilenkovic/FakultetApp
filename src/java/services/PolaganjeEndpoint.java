/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domen.Polaganje;
import domen.PolaganjePK;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import poslovnalogika.Kontroler;

/**
 *
 * @author Milenkovic
 */
@Path("polaganja")
public class PolaganjeEndpoint {

    @Path("{indeks}/{ispit}/{rok}")
    @DELETE
    public Response obrisiPolaganje(@PathParam("indeks") String indeks, @PathParam("ispit") Integer ispit, @PathParam("rok") Integer rok) {
        Polaganje polaganje = new Polaganje(new PolaganjePK(indeks.replace("-", "/"), ispit, rok));
        Kontroler.getInstance().obrisi(polaganje);
        return Response.noContent().build();

//        return Response.ok().build(); fheihfiuehfiuegfi
    }
}
