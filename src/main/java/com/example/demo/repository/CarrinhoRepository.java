
package com.example.demo.repository;

import com.example.demo.model.Carrinho;
import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


/*
 
  @author Alcídia Cristina
 */
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    public Carrinho findByCliente(Cliente cli);
    
    
    
    
}
