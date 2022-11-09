package com.godoro.composite.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Participant {
    @EmbeddedId
    private ParticipantId participantId;
    private String roleName;

    public ParticipantId getParticipantId() {
        return this.participantId;
    }

    public void setParticipantId(ParticipantId participantId) {
        this.participantId = participantId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Participant() {
    }

    public Participant(ParticipantId participantId, String roleName) {
        this.participantId = participantId;
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "{" +
            " participantId='" + getParticipantId() + "'" +
            ", roleName='" + getRoleName() + "'" +
            "}";
    }

}
