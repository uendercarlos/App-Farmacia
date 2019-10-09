
package com.example.demo.controller;

import com.example.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Farmacia;
import com.example.demo.config.Autenticacao;
import com.example.demo.model.Medicamentos;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.List;
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
@RequestMapping(value = "/administrador")
public class FarmaciaController {
    
    @Autowired
    FarmaciaService admnistradorService;
    
    @RequestMapping(method = RequestMethod.POST,value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticar(@RequestBody Farmacia adm) {

        Farmacia admAuth = admnistradorService.autenticarAdministrador(adm);

        if (admAuth == null || admAuth.getLogin().equals("") || admAuth.getSenha().equals("")) {
            return new ResponseEntity<>(admAuth, HttpStatus.FORBIDDEN);
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(admAuth.getLogin());
        jwtBuilder.claim("adm", true);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 70 * 60 * 1000));
        jwtBuilder.signWith(Autenticacao.key);

        String token = jwtBuilder.compact();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.OK);

    }
    
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/cadastrarfarmacia", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarAdministrador(@RequestBody Farmacia adm) {

        admnistradorService.cadastrarAdministrador(adm);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    ResponseEntity removerAdministrador(@PathVariable Long id) {

        admnistradorService.removerAdministrador(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    
    
    
    /*
    @RequestMapping(method = RequestMethod.PUT, value = "/editaadministrador/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAdministrador(@RequestBody Administrador adm) {
        admnistradorService.editarAdministrador(adm);
        return new ResponseEntity(HttpStatus.CREATED);

    }
*/    

     @RequestMapping(method = RequestMethod.PUT, value = "/editaadministrador/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAdministrador(@RequestBody Farmacia adm) {

        admnistradorService.editarAdministrador(adm);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/administrador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Farmacia> mostraAdministrador(@PathVariable Long id) {

        Farmacia adm;
        try {
            adm = admnistradorService.buscaAdministrador(id);

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adm, HttpStatus.OK);
    }
    
    
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/administradores", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List <Farmacia>> mostraTodosAdministrador(){
    
            List <Farmacia> adm;
        try {
            adm = admnistradorService.buscaTodos();

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adm, HttpStatus.OK);
    }
    
    
    
    
    
}
