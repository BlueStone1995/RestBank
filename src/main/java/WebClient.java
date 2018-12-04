package main.java;

import main.java.model.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/clients")
public class WebClient {
    private ListeClient listeClient;

    public WebClient() {
        this.listeClient = new ListeClient();
    }

    /**
     * GET = READ
     * POST = CREATE
     * PUT = UPDATE
     * DELETE = REMOVE
     */

    @Path("/add")
    @POST()
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.APPLICATION_XML)
    public Client addClient(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
        return this.listeClient.ajouterClientdansListe(nom, prenom);
    }

    @Path("/update/{id}")
    @PUT()
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
    @Produces(MediaType.APPLICATION_XML)
    public Client updateClient(@PathParam("id") int id, @FormParam("nom") String nom, @FormParam("prenom") String prenom) {
        return this.listeClient.modifierClient(id, nom, prenom);
    }

    @Path("/{id}")
    @GET()
    @Produces(MediaType.APPLICATION_XML)
    public Client getClient(@PathParam("id") int id) {

        return this.listeClient.consulterClient(id);
    }

    @Path("/all")
    @GET()
    @Produces(MediaType.APPLICATION_XML)
    public List<Client> getClients() {

        return this.listeClient.consulterListeClient();
    }

    @Path("/remove/{id}")
    @DELETE()
    @Produces(MediaType.APPLICATION_XML)
    public Client removeClient(@PathParam("id") int id) {

        return this.listeClient.supprimerClient(id);
    }
}
