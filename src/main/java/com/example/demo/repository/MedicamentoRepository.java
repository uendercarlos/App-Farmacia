
package com.example.demo.repository;


import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/*
 
  @author Alcídia Cristina
 */
public interface MedicamentoRepository extends JpaRepository<Medicamentos, Long> {
    
    
    
  /* public List<Medicamentos> findyByNomeAndPrincipioAtivoOrderbyPrecoAsc(@Param("nome")String nome,@Param("principio ativo") String principioAtivo,@Param("preco") double preco);
 */
        
    }
       
