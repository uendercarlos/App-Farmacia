
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 
  @author Alcídia Cristina
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findByCategoria(Categoria categoria);
    
}
