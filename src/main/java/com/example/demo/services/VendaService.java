
package com.example.demo.services;

import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 
  @author Alcídia Cristina
 */
@Service
public class VendaService {
    
    @Autowired   
    VendaRepository vendaRepository;
    
    public void cadastrarVenda(Venda ven) {
        vendaRepository.save(ven);
    }

    public Venda editarVenda(Venda ven) {
       return vendaRepository.save(ven);
    }

    public void excluirVenda(Long id) {
        vendaRepository.deleteById(id);
    }

    public Venda buscaVenda(Long id) {
        return vendaRepository.findById(id).get();
    }
    
}
