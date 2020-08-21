package com.anderscore.quarkus.repository;

import com.anderscore.quarkus.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TaskRepository {

    @Inject
    EntityManager em;

    public Task findById(Long id) {
        return em.find(Task.class, id);
    }

    public List<Task> findAll() {
        return em.createQuery("select t from Task t", Task.class).getResultList();
    }

    public void update(Task entity) {
        em.merge(entity);
    }

    public void store(Task entity) {
        em.persist(entity);
    }

    public void delete(Task entity) {
        em.remove(entity);
    }
}