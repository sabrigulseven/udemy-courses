package com.godoro.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.composite.entity.Participant;
import com.godoro.composite.entity.ParticipantId;

public class EmbededIdFind {
    public static void main(String[] args) {
        long employeeId = 3;
        long projectId = 2;
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        ParticipantId participantId = new ParticipantId(employeeId, projectId);
        Participant participant = entityManager.find(Participant.class, participantId);

        entityManager.close();
        System.out.println(participant.toString());
    }
}
