
package com.example.demo.controller;

import com.example.demo.model.Medicamentos;
import com.example.demo.services.MedicamentoService;
import java.util.List;
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

/*
 
  @author Alcídia Cristina
 */
@RestController
public class MedicamentoController {
    
    @Autowired
    MedicamentoService medicamentoService;
    @RequestMapping(method = RequestMethod.POST,value = "/admin/produto", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarProduto(@RequestBody Medicamentos pro) {

    pro.setId(null);
        
     if(medicamentoService.cadastrarMedicamento(pro) == null){
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }
        return new ResponseEntity(HttpStatus.CREATED);

    }

    
    
    
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/admin/produto/{id}")
    ResponseEntity removerProduto(@PathVariable Long id) {
       medicamentoService.excluirMedicamento(id);
              return new ResponseEntity(HttpStatus.OK);
    }

    
    
    
    @RequestMapping(method = RequestMethod.PUT, value = "/admin/produto")
    void editarProduto() {
        System.out.println("edita");
    }

    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Medicamentos> mostraProduto(@PathVariable Long id) {
        
        Medicamentos pro;
        try {
            pro = medicamentoService.consultaMedicamento(id);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(pro, HttpStatus.OK);
    }
    
    
    
    //atividade loja
    @RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List <Medicamentos>> mostraTodosProdutos(){
                List <Medicamentos> pro;
        try {
            pro = medicamentoService.consultaTodosMedicamentos();

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(pro, HttpStatus.OK);
    }
    
    /*
    @RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List <Medicamentos>> ordenarPorMenorPreco(String nome, String principioAtivo, double preco){
                List <Medicamentos> pro;
        try {
            pro = medicamentoService.ordenarPorMenorPreco(nome, principioAtivo, preco);

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(pro, HttpStatus.OK);
    }
    
    */
}
