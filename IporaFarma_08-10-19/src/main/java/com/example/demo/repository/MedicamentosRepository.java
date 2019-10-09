
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/*
 
  @author Alcídia Cristina
 */
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
    public List<Medicamentos> findByCategoria(Categoria categoria);
    
    
    public List<Medicamentos> findByNomeOrPrincipioAtivoOrderByPrecoAsc(@Param("nome")String nome,@Param("principioAtivo")String principioAtivo);
 
 
}
