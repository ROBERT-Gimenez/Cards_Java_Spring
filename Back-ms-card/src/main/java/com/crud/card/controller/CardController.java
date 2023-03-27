package com.crud.card.controller;

import com.crud.card.modelo.Card;
import com.crud.card.modelo.ModelService;
import com.crud.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")//cualquier cliente va a poder consumir nuestro cliente
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/list")
    public ResponseEntity<List<Card>> list(){
        var result = cardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ModelService> save(@RequestBody Card card){
        ModelService serviceResp = new ModelService();
        int result = cardService.save(card);
        if(result==1){
            serviceResp.setSuccess(true);
            serviceResp.setMessage("Item saved with success");
        }
        return new ResponseEntity<>(serviceResp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ModelService> update(@RequestBody Card card){
        ModelService serviceResp = new ModelService();
        int result = cardService.update(card);
        if(result==1){
            serviceResp.setSuccess(true);
            serviceResp.setMessage("Item update with success");
        }
        return new ResponseEntity<>(serviceResp, HttpStatus.OK);
    }

   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<ModelService> update(@PathVariable int id){
        ModelService serviceResp = new ModelService();
        int result = cardService.deleteById(id);
        if(result==1){
            serviceResp.setSuccess(true);
            serviceResp.setMessage("Item remove with success");
        }
        return new ResponseEntity<>(serviceResp, HttpStatus.OK);
    }*/@PutMapping("/delete/{id}")
    public ResponseEntity<ModelService> update(@PathVariable int id){
        ModelService serviceResp = new ModelService();
        int result = cardService.deleteById(id);
        if(result==1){
            serviceResp.setSuccess(true);
            serviceResp.setMessage("Item remove with success");
        }
        return new ResponseEntity<>(serviceResp, HttpStatus.OK);
    }
/*
    @GetMapping
    @ResponseBody
    public String[] getArray() {
        return new String[]{"hola", "mundo", "!"};
    }*/
}