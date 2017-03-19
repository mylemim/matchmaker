package com.mylemim.matchmaker.web;

import com.mylemim.matchmaker.domain.Participant;
import com.mylemim.matchmaker.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @RequestMapping(value = "/participants", method = RequestMethod.POST)
    @ResponseBody
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantService.createParticipant(participant.getName());
    }

}