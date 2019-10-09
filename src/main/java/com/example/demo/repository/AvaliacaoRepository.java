/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Avaliacao;
import com.example.demo.model.AvaliacaoId;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Cristina
 */
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AvaliacaoId>{

    

    public void deleteById(Avaliacao ava);

    

    public Avaliacao findById(Avaliacao ava);


   
    
    
}
