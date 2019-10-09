
package com.example.demo.repository;

import com.example.demo.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/*
 
  @author Alcídia Cristina
 */
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {

    public Farmacia findByLoginAndSenha(@Param("login")String email,@Param("senha")String senha);
    
}
