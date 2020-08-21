package com.anderscore.spring.repository;

import com.anderscore.spring.entity.Task;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TaskRepository {

    @PersistenceContext
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