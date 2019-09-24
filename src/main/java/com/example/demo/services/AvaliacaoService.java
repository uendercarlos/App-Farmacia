

package com.example.demo.services;

import com.example.demo.model.Avaliacao;
import com.example.demo.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class AvaliacaoService {
    @Autowired   
    AvaliacaoRepository avaliacaoRepository;
    
 
    public void cadastrarAvaliacao(Avaliacao ava) {
        avaliacaoRepository.save(ava);
    }

    public Avaliacao editarAvaliacao(Avaliacao ava) {
       return avaliacaoRepository.save(ava);
    }

    public void excluirAvaliacao(Avaliacao ava) {
        avaliacaoRepository.deleteById(ava);
    }

    public Avaliacao consultarAvaliacao(Avaliacao ava) {
        return avaliacaoRepository.findById(ava);
    }


   
    
}
