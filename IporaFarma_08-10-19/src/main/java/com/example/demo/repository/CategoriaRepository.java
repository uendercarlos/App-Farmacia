
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 
  @author Alcídia Cristina
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    
}
