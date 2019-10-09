
package com.example.demo.controller;

import com.example.demo.model.Medicamentos;
import com.example.demo.service.MedicamentosService;
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
@RequestMapping(value = "/")
public class MedicamentosController {
    
    @Autowired
    private MedicamentosService produtoService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto")
    public ResponseEntity cadastrarProduto(@RequestBody Medicamentos produto){
        produtoService.cadastrarProduto(produto);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarProduto(@PathVariable Long id){
        Medicamentos produto = produtoService.buscaProduto(id);
        
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
    public ResponseEntity editaProduto(@RequestBody Medicamentos produto){
        produtoService.editarProduto(produto);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/adminAut/produto/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id){
        
        System.out.println("id do produto: " + id);
        produtoService.excluirProduto(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
