
package com.example.demo.services;

import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MedicamentoRepository;

/*
 
  @author Alcídia Cristina
 */
@Service
public class MedicamentoService {
    
    @Autowired   
    MedicamentoRepository medicamentoRepository;
    
    public Medicamentos cadastrarMedicamento(Medicamentos pro) {
       return medicamentoRepository.save(pro);
    }

    public Medicamentos editarMedicamento(Medicamentos pro) {
       return medicamentoRepository.save(pro);
    }

    public void excluirMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }

    public Medicamentos consultaMedicamento(Long id) {
        return medicamentoRepository.findById(id).get();
    }
    
    public List<Medicamentos> consultaTodosMedicamentos(){
        return medicamentoRepository.findAll();
    }
    
    
    
    List<Medicamentos> ordenarPorMenorPreco(String nome, String principioAtivo){
        
    
        return medicamentoRepository.findyByNomeOrPrincipioAtivoOrderbyPrecoAsc(nome, principioAtivo);
        
    }
    
    
    
    
    
}


    
     
    


   

