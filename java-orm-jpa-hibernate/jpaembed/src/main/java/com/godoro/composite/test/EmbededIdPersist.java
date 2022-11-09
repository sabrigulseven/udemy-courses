package com.godoro.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.composite.entity.Employee;
import com.godoro.composite.entity.Participant;
import com.godoro.composite.entity.ParticipantId;
import com.godoro.composite.entity.Project;

public class EmbededIdPersist {
    public static void main(String[] args) {
        Employee employee = new Employee(0, "Çalışan 1");
        Project project = new Project(0, "İzdüşü A");

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(employee);
        entityManager.persist(project);

        entityManager.getTransaction().commit();

        ParticipantId participantId = new ParticipantId(employee.getEmployeeId(), project.getProjectId());
        Participant participant = new Participant(participantId, "Mühendis");
        entityManager.getTransaction().begin();

        entityManager.persist(participant);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
