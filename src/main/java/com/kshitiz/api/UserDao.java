package com.kshitiz.api;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserDao {
    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public UserDao() {
    }

    public void save(User u) {
        em.persist(u);
    }

    public void saveList(List<User> users) {
        for (User u :
            users) {
            em.persist(u);
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public User getById(int id) {
        return em.find(User.class, id);
    }

    public void edit(User u) {
        em.merge(u);
    }

    public List<User> getByIdRange(int startId, int endId) {
        return em.createNamedQuery("User.getByIdRange", User.class)
            .setParameter("startId", startId)
            .setParameter("endId", endId)
            .getResultList();
    }
}
