package com.shelterapp.backend.controllers;

import com.shelterapp.backend.models.Session;
import com.shelterapp.backend.service.SessionService;
import com.shelterapp.backend.dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity createSession(@RequestBody SessionDto sessionDTO) {
        return sessionService.saveSessionData(sessionDTO);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<Session>> getSessionsByAnimal(@PathVariable Long id) {
//        List<Session> allAnimalSessions = sessionService.findByAnimalId(id);
//        return ResponseEntity.ok(allAnimalSessions.get(0));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Session>> getSessions(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.findByAnimalId(id));
    }

    @GetMapping
    public List<Session> getAll() {
        return sessionService.findAll();
    }
}