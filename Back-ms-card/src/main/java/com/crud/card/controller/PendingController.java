package com.crud.card.controller;

import com.crud.card.modelo.ModelService;
import com.crud.card.modelo.Pendientes;
import com.crud.card.modelo.UserModel;
import com.crud.card.repositorio.PendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PendingController {
    @Autowired
    private PendingRepo pendingService;

    @GetMapping("/allPending")
    public ResponseEntity<List<Pendientes>> allPending(){
        var result = pendingService.allPending();
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @GetMapping("/allApproved")
    public ResponseEntity<List<Pendientes>> allApproved(){
        var result = pendingService.allApproved();
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("/addedPending")
    public ResponseEntity<ModelService> addedPending(@RequestBody Pendientes file) {
        ModelService messageResp = new ModelService();
        pendingService.save(file);
        messageResp.setSuccess(true);
        messageResp.setMessage("File saved with success");
        return ResponseEntity.ok(messageResp);
    }
    @PutMapping("/updatePending")
    public ResponseEntity<ModelService> updatePending(@RequestBody Pendientes file){
        ModelService messageResp = new ModelService();
        int result = pendingService.update(file);
        if(result == 1){
            messageResp.setSuccess(true);
            messageResp.setMessage("File Update with success");
        }
        return new ResponseEntity<>(messageResp,HttpStatus.OK);
    }
    @PutMapping("/AcceptPending/{id}")
    public ResponseEntity<ModelService> approveFile(@PathVariable int id){
        ModelService messageResp = new ModelService();
        int result = pendingService.approveFile(id);
        if(result==1){
            messageResp.setSuccess(true);
            messageResp.setMessage(" File Approve with success");
        }
        return new ResponseEntity<>(messageResp, HttpStatus.OK);
    }
}
