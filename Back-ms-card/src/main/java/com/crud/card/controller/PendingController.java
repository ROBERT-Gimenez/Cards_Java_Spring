package com.crud.card.controller;

import com.crud.card.repositorio.PendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PendingController {
    @Autowired
    private PendingRepo pendingService;

    @GetMapping("allPending")
    public ResponseEntity<>
}
