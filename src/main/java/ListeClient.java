package main.java;

import main.java.dao.ClientDao;
import main.java.dao.DAO;
import main.java.model.Client;

import java.util.List;

public class ListeClient {
    private DAO<Client> clientDao;
    private List<Client> clientListe;

    ListeClient() {
        this.clientDao = new ClientDao();
    }

    public List<Client> consulterListeClient() {
        if (this.clientListe == null) {
            this.clientListe = clientDao.findAll();
        }
        return this.clientListe;
    }

    public Client ajouterClientdansListe(String nom, String prenom) {
        Client client = new Client(nom, prenom);
        return this.clientDao.create(client);
    }

    public Client modifierClient(int id, String nom, String prenom) {
        Client client = this.consulterClient(id);
        client.setNom(nom);
        client.setPrenom(prenom);
        return this.clientDao.update(client);
    }

    public Client consulterClient(int num) {
        return this.clientDao.find(num);
    }


    public Client supprimerClient(int num) {
        Client client = this.clientDao.find(num);

        this.clientDao.delete(client);
        return client;
    }
}
