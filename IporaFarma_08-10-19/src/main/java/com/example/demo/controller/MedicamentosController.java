
package com.example.demo.controller;

import com.example.demo.model.Farmacia;
import com.example.demo.model.Medicamentos;
import com.example.demo.service.FarmaciaService;
import com.example.demo.service.MedicamentosService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 
  @author Alcídia Cristina
 */

@RestController
@RequestMapping(value = "/")
public class MedicamentosController {
    
    @Autowired
    private MedicamentosService produtoService;
    
    @Autowired
    private FarmaciaService farmaciaService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto")
    public ResponseEntity cadastrarProduto(@RequestBody Medicamentos produto, @RequestHeader HttpHeaders headers){
        
         //Obter através do token a farmácia que está cadastrando.
            //produto.setFarmacia(farmaciaRecuperadaAtravésDoToken)

        try {
         
            produto.setFarmacia(farmaciaService.buscaFarmaciaToken(headers));
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        produtoService.cadastrarMedicamento(produto);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
   
    @RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarProduto(@PathVariable Long id, @RequestHeader HttpHeaders headers){
        
        
        
        Medicamentos produto = produtoService.consultarMedicamento(id);
        
        return new ResponseEntity(produto, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarTodosProduto(){
        List<Medicamentos> produtos = produtoService.buscaTodosProdutos();
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/menor/produto", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Medicamentos> ordenarPorMenorPreco(String nome, String principioAtivo){
        List<Medicamentos> produtos = produtoService.ordenarPorMenorPreco(nome, principioAtivo);
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto")
    public ResponseEntity editaProduto(@RequestBody Medicamentos produto, @RequestHeader HttpHeaders headers){
        
        try{
            produto.setFarmacia(farmaciaService.buscaFarmaciaToken(headers));     
        }catch(Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
        produtoService.alterarMedicamento(produto);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id, @RequestHeader HttpHeaders headers){
        
        Farmacia adm;
          try {
         
            adm = farmaciaService.buscaFarmaciaToken(headers);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
          
        produtoService.desabilitarMedicamento(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
