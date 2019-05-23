
package com.example.demo.repository;

import com.example.demo.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 
  @author Alcídia Cristina
 */
public interface VendaRepository extends JpaRepository<Venda, Long> {
    
}
