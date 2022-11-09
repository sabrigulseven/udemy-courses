package com.godoro.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.composite.entity.Director;
import com.godoro.composite.entity.DirectorId;
import com.godoro.composite.entity.Participant;
import com.godoro.composite.entity.ParticipantId;
import com.godoro.composite.entity.Task;

public class JoinColumnsTest {
    public static void main(String[] args) {

        long employeeId = 3;
        long projectId = 2;

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        ParticipantId participantId = new ParticipantId(employeeId, projectId);
        Participant participant = entityManager.find(Participant.class, participantId);

        DirectorId directorId = new DirectorId(employeeId, projectId);
        Director director = entityManager.find(Director.class, directorId);

        Task task = new Task(0, "O isi bitir", participant, director);
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
