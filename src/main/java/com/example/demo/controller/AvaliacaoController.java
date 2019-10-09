

package com.example.demo.controller;

import com.example.demo.model.Avaliacao;
import com.example.demo.model.Cliente;
import com.example.demo.services.AvaliacaoService;
import com.example.demo.services.ClienteService;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;
    
    
     @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarAvaliacao(@RequestBody Avaliacao ava) {

        avaliacaoService.cadastrarAvaliacao(ava);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/{id}")
    ResponseEntity excluirAvaliacao(@RequestBody Avaliacao ava) {

       avaliacaoService.excluirAvaliacao(ava);
       
       return new ResponseEntity(HttpStatus.OK);
    } 
    
    
    
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAvaliacao(@RequestBody Avaliacao ava) {

        avaliacaoService.editarAvaliacao(ava);

        return new ResponseEntity(HttpStatus.OK);

    }
    
    
    @RequestMapping(method = RequestMethod.GET,
            value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Avaliacao> consultarAvaliacao(@RequestBody Avaliacao ava) {
        
  
        try {
            ava = avaliacaoService.consultarAvaliacao(ava);

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(ava, HttpStatus.OK);
    }
}
