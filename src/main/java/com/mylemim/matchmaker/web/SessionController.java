package com.mylemim.matchmaker.web;

import com.mylemim.matchmaker.domain.Session;
import com.mylemim.matchmaker.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Session> listSessions() {
        return sessionService.listSessions();
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    @ResponseBody
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session.getName());
    }

}