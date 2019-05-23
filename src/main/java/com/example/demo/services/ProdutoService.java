
package com.example.demo.services;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 
  @author Alcídia Cristina
 */
@Service
public class ProdutoService {
    
    @Autowired   
    ProdutoRepository produtoRepository;
    
    public Produto cadastrarProduto(Produto pro) {
       return produtoRepository.save(pro);
    }

    public Produto editarProduto(Produto pro) {
       return produtoRepository.save(pro);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto buscaProduto(Long id) {
        return produtoRepository.findById(id).get();
    }
    
    public List<Produto> buscaTodosProdutos(){
        return produtoRepository.findAll();
        
    }
    
}
