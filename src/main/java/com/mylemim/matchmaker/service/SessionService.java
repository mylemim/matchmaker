package com.mylemim.matchmaker.service;

import com.mylemim.matchmaker.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Provides an interface to the available participants in the matchmaking session
 * <p>
 * Created by Mario Milas on 5.2.2017.
 */
@Component
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Iterable<Session> listSessions() {
        return sessionRepository.findAll();
    }

    public Session createSession(String name) {
        Session session = new Session(name);
        return createSession(session);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }
}
