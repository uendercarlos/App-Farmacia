
package com.example.demo.repository;

import com.example.demo.model.Carrinho;
import com.example.demo.model.ItemCarrinho;
import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

/*
 
  @author Alcídia Cristina
 */
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

//    @Modifying
//    @Query("delete from ItemCarrinho i where i.carrinho.id = ?1")
//    void apagaItensCarrinho(long idCarrinho);
    public ItemCarrinho findByProdutoAndCarrinho(Produto prod, Carrinho car);

    @Modifying
    public void deleteByCarrinho(Carrinho car);

}
