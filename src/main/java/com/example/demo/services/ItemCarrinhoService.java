
package com.example.demo.services;

import com.example.demo.model.Carrinho;
import com.example.demo.model.ItemCarrinho;
import com.example.demo.model.Produto;
import com.example.demo.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 
  @author Alcídia Cristina
 */

@Service
public class ItemCarrinhoService {
    
    @Autowired  
    ItemCarrinhoRepository itemCarrinhoRepository;
    
    public ItemCarrinho salvarItemCarrinho(ItemCarrinho itCar) {
       return itemCarrinhoRepository.save(itCar);
    }
    
    public void excluirItemCarrinho(Long id) {
        itemCarrinhoRepository.deleteById(id);
    }
    
    public ItemCarrinho buscaItemCarrinho(Carrinho car, Produto prod){
        return itemCarrinhoRepository.findByProdutoAndCarrinho(prod, car);
    
    }

    
}
