package main.java.dao;

import main.java.model.Client;

import javax.persistence.*;
import java.util.List;

public class ClientDao implements DAO<Client> {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("jpa_unit").createEntityManager();
        }
        return em;
    }

    @Override
    public List<Client> findAll() {
        List<Client> list = this.getEntityManager().createQuery("select p from Client p").getResultList();
        return list;
    }

    @Override
    public Client find(int id) {

        return this.getEntityManager().find(Client.class, id);
    }

    @Override
    public Client create(Client client) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(client);
        this.getEntityManager().getTransaction().commit();
        return client;
    }

    @Override
    public Client update(Client client) {
        this.getEntityManager().getTransaction().begin();
        client = this.getEntityManager().merge(client);
        this.getEntityManager().getTransaction().commit();
        return client;
    }

    @Override
    public void delete(Client client) {
        this.getEntityManager().getTransaction().begin();
        client = this.getEntityManager().merge(client);
        this.getEntityManager().remove(client);
        this.getEntityManager().getTransaction().commit();
    }
}

