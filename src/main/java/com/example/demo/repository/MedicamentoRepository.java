
package com.example.demo.repository;


import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/*
 
  @author Alcídia Cristina
 */
public interface MedicamentoRepository extends JpaRepository<Medicamentos, Long> {
    
   
    
List<Medicamentos> findyByNomeOrPrincipioAtivoOrderbyPrecoAsc(@Param("nome")String nome,@Param("principioAtivo")String principioAtivo);
 
        
    }
       
