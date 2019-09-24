
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/*
 
  @author Alcídia Cristina
 */
@Entity
public class Categoria implements Serializable {// 

    private Long id;
    private String nome;
    private List<Medicamentos> medicamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public List<Medicamentos> getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(List<Medicamentos> medicamento) {
        this.medicamento = medicamento;
    }
    
}
    
    
    /*
    @ManyToMany(mappedBy = "categoria")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Produto> getProdutos() {
        return medicamento;
    }

    public void setProdutos(List<Produto> medicamento) {
        this.medicamento = medicamento;
    }
    */

   
