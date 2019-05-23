
package com.example.demo.repository;

import com.example.demo.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/*
 
  @author Alcídia Cristina
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    public Administrador findByLoginAndSenha(@Param("login")String login,@Param("senha")String senha);
    
}
