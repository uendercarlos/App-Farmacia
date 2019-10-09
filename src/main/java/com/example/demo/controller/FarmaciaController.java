
package com.example.demo.controller;

import com.example.demo.services.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Farmacia;
import com.example.demo.config.Autenticacao;
import com.example.demo.model.Medicamentos;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 
  @author Alcídia Cristina
 */
@RestController
@RequestMapping(value = "/admin")
public class FarmaciaController {
    
    @Autowired
    FarmaciaService farmaciaService;
    
    
    @RequestMapping(method = RequestMethod.POST,value = "/autenticar",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticar(@RequestBody Farmacia adm) {

        Farmacia admAuth = farmaciaService.autenticarAdministrador(adm);

        if (admAuth == null || admAuth.getLogin().equals("") || admAuth.getSenha().equals("")) {
            return new ResponseEntity<>(admAuth, HttpStatus.FORBIDDEN);
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(admAuth.getLogin());
        jwtBuilder.claim("adm", true);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000));
        jwtBuilder.signWith(Autenticacao.key);

        String token = jwtBuilder.compact();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.OK);

    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/admin/farmacia", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarFarmacia(@RequestBody Farmacia adm) {

    adm.setId(null);
         
    if(farmaciaService.cadastrarFarmacia(adm)== null){
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }
        return new ResponseEntity(HttpStatus.CREATED);

    }

    
    
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/admin/farmacia/{id}")
    ResponseEntity excluirFarmacia(@PathVariable Long id) {
       farmaciaService.excluirFarmacia(id);
              return new ResponseEntity(HttpStatus.OK);
    }

    
    @RequestMapping(method = RequestMethod.PUT, value = "/admin/farmacia",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAvaliacao(@RequestBody Farmacia adm) {

        farmaciaService.editarFarmacia(adm);

        return new ResponseEntity(HttpStatus.OK);

    }
    
    
    @RequestMapping(method = RequestMethod.GET,
            value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Farmacia> buscaFarmacia(@PathVariable Long id) {
        
        Farmacia adm;
        try {
            adm = farmaciaService.buscarFarmacia(id);
            adm.setId(null);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adm, HttpStatus.OK);
    }
    
    
    
}
        
        
        
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
