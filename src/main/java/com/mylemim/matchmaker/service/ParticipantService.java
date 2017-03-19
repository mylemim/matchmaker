package com.mylemim.matchmaker.service;

import com.mylemim.matchmaker.domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Provides an interface to all the available participants
 * <p>
 * Created by Mile on 7.3.2017.
 */
@Component
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant createParticipant(String name) {
        Participant participant = new Participant(name);
        return participantRepository.save(participant);
    }
}
