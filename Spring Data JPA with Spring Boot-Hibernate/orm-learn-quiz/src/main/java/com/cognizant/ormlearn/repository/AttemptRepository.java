package com.cognizant.ormlearn.repository;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Attempt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AttemptRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Attempt getAttempt(int userId, int attemptId) {

        String hql = """
                select distinct a
                from Attempt a
                join fetch a.user u
                join fetch a.attemptQuestions aq
                join fetch aq.question q
                join fetch q.options
                where u.userId = :userId
                and a.attemptId = :attemptId
                """;

        return entityManager.createQuery(hql, Attempt.class)
                .setParameter("userId", userId)
                .setParameter("attemptId", attemptId)
                .getSingleResult();
    }
}