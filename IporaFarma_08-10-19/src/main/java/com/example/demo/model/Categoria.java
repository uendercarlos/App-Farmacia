/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.SQLDelete;

/**
 *
 * @author Alcidia Cristina
 */
@Entity
public class Categoria {
    private Long id;
    private String nome;
    private List<Medicamentos> medicamento;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy = "categoria")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Medicamentos> getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(List<Medicamentos> medicamento) {
        this.medicamento = medicamento;
    }
    
    
}
